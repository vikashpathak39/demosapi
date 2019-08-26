package com.org.sapi.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.org.sapi.bean.User;
import com.org.sapi.service.AccountService;
import com.org.sapi.util.CSVUtil;

@Service
public class AccountServiceImpl implements AccountService{

	@Override
	public User getAccountByName(String name) throws Exception{
	  
		File file = new File("data/data.csv");
		InputStream in = new FileInputStream(file);
		List<User> userList =CSVUtil.read(User.class, in);
		return CSVUtil.getUserByName(userList, name);

	}
		
}
