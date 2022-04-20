package com.shop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Security {
	 //It is used to check password with corresponding pattern.
		public static boolean isValidRegex(String regex, String credential) {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(credential);
			return matcher.matches();
		}
	    //It is used to check the user whether new user or already existing user.
		public  static boolean checknewOrAlreadyExistingUser(String user, String username) {
			boolean customer = user.equals("customer") && Storage.customersMap.containsKey(username);
			boolean seller = user.equals("seller") && Storage.sellersMap.containsKey(username);
			boolean admin = user.equals("admin") && Storage.adminMap.containsKey(username);
			if (customer || seller || admin) {
				return true;
			}
			return false;
		}
	// It is check user credentials for all users.
	public static boolean checkValidUser(String user, String username, String password) {
		if (user.equals("customer") && Storage.customersMap.get(username).getPassword().compareTo(password) == 0)
			return true;
		else if (user.equals("seller") && Storage.sellersMap.get(username).getPassword().compareTo(password) == 0)
			return true;
		else if (user.equals("admin") && Storage.adminMap.get(username).getPassword().compareTo(password) == 0)
			return true;
		return false;
	}

	public static void decrementAttempts(String user, String username) {
		if (user.equals("customer")) {
			Storage.customersMap.get(username).passwordLoginAttempts--;
		} else if (user.equals("seller")) {
			Storage.sellersMap.get(username).passwordLoginAttempts--;
		} else if (user.equals("admin")) {
			Storage.adminMap.get(username).passwordLoginAttempts--;
		}

	}

	public static void resetAttempts(String user, String username) {
		if (user.equals("customer")) {
			Storage.customersMap.get(username).setPasswordLoginAttempts((byte) 3);
		} else if (user.equals("seller")) {
			Storage.sellersMap.get(username).setPasswordLoginAttempts((byte) 3);
		} else if (user.equals("admin")) {
			Storage.adminMap.get(username).setPasswordLoginAttempts((byte) 3);
		}

	}

	public static byte getPasswordLoginAttempts(String user, String username) {
		if (user.equals("customer")) {
			return Storage.customersMap.get(username).getPasswordLoginAttempts();
		} else if (user.equals("seller")) {
			return Storage.sellersMap.get(username).getPasswordLoginAttempts();
		} else if (user.equals("admin")) {
			return Storage.adminMap.get(username).getPasswordLoginAttempts();
		}
		return (byte) 0;
	}

	public static void lockUserAccount(String user, String username) {
		if (user.equals("customer")) {
			Storage.customersMap.get(username).setAccountStatus((byte) 2);
		} else if (user.equals("seller")) {
			Storage.sellersMap.get(username).setAccountStatus((byte) 2);
		} else if (user.equals("admin")) {
			Storage.adminMap.get(username).setAccountStatus((byte) 2);
		}
	}

	public static boolean isAccountActive(String user, String username) {
		if (user.equals("customer") && Storage.customersMap.get(username).getAccountStatus() == 1) {
			return true;
		} else if (user.equals("seller") && Storage.sellersMap.get(username).getAccountStatus() == 1) {
			return true;
		} else if (user.equals("admin") && Storage.adminMap.get(username).getAccountStatus() == 1) {
			return true;
		}
		return false;
	}
	public static void unLockUserAccount(String user, String username) {
		if (user.equals("customer")) {
			Storage.customersMap.get(username).setAccountStatus((byte) 1);
		} else if (user.equals("seller")) {
			Storage.sellersMap.get(username).setAccountStatus((byte) 1);
		} else if (user.equals("admin")) {
			Storage.adminMap.get(username).setAccountStatus((byte) 1);
		}
	}
}
