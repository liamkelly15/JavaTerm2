
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;
import java.io.IOException;

public class Main
{
    // instance variables - replace the example below with your own
    static boolean logincustomeractive=false;
    static boolean loginadminactive=false;
    static boolean selection=false;
    static boolean logout=false;
    static Scanner sc=new Scanner(System.in);
    static Customer customeronline;
    static Product prod;
    static double customercredit=0.0;
    static int customerindex;
    static int productindex;
    
    public static void main() {
    
    do {
    System.out.println("PLEASE LOGIN TO USE VENDING MACHINE");
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter username: ");
    String username = sc.next();
    if (username.equals("X"))
    {
        logincustomeractive=false;
        break;
    }   
    System.out.println(username);
    System.out.println("Enter password: ");
    int password = sc.nextInt();
    System.out.println(password);
    
    //check if User is admin or customer
    
    filereadercustomers fileread = new filereadercustomers();
    ArrayList<Customer> customers = new ArrayList<>();
    customers = fileread.getcustomers();    
    
    
    for (int i = 0; i < customers.size(); i++)
      { 
         Customer cust = customers.get(i);
         //System.out.println(cust);
         //System.out.println(cust.getpass());
         //System.out.println(cust.getusername());
         if ((cust.getpassword() == password)) {
            logincustomeractive = true;
            customercredit=cust.getcredit();
            customerindex = i;
            customeronline=cust;
            System.out.println("Welcome "+ cust.getusername());
            System.out.println("you have the following credit "+ cust.getcredit());
            break;
            }
            
            
    
        }
    
        
    //System.out.println(customercredit);
    //System.out.println(customerindex);
    
    if (!logincustomeractive) {
     //System.out.println("Are you an admin ?"); 
     filereaderadmins filereadadmin = new filereaderadmins();
     ArrayList<Admin> admins = new ArrayList<>();
     admins = filereadadmin.getadmins();   
     for (int i = 0; i < admins.size(); i++)
      { 
         Admin admin = admins.get(i);
         //System.out.println(cust);
         //System.out.println(cust.getpass());
         //System.out.println(cust.getusername());
         if ((admin.getpassword() == password)) {
            loginadminactive = true;
            System.out.println("Welcome Admin "+ admin.getusername());
            
            }
    
        }
     
     if ((!logincustomeractive) && (!loginadminactive)) {
     System.out.println("Not a Customer or Admin - Login Unsuccessful - Try again or X to exit"); 
     
     
    }
     
    }       
            
    } while ((!logincustomeractive) && (!loginadminactive)) ;          
            
  if (logincustomeractive) {  
  do {
     
    
    VendingMachine VM = new VendingMachine();
    ArrayList<Product> producttypes= VM.getProducts();
    System.out.println("these are the products");
    for (int i = 0; i < producttypes.size(); i++)
      { 
         Product prod = producttypes.get(i);
         System.out.println(prod.getDescription());
        }  
    //System.out.println(producttypes);
    System.out.println("Enter what you want to buy or X to logout:");
    String prodtobuy = sc.next();
    if (prodtobuy.equals("X"))
    {
        logout=true;
        break;
    }
    for (int i = 0; i < producttypes.size(); i++)
      { 
         Product prod = producttypes.get(i);
         //System.out.println(cust);
         //System.out.println(cust.getpass());
         //System.out.println(prod.getDescription());
         //System.out.println(prodtobuy);
         if ((prod.getDescription().equals(prodtobuy))) {
            selection = true;
            
            productindex = i;
            System.out.println("product selected " +prod.getDescription());
            //System.out.println(customeronline);
            //System.out.println(customerindex);
            double newcustbalance = VM.buyProduct(prod,customercredit,customeronline,customerindex);
            System.out.println("you have just purchased a "+prod.getDescription()+" Enjoy !!");
            System.out.println("Your account has been updated your new balance is "+newcustbalance);
            //now write back to customerindex with his new credit-
            //System.out.println("you have the following credit "+ cust.getcredit());
            break;
            }
    
        }
    
    if (!selection)
     {
         System.out.println("No such product - please select from list");
        }  
    
    
       
    } while ((!selection) || (!logout));   
}    
    
    
       
    
    
    //ADMIN FUNCTIONS
    do {
    if (loginadminactive) {
    VendingMachine VM = new VendingMachine();
    ArrayList<Product> producttypes= VM.getProducts();
    System.out.println("these are the products");
    System.out.println(producttypes);
    System.out.println("Enter what you want to Do...1-add or 2-reload products or 3 to logout:");
    int adminaction = sc.nextInt();
    if (adminaction==3)
    {
        logout=true;
        break;
    }
    
    if (adminaction == 2) 
    {
    System.out.println("Enter what you want to Reload or X to logout:");
    String prodtoreload = sc.next();
    if (prodtoreload.equals("X"))
    {
        logout=true;
        break;
    }
    System.out.println("Enter the Qty to reload:");
    int qtytoreload = sc.nextInt();   
    for (int i = 0; i < producttypes.size(); i++)
      { 
         Product prod = producttypes.get(i);
         //System.out.println(cust);
         //System.out.println(cust.getpass());
         //System.out.println(prod.getDescription());
         //System.out.println(prodtobuy);
         if ((prod.getDescription().equals(prodtoreload))) {
            selection = true;
            
            productindex = i;
            System.out.println("product selected to reload " +prod.getDescription());
            //System.out.println(customeronline);
            //System.out.println(customerindex);
            boolean reloadupdate = VM.reloadProduct(prod,qtytoreload);
            System.out.println("you have just loaded "+prod.getDescription() + " by " +qtytoreload);
            //System.out.println("Your account has been updated your new balance is "+newcustbalance);
            //now write back to customerindex with his new credit-
            //System.out.println("you have the following credit "+ cust.getcredit());
            break;
            //System.out.println("you have the following credit "+ cust.getcredit());
            
            }
    
        }
    
    }
    if (adminaction == 1) 
    {   
    System.out.println("Enter what product to add or X to logout:");
    String proddesctoadd = sc.next();
    if (proddesctoadd.equals("X"))
    {
        logout=true;
        break;
    }
    System.out.println("Enter the Price:");
    
    double pricenewprod = Double.valueOf(sc.next());   
    System.out.println("Enter the Qty:");
    int qtytoadd = sc.nextInt();       
        
    Product prodtoadd = new Product(proddesctoadd,pricenewprod,qtytoadd);    
    boolean reloadupdate = VM.addProduct(prodtoadd);
    System.out.println("you have just loaded "+proddesctoadd + " by " +qtytoadd);
            //System.out.println("Your account has been updated your new balance is "+newcustbalance);
            //now write back to customerindex with his new credit-
            //System.out.println("you have the following credit "+ cust.getcredit());
            break;
        
    }
}
    } while (!logout);  
 logincustomeractive=false;
 loginadminactive=false;
}
}