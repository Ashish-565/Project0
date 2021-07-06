package com.revature.db.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.db.connection.ConnectionFactory;
import com.revature.db.entity.Amount;

public class AmountRepositoryImpl implements AmountRepository{

	public void save(Amount amount) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			
			String sql = "insert into amount values (?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, amount.getAccountNumber());
			ps.setInt(2, amount.getAccountBalance());
			
			int count = ps.executeUpdate();
			if(count == 1)
			{
				System.out.println("Account added");
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

	public void update(int accountNumber,int balance) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			
			String sql = "update amount set acc_bal = ? where acc_num = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, balance);
			ps.setInt(2, accountNumber);
			
			int count = ps.executeUpdate();
			if(count == 1)
			{
				System.out.println("Balance updated");
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
