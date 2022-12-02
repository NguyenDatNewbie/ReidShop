package reidshop.DAO;

import java.util.List;

import reidshop.Entity.InfoUser;

public interface IInfoUserDAO {

	void Insert(InfoUser info);

	// Chỉ dc đổi password hoặc quyền
	void Update(InfoUser info);

	void Delete(int id);

	List<InfoUser> getAll();

	InfoUser getInfoUser(int id);

}