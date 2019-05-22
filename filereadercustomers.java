package sample;
/**Liam Kelly 8909849
 * 1 read of customers.txt
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;
import java.io.IOException;



public class filereadercustomers
{
    // instance variables - 
   
    ArrayList<Customer>  customers = new ArrayList<Customer>();
    static String filename=null;
    static Scanner sc=new Scanner(System.in);
    static StringBuffer stringBufferOfData = new StringBuffer();

    public filereadercustomers() 
    {
    
    
        
    }
    
    
    
    public ArrayList<Customer> getcustomers()  {
    //System.out.println("Please enter your files name and path i.e C:\\test.txt: ");//prompt for file name
    //filename = sc.nextLine();//read in the file name
    String name = "";
    double credit = 0.0;
    String password = "";
    
try {
         Scanner scanner =
           new Scanner(new File("C:\\Users\\Liam\\IdeaProjects\\newjavafxtest\\src\\sample\\Customers.txt"));
         scanner.useDelimiter
           (System.getProperty("line.separator")); 
         while (scanner.hasNext()) {
            String line = scanner.next();
            Scanner input = new Scanner(line);
            input.useDelimiter(",|\n"); 
            name = input.next();
            //System.out.println(name);
            credit = Double.valueOf(input.next());
            //System.out.println(credit);
            password = input.next();
            //int stock = Integer.valueOf(stockstr);
            //System.out.println(password);
            // create a Customer object for the new Customer taken from txt file 
            customers.add(new Customer(name, credit, password));
        
         }
         scanner.close();
       } catch (FileNotFoundException e) {
         e.printStackTrace();
       }
       return customers;
     }   

}    
    

  
