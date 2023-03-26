package com;

import com.dao.AdminDao;
import com.to.Admin;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CreateAdmin {

	public static void main(String[] args) {
		AdminDao ad = new AdminDao();

		// Encrypting password
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String bCryptedPassword = bCryptPasswordEncoder.encode("password");

		Admin a = new Admin("naresh", "naresh@gmail.com", bCryptedPassword);

		String response = ad.addAdmin(a);
		System.out.println(response);
	}

}
