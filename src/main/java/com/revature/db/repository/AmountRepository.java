package com.revature.db.repository;

import com.revature.db.entity.Amount;

public interface AmountRepository {
	
	void save(Amount amount);

	void update(int accountNumber, int balance);
}
