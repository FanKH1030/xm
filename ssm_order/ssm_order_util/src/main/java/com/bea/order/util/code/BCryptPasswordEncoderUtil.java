package com.bea.order.util.code;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by fandi on 2020/6/17 0017.
 */
public class BCryptPasswordEncoderUtil {
	private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	public static String encode(String code) {
		return bCryptPasswordEncoder.encode(code);
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			String encode = BCryptPasswordEncoderUtil.encode("123456");
			System.out.println(encode);
			
		}
	}
	
}
