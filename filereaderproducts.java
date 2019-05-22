package sample;
/*Liam Kelly 8909849
 * 1 read of Products.txt
 *
 * @author Liam Kelly 8909849
 * @version (a version number or a date)
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;
import java.io.IOException;



public class filereaderproducts
{
    // instance variables - 
   
    ArrayList<Product>  products = new ArrayList<Product>();
    static String filename=null;
    static Scanner sc=new Scanner(System.in);
    static StringBuffer stringBufferOfData = new StringBuffer();

    public filereaderproducts() 
    {
  
        
    }
    
    
    
    public ArrayList<Product> getproducts()  {
    //System.out.println("Please enter your files name and path i.e C:\\test.txt: ");//prompt for file name
    //filename = sc.nextLine();//read in the file name
    String name = "";
    String location = "";
    double price = 0.0;
    int stock = 0;
    
try {
         Scanner scanner =
           new Scanner(new File("C:\\Users\\Liam\\IdeaProjects\\newjavafxtest\\src\\sample\\Products.txt"));
         scanner.useDelimiter
           (System.getProperty("line.separator")); 
         while (scanner.hasNext()) {
            String line = scanner.next();
            Scanner input = new Scanner(line);
            input.useDelimiter(",|\n"); 
            name = input.next();
            //System.out.println(name);
            price = Double.valueOf(input.next());
            //System.out.println(price);
            stock = input.nextInt();
            //System.out.println(stock);
            products.add(new Product(name, price, stock));
         }
         scanner.close();
       } catch (FileNotFoundException e) {
         e.printStackTrace();
       }
       return products;
     }   

}


    
  
