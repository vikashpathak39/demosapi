package com.org.sapi.service;

import com.org.sapi.bean.User;

public interface AccountService {

	public User getAccountByName(String name) throws Exception;
}
