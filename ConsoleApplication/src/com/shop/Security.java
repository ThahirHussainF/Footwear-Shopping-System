package com.shop;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//It is used to provide operations such as password changing,locking, unlocking and validating user credentials.
public class Security {

	static Scanner scanner = new Scanner(System.in);

	// It is used to check details with corresponding pattern.
	public static boolean isValidPattern(String regex, String credential) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(credential);
		return matcher.matches();
	}

	// It is used to check if new user or already existing user.
	public static boolean isNewOrExistingUser(String user, String userName) {// user means "CUSTOMER","SELLER","ADMIN"
		boolean isCustomer = user.equals("customer") && Storage.customersMap.containsKey(userName);
		boolean isSeller = user.equals("seller") && Storage.sellersMap.containsKey(userName);
		boolean isAdmin = user.equals("admin") && Storage.adminsMap.containsKey(userName);
		if (isCustomer || isSeller || isAdmin) {
			return true;
		}
		return false;
	}

	// It is check user credentials for all users.
	public static boolean isValidUser(String user, String userName, String password) {// user means
																						// "CUSTOMER","SELLER","ADMIN"
		if (user.equals("customer") && Storage.customersMap.get(userName).getPassword().compareTo(password) == 0)
			return true;
		else if (user.equals("seller") && Storage.sellersMap.get(userName).getPassword().compareTo(password) == 0)
			return true;
		else if (user.equals("admin") && Storage.adminsMap.get(userName).getPassword().compareTo(password) == 0)
			return true;
		return false;
	}

	// It is used to decrement the login attempt by 1 whenever user will submit
	// incorrect password.
	public static void doDecrementLoginAttempt(String user, String userName) {// user means "CUSTOMER","SELLER","ADMIN"
		if (user.equals("customer")) {
			Storage.customersMap.get(userName).decrementLoginAttempt();;
		} else if (user.equals("seller")) {
			Storage.sellersMap.get(userName).decrementLoginAttempt();;
		} else if (user.equals("admin")) {
			Storage.adminsMap.get(userName).decrementLoginAttempt();;
		}

	}

	// It is used to reset the login attempt which is '3' as default.
	public static void doResetLoginAttempt(String user, String userName) {// user means "CUSTOMER","SELLER","ADMIN"
		if (user.equals("customer")) {
			Storage.customersMap.get(userName).setPasswordLoginAttempts((byte) 3);
		} else if (user.equals("seller")) {
			Storage.sellersMap.get(userName).setPasswordLoginAttempts((byte) 3);
		} else if (user.equals("admin")) {
			Storage.adminsMap.get(userName).setPasswordLoginAttempts((byte) 3);
		}

	}

	// It is used to get the current password login attempt from corresponding user
	// object through user map.
	public static byte getPasswordLoginAttempts(String user, String userName) {// user means "CUSTOMER","SELLER","ADMIN"
		if (user.equals("customer")) {
			return Storage.customersMap.get(userName).getPasswordLoginAttempts();
		} else if (user.equals("seller")) {
			return Storage.sellersMap.get(userName).getPasswordLoginAttempts();
		} else if (user.equals("admin")) {
			return Storage.adminsMap.get(userName).getPasswordLoginAttempts();
		}
		return (byte) 0;
	}

	// It is used to lock the user account.
	public static void lockUserAccount(String user, String userName) {// user means "CUSTOMER","SELLER","ADMIN"
		if (user.equals("customer")) {
			Storage.customersMap.get(userName).setAccountStatus((byte) 2);
		} else if (user.equals("seller")) {
			Storage.sellersMap.get(userName).setAccountStatus((byte) 2);
		} else if (user.equals("admin")) {
			Storage.adminsMap.get(userName).setAccountStatus((byte) 2);
		}
	}

	// It is used to check if account is active or locked in corresponding user
	// object through user map.
	public static boolean isAccountActive(String user, String userName) {// user means "CUSTOMER","SELLER","ADMIN"
		if (user.equals("customer") && Storage.customersMap.get(userName).getAccountStatus() == 1) {
			return true;
		} else if (user.equals("seller") && Storage.sellersMap.get(userName).getAccountStatus() == 1) {
			return true;
		} else if (user.equals("admin") && Storage.adminsMap.get(userName).getAccountStatus() == 1) {
			return true;
		}
		return false;
	}

	// It is used to unlock the user account.
	public static void unLockUserAccount(String user) {// user means "CUSTOMER","SELLER","ADMIN"
		String userName = "";
		String userId;
		System.out.println("Enter your user name: ");
		userName = scanner.next();
		if (!Security.isNewOrExistingUser(user, userName)) {
			System.out.println("Your account does not exist!");
			return;
		}
		if(Security.isAccountActive(user, userName)) {
			System.out.println("Your account was active!");
			return;
		}
		System.out.println("Enter your " + user + " Id");
		userId = scanner.next();
		if (user.equals("customer") && Storage.customersMap.get(userName).getCustomerId().equals(userId)) {
			Storage.customersMap.get(userName).setAccountStatus((byte) 1);
		} else if (user.equals("seller") && Storage.sellersMap.get(userName).getSellerID().equals(userId)) {
			Storage.sellersMap.get(userName).setAccountStatus((byte) 1);
		}
		System.out.println("Your account was unlocked!");
	}

	// Update the new Password
	public static void updatePassword(String user) {
		String userName = "";
		String password;
		String reEnterPassword;
		System.out.println("Enter your user name: ");
		userName = scanner.next();
		if (!Security.isNewOrExistingUser(user, userName)) {
			System.out.println("Your account does not exist!");
			return;
		}
		if (user.equals("customer") && Security.isAccountActive(user, userName)) {
			Customer customer = Storage.customersMap.get(userName);
			System.out.println("Enter new password: ");
			password = scanner.next();
			do {
				System.out.println("Re-enter new password: ");
				reEnterPassword = scanner.next();
				if (password.equals(reEnterPassword)) {
					customer.setPassword(reEnterPassword);
					System.out.println("Your password was updated successfully!");
					return;
				}
				System.out.println("Both password does match!");
			} while (true);
		} else if (user.equals("seller") && Security.isAccountActive(user, userName)) {
			Seller seller = Storage.sellersMap.get(userName);
			System.out.println("Enter new password: ");
			password = scanner.next();
			do {
				System.out.println("Re-enter new password: ");
				reEnterPassword = scanner.next();
				if (password.equals(reEnterPassword)) {
					seller.setPassword(reEnterPassword);
					System.out.println("Your password was updated successfully!");
					return;
				}
				System.out.println("Both password does match!");
			} while (true);
		} 
		
	}

	// It is used to validate the choice in all menus(customer,seller, admin) which
	// is also handle 'InputMisMatchException'.
	public static int validateChoice() {
		int choice = 0;
		System.out.println("Enter your choice:");
		do {
			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException exception) {
				scanner.nextLine();
				System.out.print("Please enter the valid choice!");
			}
		} while (!Pattern.matches("^[1-9]*$", String.valueOf(choice)));
		return choice;
	}
}
