using System;
using System.Text.RegularExpressions;
    public class UserLogin{
        public static void DoLogin() {
             String userName,password,reEnterUserName,reEnterPassword;
             //Getting user name from user and validating user name.
             do {
                Console.WriteLine("Enter the user name: ");
                userName=Console.ReadLine();
                if(IsValidUserName(userName)) {
                     Console.WriteLine("Re-Enter the user name: ");
                    reEnterUserName=Console.ReadLine();
                    if(userName.Equals(reEnterUserName)) {
                           Console.WriteLine("Your username was match");
                             break;
                    }
                    else {
                        Console.WriteLine("Both username does not match");
                    }
                  
                }
                 Console.WriteLine("Your user name was not correct format.Try Again!");
             }while(true);
             //Getting password from user and Validating password
              do {
                Console.WriteLine("Enter the password: ");
                password=Console.ReadLine();
                if(IsValidPassword(password)) {
                  Console.WriteLine("Re-Enter the password: ");
                  reEnterPassword=Console.ReadLine();
                  if(password.Equals(reEnterPassword)) {
                      Console.WriteLine("Your password was match");
                  } else {
                      Console.WriteLine("Your Password was not match");
                  }
                }
                 Console.WriteLine("Your password not correct format.Try Again!");
             }while(true);
              
             

        }
         public static bool IsValidUserName(String userName) {
             string userNameForamt="^(?=.*[0-9])" + "(?=.*[a-z])" + "(?=.*[A-Z]).{5,8}$";
             Regex regex=new Regex(userNameForamt);
             if(regex.IsMatch(userName)) {
                 return true;
             }
             return false;
         }
          public static bool IsValidPassword(String password) {
             string passwordForamt="^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
             Regex regex=new Regex(passwordForamt);
             if(regex.IsMatch(password)) {
                 return true;
             }
             return false;
         }
    }
