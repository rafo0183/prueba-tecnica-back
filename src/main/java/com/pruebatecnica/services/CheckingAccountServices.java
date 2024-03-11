package com.pruebatecnica.services;

import com.pruebatecnica.repository.CheckingAccount;

public interface CheckingAccountServices {
	CheckingAccount getCheckingAccountByUserId(Long userId);
}
