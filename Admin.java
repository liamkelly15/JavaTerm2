package sample;
/*Liam Kelly 8909849*/
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;
import java.io.IOException;


public class Admin extends User
{
    // instance variables - replace the example below with your own
    private String username=" ";
    
    private String password="";

    public Admin ()
    {
        username = "";

        password = "";
    }

    
    public Admin (String ausername, String apassword)
    {
     username = ausername;
     
     password = apassword;
    }

    public ArrayList<Admin> getadmins()
    { 
      filereaderadmins fileread = new filereaderadmins();
      ArrayList<Admin> admins = new ArrayList<>();
      admins = fileread.getadmins();
       

      return admins;
    }
   
    public String getusername()
    {
          return username;
    }
    
    public String getpassword()
    {
          return password;
    }


    public int getindex(Admin a) {
        filereaderadmins fileread = new filereaderadmins();
        ArrayList<Admin> admins = new ArrayList<>();
        admins = fileread.getadmins();
        Admin adm = new Admin();

        for (int i = 0; i < admins.size(); i++) {
            adm = admins.get(i);
            //System.out.println(cust);
            //System.out.println(c);
            if (adm.getusername().equals(a.getusername())) {
                //System.out.println("welcome "+ cust.getusername());
                return i;
            }

        }
        return -1;
    }
    /**
      Formats the Customer's detail.
   */
   public String toString()
   { 
      return username + "," + password;
   }

    public Admin checklogin(String apassword, String ausername)
    {
        filereaderadmins fileread = new filereaderadmins();
        ArrayList<Admin> admins = new ArrayList<>();
        admins = fileread.getadmins();

        Admin adm =new Admin();
        for (int i = 0; i < admins.size(); i++)
        {
            adm  = admins.get(i);

            if ((apassword.equals(adm.getpassword())) && (ausername.equals(adm.getusername()))) {

                return adm;
            }

        }
        adm = new Admin();
        return adm;
    }




}