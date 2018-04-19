package model.dao;

import java.util.ArrayList;
import java.util.List;

import model.bean.Account;

public class AccountDAO {
	List<Account> data = new ArrayList<>();
	Account now;

	public AccountDAO() {
		Account a1 = new Account();
		a1.setUsername("chipheo");
		a1.setPassword("1");
		a1.setInfo("Anh đây quậy phá khắp đất trời.");

		Account a2 = new Account();
		a2.setUsername("thino");
		a2.setPassword("2");
		a2.setInfo("Chẳng đẹp diệu dàng lại kém duyên.");

		data.add(a1);
		data.add(a2);
	}

	public boolean login(String username, String password) {
		for (int i = 0; i < data.size(); i++) {
			if (username.equals(data.get(i).getUsername()) && password.equals(data.get(i).getPassword())) {
				now = data.get(i);
				System.out.println(now.getUsername());
				return true;
			}
		}
		now = null;
		return false;
	}

	public Account getInfo() {
		return now;
	}
	public List<Account> getListInfo() {
		return data;
	}
}
