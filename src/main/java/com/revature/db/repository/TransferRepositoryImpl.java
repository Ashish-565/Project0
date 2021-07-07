package com.revature.db.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.db.connection.ConnectionFactory;
import com.revature.db.entity.Transfer;

public class TransferRepositoryImpl implements TransferRepository{

	public void save(Transfer transfer) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "insert into transfer values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, transfer.getTransactionId());
			ps.setTimestamp(2, transfer.getDateAndTime());
			ps.setInt(3, transfer.getAmount());
			ps.setString(4, transfer.getCreditOrDebit());
			
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

	public List<Transfer> getTransfers() {
		Connection con = null;

		List<Transfer> transferList = new ArrayList<Transfer>();

		try {
			con = ConnectionFactory.getConnection();

			String sql="select * from transfer";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Transfer transfer = new Transfer();
				transfer.setTransactionId(rs.getInt(1));
				transfer.setDateAndTime(rs.getTimestamp(2));
				transfer.setAmount(rs.getInt(3));
				transfer.setCreditOrDebit(rs.getString(4));
				transferList.add(transfer);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return transferList;
	}
	

}
