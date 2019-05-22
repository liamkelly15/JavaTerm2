package sample;
public class VendingException extends RuntimeException
{
   public VendingException(String reason)
   {
      super(reason);
   }
}