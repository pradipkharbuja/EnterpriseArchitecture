package cs544.exercise8_1.bank.service;

import java.util.Collection;

import javax.transaction.Transactional;

import cs544.exercise8_1.bank.dao.IAccountDAO;
import cs544.exercise8_1.bank.domain.Account;
import cs544.exercise8_1.bank.domain.Customer;
import cs544.exercise8_1.bank.jms.IJMSSender;
import cs544.exercise8_1.bank.logging.ILogger;

public class AccountService implements IAccountService {

	private IAccountDAO accountDAO;
	private ICurrencyConverter currencyConverter;
	private IJMSSender jmsSender;
	private ILogger logger;

	public AccountService() {
		// accountDAO = new AccountDAOHibernate();
		// currencyConverter = new CurrencyConverter();
		// jmsSender = new JMSSender();
		// logger = new Logger();
	}

	public void setAccountDAO(IAccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public void setCurrencyConverter(ICurrencyConverter currencyConverter) {
		this.currencyConverter = currencyConverter;
	}

	public void setJmsSender(IJMSSender jmsSender) {
		this.jmsSender = jmsSender;
	}

	public void setLogger(ILogger logger) {
		this.logger = logger;
	}

	@Transactional
	public Account createAccount(long accountNumber, String customerName) {
		//Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.saveAccount(account);
		logger.log(
				"createAccount with parameters accountNumber= " + accountNumber + " , customerName= " + customerName);

		//tx.commit();
		return account;
	}

	@Transactional
	public void deposit(long accountNumber, double amount) {
		//Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
		logger.log("deposit with parameters accountNumber= " + accountNumber + " , amount= " + amount);
		if (amount > 10000) {
			jmsSender.sendJMSMessage("Deposit of $ " + amount + " to account with accountNumber= " + accountNumber);
		}

		//tx.commit();
	}

	@Transactional
	public Account getAccount(long accountNumber) {
		//Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

		Account account = accountDAO.loadAccount(accountNumber);

		//tx.commit();
		return account;
	}

	@Transactional
	public Collection<Account> getAllAccounts() {
		//Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		Collection<Account> accounts = accountDAO.getAccounts();
		//tx.commit();

		return accounts;
	}

	@Transactional
	public void withdraw(long accountNumber, double amount) {
		//Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
		logger.log("withdraw with parameters accountNumber= " + accountNumber + " , amount= " + amount);
		//tx.commit();
	}

	@Transactional
	public void depositEuros(long accountNumber, double amount) {
		//Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

		Account account = accountDAO.loadAccount(accountNumber);
		double amountDollars = currencyConverter.euroToDollars(amount);
		account.deposit(amountDollars);
		accountDAO.updateAccount(account);
		logger.log("depositEuros with parameters accountNumber= " + accountNumber + " , amount= " + amount);
		if (amountDollars > 10000) {
			jmsSender.sendJMSMessage("Deposit of $ " + amount + " to account with accountNumber= " + accountNumber);
		}
		//tx.commit();
	}

	@Transactional
	public void withdrawEuros(long accountNumber, double amount) {
		//Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

		Account account = accountDAO.loadAccount(accountNumber);
		double amountDollars = currencyConverter.euroToDollars(amount);
		account.withdraw(amountDollars);
		accountDAO.updateAccount(account);
		logger.log("withdrawEuros with parameters accountNumber= " + accountNumber + " , amount= " + amount);

		//tx.commit();
	}

	@Transactional
	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		//Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
		logger.log("transferFunds with parameters fromAccountNumber= " + fromAccountNumber + " , toAccountNumber= "
				+ toAccountNumber + " , amount= " + amount + " , description= " + description);
		if (amount > 10000) {
			jmsSender.sendJMSMessage("TransferFunds of $ " + amount + " from account with accountNumber= " + fromAccount
					+ " to account with accountNumber= " + toAccount);
		}
		//tx.commit();
	}
}
