package sample;
/*Liam Kelly 8909849
 * Write a description of class Main here.
 *
 * @author Liam Kelly 8909849
 * @version (a version number or a date)
 */
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.collections.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
//import javafx.scene.messagebox.MessageBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    // instance variables - replace the example below with your own
    //static boolean loginactive = false;
    //static boolean loginadminactive = false;
    static boolean selection = false;
    static boolean logout = false;
    static Scanner sc = new Scanner(System.in);

    static Product prod;
    static double custcredit = 0.0;
    static int custindex;
    static int productindex;
    static DecimalFormat df2 = new DecimalFormat(".##");
    static String welcomestr;
    static String prodsel;
    static int nameend;
    static String prodname;
    static int qtytoreload;
    static double pricetoreload;

    private TextField txtusername = new TextField();
    private PasswordField pf = new PasswordField();
    private TextField newprodname = new TextField();
    private TextField newprodprice = new TextField();
    private TextField newprodqty = new TextField();
    private TextField qtyreload = new TextField();
    private TextField pricereload = new TextField();
    private TextField removeprodname = new TextField();
    Button btnLogin = new Button("Login");
    Scene scenelogin, sceneprod, sceneprodlist,sceneadmin,sceneaddnewprod,sceneremoveprod;
    Button btnProd = new Button("View Products");
    Button submitprodtobuy=new Button ("Buy Selected Product");
    Button submitprodtoreload=new Button ("Adjust Product Stock Level");
    Button submitpricechange=new Button ("Set New Product Price");
    Button submitaddnewprod=new Button("Goto New Screen to Add new Prod");
    Button submitprodtoadd=new Button("Confirm Add Product");
    Button exitshop=new Button("Exit Vending");
    Button submitremoveprod =new Button("Remove Selected Product");
    Button submitdeleteprod=new Button("Remove Product");
    Button returntoreload=new Button("Return to ReLoad Screen");
    Button viewcustcredit=new Button( "View My Credit");
    Label labelprod =new Label("test");
    private ArrayList<Button> prodbtns = new ArrayList<Button>();
    ComboBox combobox = new ComboBox();
    ComboBox comboboxadmin=new ComboBox();
    Customer custonline = new Customer();
    Admin adminonline = new Admin();



    @Override
    public void start(Stage primaryStage) throws Exception {



        // Create UI scenelogin
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Username:"), 0, 0);
        gridPane.add(txtusername, 1, 0);
        gridPane.add(new Label("Password"), 0, 1);
        gridPane.add(pf, 1, 1);
        gridPane.add(btnLogin, 1, 5);

        // Set properties for UI
        gridPane.setAlignment(Pos.CENTER);
        txtusername.setAlignment(Pos.BOTTOM_LEFT);
        pf.setAlignment(Pos.BOTTOM_LEFT);
        GridPane.setHalignment(btnLogin, HPos.RIGHT);




        //Process events
        btnLogin.setOnAction(e ->
        {
            checklogin();
            //System.out.println("logincheckcomplete");

            //FOR USER = CUSTOMER
            if (custonline.getindex(custonline)>=0) {
                VendingMachine VM = new VendingMachine();
                ArrayList<Product> producttypes = VM.getProducts();

                // Create a combo box

                //Add all the  Vending Machine products to the Combo Box
                for (Product p: producttypes)
                    combobox.getItems().addAll(p.getDescription()+"@ Euro "+ p.getPrice()+" Qty In Stock "+p.getstock());

                //FXCollections
                 //               .observableArrayList(producttypes));

                //for (Product p: producttypes)
                //    prodbtns.add(new Button(p.getDescription()));

                GridPane gridPaneProdlist = new GridPane();

                //Label welcomelabel=new Label(welcomestr);
                AlertBox.display("Welcome",welcomestr);
                Label blank=new Label("");
                Label prodlistlabel=new Label("Select Product from Drop down List");
                //gridPaneProdlist.add(welcomelabel, 2, 1);
                gridPaneProdlist.add(blank, 2, 2);
                gridPaneProdlist.add(prodlistlabel, 2, 3);
                gridPaneProdlist.add(combobox, 2, 4);
                //gridPaneProdlist.add(blank, 2, 5);
                //gridPaneProdlist.add(blank, 2, 6);
                //gridPaneProdlist.add(blank, 2, 7);
                gridPaneProdlist.add(submitprodtobuy, 2, 8);
                gridPaneProdlist.add(exitshop, 2, 9);
                gridPaneProdlist.add(viewcustcredit, 3, 9);
                gridPaneProdlist.setAlignment(Pos.CENTER);

                sceneprodlist = new Scene(gridPaneProdlist, 700, 500);
                primaryStage.setTitle("ProductList Scene"); // Set title
                primaryStage.setScene(sceneprodlist); // Place the scene in the stage
                primaryStage.show(); // Display the stage

              }

            //FOR USER = ADMIN
            if (adminonline.getindex(adminonline)>=0) {
                VendingMachine VM = new VendingMachine();
                ArrayList<Product> producttypes = VM.getProducts();
                System.out.println(welcomestr);

                //Add all the  Vending Machine products to the Combo Box
                for (Product p: producttypes)
                    comboboxadmin.getItems().addAll(p.getDescription()+"@ Euro "+ p.getPrice()+" Qty In Stock "+p.getstock());

                GridPane gridPaneadmin = new GridPane();

                //Label welcomelabel=new Label(welcomestr);
                AlertBox.display("Welcome",welcomestr);
                Label blank=new Label("");
                Label prodlistlabel=new Label("FIRST - Select Product Detail from Drop down List");
                //gridPaneProdlist.add(welcomelabel, 2, 1);
                gridPaneadmin.add(blank, 2, 2);
                gridPaneadmin.add(prodlistlabel, 2, 3);
                //gridPaneadmin.add(blank, 2, 2);
                gridPaneadmin.add(comboboxadmin, 2, 4);
                //gridPaneProdlist.add(blank, 2, 5);
                //gridPaneProdlist.add(blank, 2, 6);
                //gridPaneProdlist.add(blank, 2, 7);
                gridPaneadmin.add(new Label("STOCK QTY ADJUST"), 0, 6);
                gridPaneadmin.add(qtyreload, 0, 7);
                gridPaneadmin.add(new Label("NEW PRODUCT PRICE"), 3, 6);
                gridPaneadmin.add(pricereload, 3, 7);
                gridPaneadmin.add(submitprodtoreload, 0, 8);
                gridPaneadmin.add(submitdeleteprod,2,11);
                gridPaneadmin.add(submitpricechange,3,8);

                gridPaneadmin.add(exitshop, 2, 13);

                gridPaneadmin.add(submitaddnewprod, 2, 12);

                gridPaneadmin.setAlignment(Pos.CENTER);



                sceneadmin = new Scene(gridPaneadmin, 700, 700);
                primaryStage.setTitle("Manage Products Scene"); // Set title
                primaryStage.setScene(sceneadmin); // Place the scene in the stage
                primaryStage.show(); // Display the stage

            }

            });



        submitprodtobuy.setOnAction(e ->
        {
            //System.out.println(combobox.getValue());
            VendingMachine VM2 = new VendingMachine();
            ArrayList<Product> producttypes = VM2.getProducts();
            try {
                prodsel = combobox.getValue().toString();
                nameend = prodsel.indexOf("@");
                prodname = prodsel.substring(0, nameend);

                for (Product p : producttypes)
                    //System.out.println(cust);
                    //System.out.println(cust.getpass());
                    //System.out.println(prod.getDescription());
                    //System.out.println(prodtobuy);
                    if ((p.getDescription().equals(prodname))) {
                        prod = p;
                        //System.out.println("got the product");
                        //System.out.println(prod);
                        //System.out.println(custonline); }
                        //get the customer credit and index
                        custcredit = custonline.getcredit();
                        //System.out.println(custcredit);
                        custindex = custonline.getindex(custonline);
                        //System.out.println(custindex);
                        double newcustbalance = VM2.buyProduct(prod, custcredit, custonline, custindex);
                        if (newcustbalance<custcredit) {
                            //String newcustbalancestr = String.format("%1f", newcustbalance);
                            //String purchasenote="you have just purchased a " + prod.getDescription() + " Enjoy !!";
                            String purchasenote = "You purchased a " + prod.getDescription() + " your account has been updated your new balance is Euro " + df2.format(newcustbalance) + " Continue shopping or Press Exit";
                            AlertBox.display("Credit Update", purchasenote);
                            //System.out.println(purchasenote);
                            //now write back to customerindex with his new credit-
                            //System.out.println("you have the following credit " + custonline.getcredit());
                        }
                        if (newcustbalance==custcredit) {
                            if (custcredit >= prod.getPrice())
                            AlertBox.display("Stock Update", "Insufficent Qty in Stock-Choose another Product");
                            else
                                AlertBox.display("Credit Update", "Insufficent Credit-Customercredit is Euro "+ df2.format(custcredit));
                        }
                        }
                    }catch (NullPointerException e3) {
                AlertBox.display("Product Buy Update", "Please select a Product to Buy");
                    }
            combobox.getItems().clear();
            producttypes = VM2.getProducts();
            for (Product p:producttypes)
                combobox.getItems().addAll(p.getDescription()+"@ Euro "+ p.getPrice()+" Qty In Stock "+p.getstock());

        });

        submitprodtoreload.setOnAction(e ->
        {
            //System.out.println(combobox.getValue());
            VendingMachine VM3 = new VendingMachine();
            ArrayList<Product> producttypes = VM3.getProducts();
            try {
                prodsel = comboboxadmin.getValue().toString();
                nameend = prodsel.indexOf("@");
                prodname = prodsel.substring(0, nameend);

                for (Product p : producttypes)
                    //System.out.println(cust);
                    //System.out.println(cust.getpass());
                    //System.out.println(prod.getDescription());
                    //System.out.println(prodtobuy);
                    if ((p.getDescription().equals(prodname))) {
                        prod = p;
                        //System.out.println("got the product");
                        //System.out.println(prod);
                        //System.out.println(custonline); }
                        //get the customer credit and index
                        //custcredit = custonline.getcredit();
                        //System.out.println(custcredit);
                        //custindex = custonline.getindex(custonline);
                        //System.out.println(custindex);
                        try {
                            qtytoreload = Integer.parseInt(qtyreload.getText());
                            if ((prod.getstock()+qtytoreload) >= 0) {
                                boolean reloadupdate = VM3.reloadProduct(prod, qtytoreload);
                                String reloadnote = "you have just adjusted the stock Qty of " + prod.getDescription() + " by " + qtytoreload ;
                                AlertBox.display("ReLoad Update", reloadnote);}
                            else  {
                                AlertBox.display("ReLoad Update", "Cannot have negative stock-Change Stock Adjust Value");
                                System.out.println(prod.getstock());
                                System.out.println(qtytoreload);
                            }
                            //System.out.println("you have just loaded " + prod.getDescription() + " by " + qtytoreload);
                            //String newcustbalancestr = String.format("%1f", newcustbalance);
                            //String purchasenote="you have just purchased a " + prod.getDescription() + " Enjoy !!";
                            //String purchasenote="You purchased a "+ prod.getDescription() +" your account has been updated your new balance is Euro" + df2.format(newcustbalance) + " Continue shopping or Press Exit";
                            //AlertBox.display("Credit Update",purchasenote);
                            //System.out.println(purchasenote);
                            //now write back to customerindex with his new credit-
                            //System.out.println("you have the following credit " + custonline.getcredit());
                        }catch (NumberFormatException e8) {
                            AlertBox.display("Product ReLoad Update", "Please select a Qty to ReLoad/Reduce");
                        }

                    }
                    }catch (NullPointerException e3) {
                    AlertBox.display("Product ReLoad Update", "Please select a Product to ReLoad/Reduce");
                }
            comboboxadmin.getItems().clear();
            producttypes = VM3.getProducts();
            for (Product p:producttypes)
                comboboxadmin.getItems().addAll(p.getDescription()+"@ Euro "+ p.getPrice()+" Qty In Stock "+p.getstock());
            qtyreload.clear();
        });

            submitpricechange.setOnAction(e ->
            {
                //System.out.println(combobox.getValue());
                VendingMachine VM7 = new VendingMachine();
                ArrayList<Product> producttypes = VM7.getProducts();
                try {
                    prodsel = comboboxadmin.getValue().toString();
                    nameend = prodsel.indexOf("@");
                    prodname = prodsel.substring(0, nameend);

                    for (Product p : producttypes)
                        //System.out.println(cust);
                        //System.out.println(cust.getpass());
                        //System.out.println(prod.getDescription());
                        //System.out.println(prodtobuy);
                        if ((p.getDescription().equals(prodname))) {
                            prod = p;
                            System.out.println("got the product");
                            //System.out.println(prod);
                            //System.out.println(custonline); }
                            //get the customer credit and index
                            //custcredit = custonline.getcredit();
                            //System.out.println(custcredit);
                            //custindex = custonline.getindex(custonline);
                            //System.out.println(custindex);

                                try {
                                    pricetoreload = Double.valueOf(pricereload.getText());
                                    if (pricetoreload>=0) {
                                        boolean repriceupdate = VM7.repriceProduct(prod, pricetoreload);
                                        String pricereloadnote = "you have just altered the stock price of " + prod.getDescription() + " to " + pricetoreload;
                                        AlertBox.display("Price Update", pricereloadnote);}
                                    if (pricetoreload<0) AlertBox.display("Price Update", "New Price cannot be negative");
                                    //System.out.println("you have just loaded " + prod.getDescription() + " by " + qtytoreload);
                                    //String newcustbalancestr = String.format("%1f", newcustbalance);
                                    //String purchasenote="you have just purchased a " + prod.getDescription() + " Enjoy !!";
                                    //String purchasenote="You purchased a "+ prod.getDescription() +" your account has been updated your new balance is Euro" + df2.format(newcustbalance) + " Continue shopping or Press Exit";
                                    //AlertBox.display("Credit Update",purchasenote);
                                    //System.out.println(purchasenote);
                                    //now write back to customerindex with his new credit-
                                    //System.out.println("you have the following credit " + custonline.getcredit());
                                } catch (NumberFormatException e9) {
                                    AlertBox.display("Product Price Update", "Please select a new Price");
                                }

                            }


                }catch (NullPointerException e3) {
                    AlertBox.display("Product Price Update", "Please select a Product to Price adjust");
                }


            comboboxadmin.getItems().clear();
            producttypes = VM7.getProducts();
            for (Product p:producttypes)
                comboboxadmin.getItems().addAll(p.getDescription()+"@ Euro "+ p.getPrice()+" Qty In Stock "+p.getstock());
            qtyreload.clear();
            pricereload.clear();
        });




        submitaddnewprod.setOnAction(e ->
        {

            GridPane gridPaneaddtoProdlist = new GridPane();
            gridPaneaddtoProdlist.setHgap(5);
            gridPaneaddtoProdlist.setVgap(5);
            gridPaneaddtoProdlist.add(new Label("Product Name:"), 0, 0);
            gridPaneaddtoProdlist.add(newprodname, 1, 0);
            gridPaneaddtoProdlist.add(new Label("Price"), 0, 1);
            gridPaneaddtoProdlist.add(newprodprice, 1, 1);
            gridPaneaddtoProdlist.add(new Label("Qty"), 0, 2);
            gridPaneaddtoProdlist.add(newprodqty, 1, 2);

            // Set properties for UI
            gridPaneaddtoProdlist.setAlignment(Pos.CENTER);
            newprodname.setAlignment(Pos.BOTTOM_LEFT);
            newprodprice.setAlignment(Pos.BOTTOM_LEFT);
            newprodqty.setAlignment(Pos.BOTTOM_LEFT);
            //GridPane.setHalignment(btnLogin, HPos.RIGHT);
            gridPaneaddtoProdlist.add(submitprodtoadd, 1, 5);
            gridPaneaddtoProdlist.add(returntoreload, 1, 8);

            sceneaddnewprod = new Scene(gridPaneaddtoProdlist, 700, 500);
            primaryStage.setTitle("Add New Product Scene"); // Set title
            primaryStage.setScene(sceneaddnewprod); // Place the scene in the stage
            primaryStage.show(); // Display the stage
        });

        submitprodtoadd.setOnAction(e ->
                {
                    VendingMachine VM4 = new VendingMachine();
                    ArrayList<Product> producttypes = VM4.getProducts();
                    try {
                        String readnewprodname = newprodname.getText().toString();
                        Double readnewprodprice = Double.valueOf(newprodprice.getText());
                        int readnewprodqty = Integer.parseInt(newprodqty.getText());


                    if (!readnewprodname.equals("") &&(readnewprodprice>0) && (readnewprodqty>0)) {
                            //System.out.println("Data is missing -please enter all data");
                            Product prodtoadd = new Product(readnewprodname, readnewprodprice, readnewprodqty);
                            boolean reloadupdate = VM4.addProduct(prodtoadd);
                            String addnewnote = "you have just added newproduct " + readnewprodname + " by " + readnewprodqty;
                            AlertBox.display("New Product Add Update", addnewnote);
                            //System.out.println("you have just loaded " + proddesctoadd + " by " + qtytoadd);

                            //after add reset the scene control
                            newprodname.clear();
                            newprodprice.clear();
                            newprodqty.clear();
                            //primaryStage.close();
                            comboboxadmin.getItems().clear();
                            producttypes = VM4.getProducts();
                            for (Product p : producttypes)
                                comboboxadmin.getItems().addAll(p.getDescription() + "@ Euro " + p.getPrice() + " Qty In Stock " + p.getstock());
                        }
                        else  AlertBox.display("New Product Add Update", "Please add full product detail-Name,Price in Euro(Not 0) & Qty (Not 0)");
                    }catch (NumberFormatException e1){
                        AlertBox.display("New Product Add Update", "Please add full product detail-Name,Price in Euro & Qty");
                    }



                });


        submitdeleteprod.setOnAction(e ->
        {
            VendingMachine VM5 = new VendingMachine();
            ArrayList<Product> producttypes = VM5.getProducts();
            try {
            prodsel = comboboxadmin.getValue().toString();
            nameend = prodsel.indexOf("@");
            prodname=prodsel.substring(0,nameend);
            //System.out.println(prodname);


            //String readprodnametoremove = removeprodname.getText().toString();
            for (Product p: producttypes)
                if ((p.getDescription().equals(prodname)))
                    prod = p;
            //double readnewprodprice = Double.valueOf(newprodprice.getText());
            //int readnewprodqty = Integer.parseInt(newprodqty.getText());

            //Product prodtoremove = new Product(r);
            boolean removeprodupdate = VM5.removeProduct(prod);
            String removeprodnote = "you have just removed the Product " + prodname;
            AlertBox.display("Product Deleted", removeprodnote);
            System.out.println("you have just removed "+prodname);


            }catch (NullPointerException e2) {
                AlertBox.display("Product Delete Update", "Please select a Product to remove");
            }
            comboboxadmin.getItems().clear();
            producttypes = VM5.getProducts();
            for (Product p:producttypes)
                comboboxadmin.getItems().addAll(p.getDescription()+"@ Euro "+ p.getPrice()+" Qty In Stock "+p.getstock());
            qtyreload.clear();
        });

        returntoreload.setOnAction(e ->
        {
            primaryStage.setTitle("ReLoad Products Scene"); // Set title
            primaryStage.setScene(sceneadmin); // Place the scene in the stage
            primaryStage.show(); // Display the stage
        });


        exitshop.setOnAction(e ->
        { primaryStage.close(); });

        viewcustcredit.setOnAction(e ->
        {AlertBox.display("Customer Credit", custonline.getusername()+" - you have the following credit Euro" + df2.format(custonline.getcredit()));
        });


        //Create a scene and place on stage
        scenelogin = new Scene(gridPane, 400, 250);
        primaryStage.setTitle("Vending Machine Login"); // Set title
        primaryStage.setScene(scenelogin); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }

    private void checklogin() {
        // Get values from text fields
        String checkUser = txtusername.getText().toString();
        String checkPw=pf.getText().toString();
        //int checkPw = Integer.parseInt(pf.getText());

        //check if User is customer

        custonline = custonline.checklogin(checkPw, checkUser);
        //System.out.println(custonline.getusername());
        Customer blankcust=new Customer();

        if (custonline.getindex(custonline)>=0) {

            //AlertBox.display("Welcome","Welcome Customer - Enter to view Products");

            //System.out.println("Welcome Customer");
            welcomestr="Welcome "+custonline.getusername()+" - you have the following credit Euro" + df2.format(custonline.getcredit());
            //System.out.println(welcomestr);
        }
        //check if User is admin

        adminonline = adminonline.checklogin(checkPw, checkUser);
        if (adminonline.getindex(adminonline)>=0) {
            welcomestr="Welcome Admin"+adminonline.getusername();
            //System.out.println(welcomestr);
        }
        if ((custonline.getindex(custonline)==-1) && (adminonline.getindex(adminonline)==-1))
            AlertBox.display("Login Error","login not successful - Try Again");
            //System.out.println("Not a Customer or Admin - Login Unsuccessful - Try again or X to exit");
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }

}


