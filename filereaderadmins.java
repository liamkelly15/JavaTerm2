package sample;
/**
 * 1 read of Admin.txt
 *
 * @author Liam  Kelly 8909849
 * @version (a version number or a date)
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;
import java.io.IOException;



public class filereaderadmins
{
    // instance variables - 
   
    ArrayList<Admin>  admins = new ArrayList<Admin>();
    static String filename=null;
    static Scanner sc=new Scanner(System.in);
    static StringBuffer stringBufferOfData = new StringBuffer();

    public filereaderadmins() 
    {
    
    
        
    }
    
    
    
    public ArrayList<Admin> getadmins()  {
    //System.out.println("Please enter your files name and path i.e C:\\test.txt: ");//prompt for file name
    //filename = sc.nextLine();//read in the file name
    String name = "";
    
    
    String password = "";
    
 try {
         Scanner scanner =
           new Scanner(new File("C:\\Users\\Liam\\IdeaProjects\\newjavafxtest\\src\\sample\\Admin.txt"));
         scanner.useDelimiter
           (System.getProperty("line.separator")); 
         while (scanner.hasNext()) {
            String line = scanner.next();
            Scanner input = new Scanner(line);
            input.useDelimiter(",|\n"); 
            name = input.next();
            //System.out.println(name);
            
            //System.out.println(credit);
            password = input.next();
            //int stock = Integer.valueOf(stockstr);
            //System.out.println(password);
            // create a Customer object for the new Customer taken from txt file 
            admins.add(new Admin(name, password));
        
         }
         scanner.close();
       } catch (FileNotFoundException e) {
         e.printStackTrace();
       }
       return admins;
     }   

}    
       

    
    
  
