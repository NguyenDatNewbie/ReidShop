/**
 * 
 */
package reidshop.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import reidshop.Connection.ConnectDB;
import reidshop.DAO.IAccountDAO;
import reidshop.Entity.Account;

/**
 * @author Administrator
 *
 */
public class AccountDAOImpl extends ConnectDB implements IAccountDAO {
	
	@Override
	public void Insert(Account Ac)
	{
		String sql = "Insert into Account Values(?,?,?)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,Ac.getUsername());
			ps.setString(2,Ac.getPassword());
			ps.setInt(3,Ac.getRole());
			ps.executeUpdate();
		}catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	// Chỉ dc đổi password hoặc quyền
	@Override
	public void Update(Account Ac){
		String sql = "UPDATE  Account SET password=?, role=? where id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,Ac.getPassword());
			ps.setInt(2,Ac.getRole());
			ps.setInt(3,Ac.getId());
			ps.executeUpdate();
		}catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	@Override
	public void Delete(int id){
		String sql = "Delete From Account where id=?";
		try	{
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}

	@Override
	public List<Account> getAll(){
		String sql = "SELECT *from Account";
		List<Account> accounts = new ArrayList<>();
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int role = rs.getInt("role");
				Account account = new Account(id,username,password,role);
				accounts.add(account);
			}
		}catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return accounts;
	}

	@Override
	public Account getAccount(int id){
		String sql = "SELECT *from Account where id=?";
		Account account = new Account();
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				String username = rs.getString("username");
				String password = rs.getString("password");
				int role = rs.getInt("role");
				account = new Account(id,username,password,role);
			}
		}catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return account;
	}
}
