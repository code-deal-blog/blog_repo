package org.onlineshoppingportal.dao;

import org.onlineshoppingportal.entity.Account;

public interface AccountDao {
	public Account findAccount(String userName );
	public void saveAccount(Account account);
}
