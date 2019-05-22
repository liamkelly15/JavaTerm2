package sample;
/*Liam Kelly 8909849*/
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;
import java.io.IOException;


public class Customer extends User
{
    // instance variables - replace the example below with your own
    private String username=" ";
    private double credit=0.0;
    private String password="";

    public Customer()
    {
        username = "";
        credit = 0.0;
        password = "";
    }

    
    public Customer(String ausername, double aCredit, String apassword)
    {
     username = ausername;
     credit = aCredit;
     password = apassword;
    }
    

    public ArrayList<Customer> getCustomers()
    { 
      filereadercustomers fileread = new filereadercustomers();
      ArrayList<Customer> customers = new ArrayList<>();
      customers = fileread.getcustomers();
       
      //ArrayList<Product> types = new ArrayList<Product>();
      
      //for (Product p : products)
      //   if (!types.contains(p)) types.add(p);

      //ArrayList<Product> r = new ArrayList<Product>();
      //for (int i = 0; i < types.size(); i++)
      //   r[i] = types.get(i);
      return customers;
    }
   
    public String getusername()
    {
          return username;
    }
    
    public String getpassword()
    {
          return password;
    }
    
    public double getcredit()
    {
          return credit;
    }
    
    public void setcredit(double acredit)
    {
          credit=acredit;
    }

    /**
      Formats the Customer's detail.
   */
   public String toString()
   { 
      return username + "," + credit + "," + password;
   }

    public int getindex(Customer c) {
        filereadercustomers fileread = new filereadercustomers();
        ArrayList<Customer> customers = new ArrayList<>();
        customers = fileread.getcustomers();
        Customer cust = new Customer();

        for (int i = 0; i < customers.size(); i++) {
            cust = customers.get(i);
            //System.out.println(cust);
            //System.out.println(c);
            if (cust.getusername().equals(c.getusername())) {
                //System.out.println("welcome "+ cust.getusername());
                return i;
            }

        }
        return -1;
    }



    public Customer checklogin(String apassword, String ausername)
    {
    filereadercustomers fileread = new filereadercustomers();
    ArrayList<Customer> customers = new ArrayList<>();
    customers = fileread.getcustomers();


    //System.out.println(apassword);
    //System.out.println(ausername);

    Customer cust =new Customer();
    for (int i = 0; i < customers.size(); i++)
      { 
         cust = customers.get(i);
         //System.out.println(cust);
         if ((apassword.equals(cust.getpassword())) && (ausername.equals(cust.getusername()))) {
             //System.out.println("welcome "+ cust.getusername());
             return cust;
            }  
    
     }
    cust =new Customer();
    return cust;
    }


}
