package sample;
/**Liam Kelly 8909849
   A product in a vending machine.
*/
public class Product
{  
   private String description;
   private double price;
   private int stock;

   /**
      Constructs a Product object
      @param aDescription the description of the product
      @param aPrice the price of the product
   */
   public Product(String aDescription, double aPrice, int aStock)
   {  
      description = aDescription;
      price = aPrice;
      stock = aStock;
      
   }
   
   /**
      Gets the description.
      @return the description
   */
   public String getDescription()
   { 
      return description;
   }
   
   /**
      Gets the price.
      @return the price
   */
   public double getPrice()
   {  
      return price;
   }

   public int getstock()
   {  
      return stock;
   }

   public void removeastock()
   {
       stock = stock-1;
    }
   
    public void addtostock(int newstock)
   {
       stock = stock+newstock;
    }

   public void changeprice(double newprice)
   {
      price=newprice;
   }
  
   /**
      Determines of this product is the same as the other product.
      @param other the other product
      @return true if the products are equal, false otherwise
   */
   public boolean equals(Object other)
   { 
      if (other == null) return false;
      Product b = (Product) other;
      return description.equals(b.description) && price == b.price;
   }
   
   /**
      Formats the product's description and price.
   */
   public String toString()
   { 
      return description + "," + price + "," + stock;
   }
}