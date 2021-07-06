package com.revature.db.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.db.connection.ConnectionFactory;
import com.revature.db.entity.Transfer;

public class TransferRepositoryImpl implements TransferRepository{

	public void save(Transfer transfer) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			
			String sql = "insert into transfer values (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, transfer.getTransactionId());
			ps.setTime(2, transfer.getDateAndTime());
			ps.setInt(3, transfer.getAmount());
			ps.setString(4, transfer.getCreditOrDebit());
			ps.setInt(5, transfer.getBalance());
			
			int count = ps.executeUpdate();
			if(count == 1)
			{
				System.out.println("Transaction recorded");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
