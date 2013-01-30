package com.moneydesktop.finance.tablet.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.moneydesktop.finance.R;
import com.moneydesktop.finance.model.BarViewModel;
import com.moneydesktop.finance.views.BarGraphView;
import com.moneydesktop.finance.views.BarView;
import com.moneydesktop.finance.views.BasicBarChartAdapter;

import java.util.ArrayList;
import java.util.Random;

public class TestActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        ArrayList<BarViewModel> l = new ArrayList<BarViewModel>();
        l.add(new BarViewModel(" ",10,100));
        l.add(new BarViewModel(" ",20,100));
        l.add(new BarViewModel(" ",30,100));
        l.add(new BarViewModel(" ",40,100));
        l.add(new BarViewModel(" ",50,100));
        l.add(new BarViewModel(" ",75,100));
        l.add(new BarViewModel(" ",90,100));
        final BasicBarChartAdapter adapter = new BasicBarChartAdapter(l);
        final BarGraphView b = new BarGraphView(this,null);
        LinearLayout layout = (LinearLayout) findViewById(R.id.test_view);
        layout.addView(b);
        LayoutParams layout2 = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,4);
        b.setLayoutParams(layout2);
        b.setLabel(false);
        b.setMargin(5);
        Button button1 = new Button(this);
        layout.addView(button1);
        button1.setText("Set list to one bar");
        button1.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
               ArrayList<BarViewModel> oneBar = new ArrayList<BarViewModel>();
               oneBar.add(new BarViewModel(" ",75,100));
               adapter.setNewList(oneBar);               
            }
        });
        LayoutParams layout1 = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,1);
        button1.setLayoutParams(layout1);
        
        Button button2 = new Button(this);
        layout.addView(button2);
        button2.setText("Randomize");
        button2.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Random generator = new Random(System.nanoTime());
               b.changeBarValue(0, generator.nextInt(100)+1, true);
               b.changeBarColor(0, Color.argb(generator.nextInt(256), generator.nextInt(256), generator.nextInt(256), generator.nextInt(256)), true);
               b.changeBarValue(1, generator.nextInt(100)+1, true);
               b.changeBarColor(1, Color.argb(generator.nextInt(256), generator.nextInt(256), generator.nextInt(256), generator.nextInt(256)), true);
               b.changeBarValue(2, generator.nextInt(100)+1, true);
               b.changeBarColor(2, Color.argb(generator.nextInt(256), generator.nextInt(256), generator.nextInt(256), generator.nextInt(256)), true);
               b.changeBarValue(3, generator.nextInt(100)+1, true);
               b.changeBarColor(3, Color.argb(generator.nextInt(256), generator.nextInt(256), generator.nextInt(256), generator.nextInt(256)), true);
               b.changeBarValue(4, generator.nextInt(100)+1, true);
               b.changeBarColor(4, Color.argb(generator.nextInt(256), generator.nextInt(256), generator.nextInt(256), generator.nextInt(256)), true);
               b.changeBarValue(5, generator.nextInt(100)+1, true);
               b.changeBarColor(5, Color.argb(generator.nextInt(256), generator.nextInt(256), generator.nextInt(256), generator.nextInt(256)), true);
               b.changeBarValue(6, generator.nextInt(100)+1, true);
               b.changeBarColor(6, Color.argb(generator.nextInt(256), generator.nextInt(256), generator.nextInt(256), generator.nextInt(256)), true);
            }
        });
        button2.setLayoutParams(layout1);
        
    }
}
