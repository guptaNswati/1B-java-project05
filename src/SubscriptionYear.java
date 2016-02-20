
/**
* @param SubscriptionYear[having two private instance variables]      
*/
public class SubscriptionYear implements Cloneable
{
   /**
    * @param year[Type: int, stores the year for a subscription data]
    * @param subscriptions[Type: double, stores the number of subscriptions for a specific year]
    */
   private int year;
   private double subscriptions;
   
   SubscriptionYear(int year, double subscriptions)
   {       
       this.year = year;
       this.subscriptions = subscriptions;        
   }
  
   public void setYear(int year)
   {
       this.year = year;
   }
     
   public void setSubscriptions(double subscriptions)
   {
       this.subscriptions = subscriptions;
   }
   
   public int getYear() { return year; }
   
   public double getSubscriptions() { return subscriptions; }

  /**
   * @return subscription as a String
   */
   public String toString()
   {        
       return " " + this.getSubscriptions();
   }
   
   /**
    * Clones a SubscriptionYear object by allocating a new object of type SubscriptionYear.
    * @return Object     a deep copy of SubscriptionYear object
    */
   protected Object clone()
   {                  
       SubscriptionYear clonedSubscriptionYear = new SubscriptionYear(this.year, this.subscriptions);
               return clonedSubscriptionYear;       
   }   
}