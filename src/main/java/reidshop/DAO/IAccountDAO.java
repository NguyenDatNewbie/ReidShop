package reidshop.DAO;

import java.util.List;

import reidshop.Entity.Account;

public interface IAccountDAO {

	void Insert(Account Ac);

	// Chỉ dc đổi password hoặc quyền
	void Update(Account Ac);

	void Delete(int id);

	List<Account> getAll();

	Account getAccount(int id);

	public Account CheckLogin(String username, String password);

}