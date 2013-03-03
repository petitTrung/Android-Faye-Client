package com.moneydesktop.finance.shared.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.moneydesktop.finance.shared.fragment.GrowFragment;
import com.moneydesktop.finance.views.GrowViewPager.OnScrollChangedListener;

public abstract class GrowPagerAdapter extends FragmentPagerAdapter implements OnPageChangeListener, OnScrollChangedListener {

    public final String TAG = this.getClass().getSimpleName();
    
    public static final float BASE_SIZE = 0.8f;
    public static final float BASE_ALPHA = 0.95f;
    
    private int mCurrentPage = 0;
    private boolean mScrollingLeft;
    
	private GrowFragment[] mFragments;

	private OnScrollStateChangedListener mOnScrollStateChangedListener;

	public int getCurrentPage() {
		return mCurrentPage;
	}

	public void setOnScrollStateChangedListener(OnScrollStateChangedListener mOnScrollStateChangedListener) {
		this.mOnScrollStateChangedListener = mOnScrollStateChangedListener;
	}

	public void addFragment(GrowFragment fragment) {
		mFragments[fragment.getPosition()] = fragment;
	}

	public GrowPagerAdapter(FragmentManager fm) {
		super(fm);

		mFragments = new GrowFragment[getCount()];
	}

    @Override
    public void onPageScrollStateChanged(int state) {
    	
    	if (mOnScrollStateChangedListener != null) {
    		mOnScrollStateChangedListener.onScrollStateChanged(state);
    	}
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        adjustSize(position, positionOffset);
    }

    @Override
    public void onPageSelected(int position) {
        mCurrentPage = position;
    }
    
    /**
     * Used to adjust the size of each view in the viewpager as the user
     * scrolls.  This provides the effect of children scaling down as they
     * are moved out and back to full size as they come into focus.
     * 
     * @param position
     * @param percent
     */
    private void adjustSize(int position, float percent) {
        
        position += (mScrollingLeft ? 1 : 0);
        int secondary = position + (mScrollingLeft ? -1 : 1);
        int tertiary = position + (mScrollingLeft ? 1 : -1);
        
        float scaleUp = mScrollingLeft ? percent : 1.0f - percent;
        float scaleDown = mScrollingLeft ? 1.0f - percent : percent;

        float percentOut = scaleUp > BASE_ALPHA ? BASE_ALPHA : scaleUp;
        float percentIn = scaleDown > BASE_ALPHA ? BASE_ALPHA : scaleDown;
        
        if (scaleUp < BASE_SIZE) scaleUp = BASE_SIZE;

        if (scaleDown < BASE_SIZE) scaleDown = BASE_SIZE;
        
        // Adjust the fragments that are, or will be, on screen
        GrowFragment current = (position < mFragments.length) ? mFragments[position] : null;
        GrowFragment next = (secondary < mFragments.length && secondary > -1) ? mFragments[secondary] : null;
        GrowFragment afterNext = (tertiary < mFragments.length && tertiary > -1) ? mFragments[tertiary] : null;
        
        if (current != null && next != null) {
            
            // Apply the adjustments to each fragment
            current.transitionFragment(percentIn, scaleUp);
            next.transitionFragment(percentOut, scaleDown);
            
            if (afterNext != null && getCount() > 2) {
                afterNext.transitionFragment(BASE_ALPHA, BASE_SIZE);
            }
        }
    }

    @Override
    public void onScrollChanged(int l, int t, int oldl, int oldt) {

        // Keep track of which direction we are scrolling
        mScrollingLeft = (oldl - l) < 0;
    }
    
    public interface OnScrollStateChangedListener {
    	public void onScrollStateChanged(int state);
    }
}
