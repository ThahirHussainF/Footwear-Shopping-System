using System;
using System.Text.RegularExpressions;
namespace FotwearShop {
    public class Login{
        public static void DoLogin() {
             String userName,password;
             //Getting user name from user and validating user name.
             do {
                Console.WriteLine("Enter the user name: ");
                userName=Console.ReadLine();
                if(IsValidUserName(userName)) {
                    Console.WriteLine("Your user name was correct format!");
                    break;
                }
                 Console.WriteLine("Your user name was not correct format.Try Again!");
             }while(true);
             //Getting password from user and Validating password
              do {
                Console.WriteLine("Enter the password: ");
                password=Console.ReadLine();
                if(IsValidPassword(password)) {
                    Console.WriteLine("Your password was correct format!");
                    break;
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
          public static bool IsValidPassword(String userName) {
             string userNameForamt="^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
             Regex regex=new Regex(userNameForamt);
             if(regex.IsMatch(userName)) {
                 return true;
             }
             return false;
         }
    }
}
