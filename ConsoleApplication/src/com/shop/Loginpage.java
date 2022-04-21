
package com.shop;
//It is used to navigate the login accounts for all users(customer, seller, admin)
public class Loginpage {

	// This constructor is used to categorize the users(customer, seller and// admin)
	public Loginpage(Storage storage) {
		boolean exit = true;
		do {
			int choice;
			System.out.println("****************************************************");
			System.out.println("\n--LOGIN--\n");
			System.out.println("1.Customer\n2.Seller\n3.Admin\n4.Go to Welcome Page\n5.Leave Shop");
			System.out.println("****************************************************");
			choice = Security.validateChoice();
			switch (choice) {
			case 1:
				this.showLoginMenu("customer");
				break;
			case 2:
				this.showLoginMenu("seller");
				break;
			case 3:
				this.showLoginMenu("admin");
				break;
			case 4:
				new WelcomePage(storage);
				break;
			case 5:
				System.out.println("Thank you for visiting our store!!");
				exit = false;
				break;
			default:
				System.out.print("Please enter the valid choice!");
				break;
			}
		} while (exit);
	}
	//It is used to show the login menu
	public void showLoginMenu(String user) {
		boolean exit = true;
		do {
			System.out.println("-------------------");
			System.out.println("1.Register\n2.Login\n3.Unlock account\n4.Forgot Password\n5.Exit");
			System.out.println("--------------------");
			int choice;
			choice = Security.validateChoice();
			switch (choice) {
			//Register
			case 1:
				new UserRegister().doRegister(user);
				break;
			//Login	
			case 2:
				new UserLogin().doLogin(user);
				break;
			//Unlock user account	
			case 3:
				Security.unLockUserAccount(user);
				System.out.println("Please update your password!");
				Security.updatePassword(user);
                break;
            //Update the password    
			case 4:
				Security.updatePassword(user);
				break;
			//Exit Condition	
			case 5:
				exit=false;
				break;
			}
		} while (exit);

	}
	

}
