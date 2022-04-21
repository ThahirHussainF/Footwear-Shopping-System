
package com.shop;

import java.util.Scanner;

//It is used to perform the Login operations
class UserLogin {
	private String userName = "";//which is used to store user name
	private String password = "";//which is used to store password
	Scanner scanner = new Scanner(System.in);//which is used to get the user details such as user name and password.
    //It is used to perform the login operation. 
	public void doLogin(String user) { //user means "CUSTOMER","SELLER","ADMIN"
			while (true) {
				System.out.println("Username: ");
				userName = scanner.next();
				if (!Security.isNewOrExistingUser(user, userName)) {
					System.out.println("Invalid User!");
					continue;
				}
				break;
			}
			if(!Security.isAccountActive(user, userName)) {
				System.out.println("Your account was Locked!");
				return;
			}
			while (true) {
				if(Security.getPasswordLoginAttempts(user, userName)==0) {
					System.out.println("Your account was Locked!");
					Security.lockUserAccount(user, userName);
					return;
				}
				System.out.println("Password: ");
				password = scanner.next();
				if (Security.isValidUser(user, userName, password)) {
					System.out.println("Login successfully!");
					new Home(user,userName);//Go to home page
					Security.doResetLoginAttempt(user, userName);
					return;
				}
				System.out.println("Invalid password!.Try Again!");
				Security.doDecrementLoginAttempt(user,userName);
			}
     }

}