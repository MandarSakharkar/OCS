package org.sunbeam.ocs.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component
public class AccountUtils {
	public static String getMD5Password(String password){
		MessageDigest md = null;
		try 
		{
			md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(password.getBytes());
			return new BigInteger(1,md.digest()).toString(16);
		} 
		catch (NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
		}
		return password;
	}
}
