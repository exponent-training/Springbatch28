package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Login;
import com.example.demo.repo.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public void saveLoginData(Login login) {
		// TODO Auto-generated method stub
		loginRepository.save(login);
	}

	@Override
	public Login getLoginDetails(String uname, String pass) {
		// TODO Auto-generated method stub
		Login login = loginRepository.findByUnameAndPass(uname, pass);
		if(login != null ) {
			return login;
		}
		return null;
	}

}
