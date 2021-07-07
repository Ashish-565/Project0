package com.revature.db.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.db.connection.ConnectionFactory;

public class AccountRepositoryDbImpl implements AccountRepositoryDb{

	public boolean check(int account) {
		boolean flag = false;
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			
			String sql = "select count(*) from account_system where acc_num = "+account;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			int count = rs.getInt(1);
			if(count == 1)
			{
				flag = true;
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
		return flag;
	}

	public void update(int accountNumber,int balance) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			
			String sql = "update account_system set acc_bal = ? where acc_num = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, balance);
			ps.setInt(2, accountNumber);
			
			ps.executeUpdate();
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

	public int balance(int account) {
		int amount = 0;
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			
			String sql = "select acc_bal from account_system where acc_num = "+account;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			amount = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return amount;
	}

}
