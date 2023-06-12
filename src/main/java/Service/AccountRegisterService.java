package Service;

import DAO.AccountDao;
import Entity.AccountEntity;
import Util.Utility;

public class AccountRegisterService {

	public static AccountEntity register(String name, String password) {
		AccountEntity accountEntity = new AccountEntity();
		password = Utility.digest(password);
		AccountDao accountdao = new AccountDao();
		int id = accountdao.countNumber();
		accountEntity.setId(id);
		accountEntity.setName(name);
		accountEntity.setPassword(password);

		return accountEntity;
	}
}
