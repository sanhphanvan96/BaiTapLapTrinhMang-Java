package model.bo;

import java.util.List;

import model.bean.Account;
import model.dao.AccountDAO;

public class AccountBO {
	AccountDAO adao;

	public boolean login(String username, String password) {
		adao = new AccountDAO();
		return adao.login(username, password);
	}

	public Account getInfo() {
		return adao.getInfo();
	}
}
