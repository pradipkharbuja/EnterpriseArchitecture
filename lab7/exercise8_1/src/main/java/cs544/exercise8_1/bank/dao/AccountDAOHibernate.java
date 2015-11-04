package cs544.exercise8_1.bank.dao;

import java.util.Collection;

import org.hibernate.SessionFactory;

import cs544.exercise8_1.bank.domain.Account;

public class AccountDAOHibernate implements IAccountDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public Collection<Account> getAccounts() {
		// To prevent our Lazy Initialization problems
		// we don't have open session in view, so instead we have to eagerly
		// load!
		return sessionFactory.getCurrentSession()
				.createQuery("select distinct a from Account a " + "join fetch a.customer " + "join fetch a.entryList")
				.list();
	}

	public Account loadAccount(long accountnumber) {
		return (Account) sessionFactory.getCurrentSession().get(Account.class, accountnumber);
	}

	public void saveAccount(Account account) {
		sessionFactory.getCurrentSession().persist(account);
	}

	public void updateAccount(Account account) {
		sessionFactory.getCurrentSession().saveOrUpdate(account);
	}

}
