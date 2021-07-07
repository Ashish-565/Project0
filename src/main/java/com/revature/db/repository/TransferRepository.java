package com.revature.db.repository;


import java.util.List;

import com.revature.db.entity.Transfer;

public interface TransferRepository {

	void save(Transfer transfer);
	
	List<Transfer> getTransfers();
	
}
