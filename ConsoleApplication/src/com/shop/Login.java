
package com.shop;

import java.util.Scanner;

//It is used to perform the Login operations
class Login {
	private String username = "";
	private String password = "";
	private String user;//which type of user whether 'customer' , 'seller' and 'admin'
	Storage storage;//It is used to create storage object for managing all accounts.
	Scanner scanner = new Scanner(System.in);
    //This constructor is invoked whenever login operation is performed.
	public Login(String user,Storage storage) {
		this.storage=storage;
		storage.test();//for testing purpose.
		this.user = user;
		
		boolean exit = true;
		do {
			System.out.println("-------------------");
			System.out.println("1.Register\n2.Login\n3.Unlock account\n4.Exit");
			System.out.println("--------------------");
			int choice;
			choice = Management.checkValidityOfChoice();
			switch (choice) {
			case 1:
				new RegisterUser().registerNewUser(user);
				break;
			case 2:
				this.login(user);
				break;
			case 3:
				
			case 4:
				exit=false;
				break;
			}
		} while (exit);

	}
     
     public void login(String user) { 
			while (true) {
				System.out.println("Username: ");
				username = scanner.next();
				if (!Security.checknewOrAlreadyExistingUser(user, username)) {
					System.out.println("Invalid User!");
					continue;
				}
				break;
			}
			if(!Security.isAccountActive(user, username)) {
				System.out.println("Your account was Locked!");
				return;
			}
			while (true) {
				if(Security.getPasswordLoginAttempts(user, username)==0) {
					System.out.println("Your account was Locked!");
					Security.lockUserAccount(user, username);
					return;
				}
				System.out.println("Password: ");
				password = scanner.next();
				if (Security.checkValidUser(user, username, password)) {
					System.out.println("Login successfully!");
					Home home=new Home(user,username,storage);
					Security.resetAttempts(user, username);
					return;
				}
				System.out.println("Invalid password!.Try Again!");
				Security.decrementAttempts(user,username);
			}
     }
    
    //It is used to get the username from object(Customer, Seller and Admin)
	public String getUsername() {
		return username;
	}
	//It is used to set the  username from object(Customer, Seller and Admin)
	public void setUsername(String username) {
		this.username = username;
	}
    //It is used to get the password from object(Customer, Seller and Admin)
	public String getPassword() {
		return password;
	}
	 //It is used to set the password from object(Customer, Seller and Admin)
	public void setPassword(String password) {
		this.password = password;
	}

}