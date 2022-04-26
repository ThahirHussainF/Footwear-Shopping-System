using System;
    class Home {
        public static  void ShowMenu() {
             Console.WriteLine("Welcome to Footwear Shop");
             int choice;
             Console.WriteLine("\n1.Login\n2.Register\n3.Exit\nEnter your choice: ");
             choice=Convert.ToInt32(Console.ReadLine());
             switch(choice) {
                 case 1:
                 UserLogin.DoLogin();
                 break;
                 case 2:
                 break;
                 case 3:
                 break;
             }

        }
    }



