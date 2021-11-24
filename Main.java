
package sw1;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Admin admin=new Admin();
        Store store=new Store();
        Customer customer=new Customer();
        Driver driver=new Driver();
        Order order =new Order();
        Offer offer=new Offer();
        Rating rating = new Rating();
        Notification notification=new Notification();
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("Please Choose \n1-Register\n2-Login");
            int choose=sc.nextInt();
            if(choose==1)
            {
                System.out.println("Regiser as\n1-Driver\n2-Customer");
                int k=sc.nextInt();
                if(k==1)
                {
                    System.out.println("Please enter a complete information"+"\nUser Name: ");
                    String name=sc.nextLine();
                    sc.nextLine();
                    System.out.println("Password: ");
                    String pass=sc.nextLine();
                    sc.nextLine();
                    System.out.println("Email: ");
                    String email=sc.nextLine();
                    System.out.println("Mobile number: ");
                    String mob=sc.nextLine();
                    System.out.println("Driving License: ");
                    String drivLic=sc.nextLine();
                    System.out.println("National ID: ");
                    String nationalId=sc.nextLine();
                    driver=new Driver(name,pass,email,mob,drivLic,nationalId);
                    if(admin.verifyDriver(driver)==true)
                    {
                        System.out.println("Welcome To Our App");
                        System.out.println("Please Enter Your Fav Areas");
                        int i=0;
                        String favArea=sc.nextLine();
                        while(favArea!=null)
                        {
                         store.addFavouritreAreas(favArea);
                         favArea=sc.nextLine();
                         i++;
                        }
                        
                    }
                    else
                    {
                        System.out.println("yor are now in the pending drivers");
                    }
                }
                else if(k==2)
                {
                    System.out.println("Please enter a complete information"+"\nUser Name: ");
                    String name=sc.nextLine();
                    sc.nextLine();
                    System.out.println("Password: ");
                    String pass=sc.nextLine();
                    System.out.println("Email: ");
                    String email=sc.nextLine();
                    System.out.println("Mobile number: ");
                    String mob=sc.nextLine();
                    customer=new Customer(name,pass,email,mob);
                    customer.suspendCheck(customer);
                }
                else
                {
                    System.out.println("Unvalid Choose");
                }
            }
            else if(choose==2)
            {
                System.out.println("Login as\n1-Driver\n2-Customer");
                int i=sc.nextInt();
                if(i==1)
                {
                    System.out.println("Please Enter Your"+"\nUser Name: ");
                    String name=sc.nextLine();
                    sc.nextLine();
                    System.out.println("Password: ");
                    String pass=sc.nextLine();
                    if(driver.logIn(name, pass)==true)
                    {
                        System.out.println("You loged in successfully");
                        System.out.println("Check if you have an order");
                        notification.notifyRide();
                        System.out.println("Set A price to your tripe");
                        double price =sc.nextDouble();
                        offer.setPrice(price);
                        driver.Notify();
                        notification.updateDriver();
                    }
                    else 
                    {
                        System.out.println("Check your user name and your pass");
                    }
                }
                 else if(i==2)
                {
                    System.out.println("Please Enter Your"+"\nUser Name: ");
                    String name=sc.nextLine();
                    sc.nextLine();
                    System.out.println("Password: ");
                    String pass=sc.nextLine();
                    if(customer.logIn(name, pass)==true)
                    {
                        System.out.println("You loged in successfully");
                        System.out.println("Do you want to order now?");
                        String or=sc.nextLine();
                        if(or=="yes")
                        {
                            System.out.println("Please Enter your\nSource Area");//System.out.println();
                            String source=sc.nextLine();
                            System.out.println("Destination Area");
                            String distenation=sc.nextLine();
                            order.checkSource(source);
                            notification.updateCustomer();
                            System.out.println("Please Rate your driver");
                            double rate=sc.nextDouble();
                            rating.setRate(rate);
                            store.AddRatings(rating);
                        }
                    }
                    else 
                    {
                        System.out.println("Check your user name and your pass");
                    }
            }
            else
            {

            }
        }
        
        
    }
    
}
}
