package com.moneydesktop.finance.database;

import java.util.List;
import com.moneydesktop.finance.database.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here

import org.json.JSONObject;

import com.moneydesktop.finance.ApplicationContext;
import com.moneydesktop.finance.database.AccountTypeDao.Properties;

import de.greenrobot.dao.AbstractDao;
// KEEP INCLUDES END
/**
 * Entity mapped to table ACCOUNT_TYPE.
 */
public class AccountType extends BusinessObject  {

    private Long id;
    private String accountTypeId;
    private String accountTypeName;
    private Integer aggregationType;
    private Integer financialAccountType;
    private String groupKey;
    private long businessObjectId;
    private Long accountTypeGroupId;
    private Long parentAccountTypeId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient AccountTypeDao myDao;

    private BusinessObjectBase businessObjectBase;
    private Long businessObjectBase__resolvedKey;

    private AccountTypeGroup accountTypeGroup;
    private Long accountTypeGroup__resolvedKey;

    private AccountType parent;
    private Long parent__resolvedKey;

    private List<BankAccount> bankAccounts;
    private List<AccountType> children;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public AccountType() {
    }

    public AccountType(Long id) {
        this.id = id;
    }

    public AccountType(Long id, String accountTypeId, String accountTypeName, Integer aggregationType, Integer financialAccountType, String groupKey, long businessObjectId, Long accountTypeGroupId, Long parentAccountTypeId) {
        this.id = id;
        this.accountTypeId = accountTypeId;
        this.accountTypeName = accountTypeName;
        this.aggregationType = aggregationType;
        this.financialAccountType = financialAccountType;
        this.groupKey = groupKey;
        this.businessObjectId = businessObjectId;
        this.accountTypeGroupId = accountTypeGroupId;
        this.parentAccountTypeId = parentAccountTypeId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getAccountTypeDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(String accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public Integer getAggregationType() {
        return aggregationType;
    }

    public void setAggregationType(Integer aggregationType) {
        this.aggregationType = aggregationType;
    }

    public Integer getFinancialAccountType() {
        return financialAccountType;
    }

    public void setFinancialAccountType(Integer financialAccountType) {
        this.financialAccountType = financialAccountType;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    public long getBusinessObjectId() {
        return businessObjectId;
    }

    public void setBusinessObjectId(long businessObjectId) {
        this.businessObjectId = businessObjectId;
    }

    public Long getAccountTypeGroupId() {
        return accountTypeGroupId;
    }

    public void setAccountTypeGroupId(Long accountTypeGroupId) {
        this.accountTypeGroupId = accountTypeGroupId;
    }

    public Long getParentAccountTypeId() {
        return parentAccountTypeId;
    }

    public void setParentAccountTypeId(Long parentAccountTypeId) {
        this.parentAccountTypeId = parentAccountTypeId;
    }

    /** To-one relationship, resolved on first access. */
    public BusinessObjectBase getBusinessObjectBase() {
        long __key = this.businessObjectId;
        if (businessObjectBase__resolvedKey == null || !businessObjectBase__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BusinessObjectBaseDao targetDao = daoSession.getBusinessObjectBaseDao();
            BusinessObjectBase businessObjectBaseNew = targetDao.load(__key);
            synchronized (this) {
                businessObjectBase = businessObjectBaseNew;
            	businessObjectBase__resolvedKey = __key;
            }
        }
        return businessObjectBase;
    }

    public void setBusinessObjectBase(BusinessObjectBase businessObjectBase) {
        if (businessObjectBase == null) {
            throw new DaoException("To-one property 'businessObjectId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.businessObjectBase = businessObjectBase;
            businessObjectId = businessObjectBase.getId();
            businessObjectBase__resolvedKey = businessObjectId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public AccountTypeGroup getAccountTypeGroup() {
        Long __key = this.accountTypeGroupId;
        if (accountTypeGroup__resolvedKey == null || !accountTypeGroup__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AccountTypeGroupDao targetDao = daoSession.getAccountTypeGroupDao();
            AccountTypeGroup accountTypeGroupNew = targetDao.load(__key);
            synchronized (this) {
                accountTypeGroup = accountTypeGroupNew;
            	accountTypeGroup__resolvedKey = __key;
            }
        }
        return accountTypeGroup;
    }

    public void setAccountTypeGroup(AccountTypeGroup accountTypeGroup) {
        synchronized (this) {
            this.accountTypeGroup = accountTypeGroup;
            accountTypeGroupId = accountTypeGroup == null ? null : accountTypeGroup.getId();
            accountTypeGroup__resolvedKey = accountTypeGroupId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public AccountType getParent() {
        Long __key = this.parentAccountTypeId;
        if (parent__resolvedKey == null || !parent__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AccountTypeDao targetDao = daoSession.getAccountTypeDao();
            AccountType parentNew = targetDao.load(__key);
            synchronized (this) {
                parent = parentNew;
            	parent__resolvedKey = __key;
            }
        }
        return parent;
    }

    public void setParent(AccountType parent) {
        synchronized (this) {
            this.parent = parent;
            parentAccountTypeId = parent == null ? null : parent.getId();
            parent__resolvedKey = parentAccountTypeId;
        }
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<BankAccount> getBankAccounts() {
        if (bankAccounts == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BankAccountDao targetDao = daoSession.getBankAccountDao();
            List<BankAccount> bankAccountsNew = targetDao._queryAccountType_BankAccounts(id);
            synchronized (this) {
                if(bankAccounts == null) {
                    bankAccounts = bankAccountsNew;
                }
            }
        }
        return bankAccounts;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetBankAccounts() {
        bankAccounts = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<AccountType> getChildren() {
        if (children == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AccountTypeDao targetDao = daoSession.getAccountTypeDao();
            List<AccountType> childrenNew = targetDao._queryAccountType_Children(id);
            synchronized (this) {
                if(children == null) {
                    children = childrenNew;
                }
            }
        }
        return children;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetChildren() {
        children = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    // KEEP METHODS - put your custom methods here
    
    public void setExternalId(String id) {
    	setAccountTypeId(id);
    	getBusinessObjectBase().setExternalId(id);
    }
    
    public String getExternalId() {
    	return getAccountTypeId();
    }
    
    public static AccountType getAccountType(String accountTypeId) {
    	
    	AccountType accountType = null;
    	
    	if (accountTypeId == null || accountTypeId.equals(""))
    		return accountType;
    	
    	AccountTypeDao atDao = ApplicationContext.getDaoSession().getAccountTypeDao();
    	
    	List<AccountType> accountTypes = atDao.queryBuilder().where(Properties.Id.eq(accountTypeId)).list();
    	
    	if (accountTypes.size() > 0)
    		accountType = accountTypes.get(0);
    	
    	return accountType;
    }
    
    public static AccountType createAccountType(String id, String accountTypeName, Integer aggregationType, Integer financialAccountType, String parentAccountTypeId) {
    	
    	long parentId = parentAccountTypeId == null ? 0L : Long.valueOf((new String(parentAccountTypeId)).hashCode());
    	AccountType accountType = new AccountType(Long.valueOf((new String(id)).hashCode()), id, accountTypeName, aggregationType, financialAccountType, null, 0L, 0L, parentId);
    	
    	return accountType;
    }
    
    public JSONObject getJson() {
    	return null;
    }
    // KEEP METHODS END

}
