package com.revature.projects.repositories;

import com.revature.projects.models.Account;

import java.util.List;

public interface AccountCustomRepository {

    List<Account> findAccountBalanceGreaterThan(double lowerLimit);

    List<Account> findAccountByType(String accountTypeInput);

    List<Account> findAccountByCustId(long customerIdInput);

    List<Account> findAccountByCustomerName(String customerNameInput);

    List<Account> findAccountByAccountActiveStatus(int accountActiveStatusInput);
}
