package com.org.sapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.sapi.service.AccountService;

@RestController
@RequestMapping("/demosapi")
public class Controller {
	
	@Autowired
	AccountService accountService; 
	
	@RequestMapping(value = "{name}/account")
	public ResponseEntity<Object> getProducts(@PathVariable ("name") String name) throws Exception {
		return new ResponseEntity<Object>(accountService.getAccountByName(name), HttpStatus.OK); 
	}

}
