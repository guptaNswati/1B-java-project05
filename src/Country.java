
/**
 * @class Country[contains three private instance variables: name, array of SubscriptionYear and count]  
 */
public class Country implements Cloneable
{
    /**
     * @member name[Type: String, for storing the name of the country]
     * @member subscriptions[Type: 1D array of type SubscriptionYear, for holding all the subscription data for a country]
     * @member count[Type: int, for keeping the index of subscriptions array]
     */
    private String name;
    private SubscriptionYear[] subscriptions;  
    private int count = 0;
    
    /**
     * New constructor that takes in one parameter, to be used to create a temporary Country object containing name of the Country] 
     * @param countryName[an object of type String, which is the name of the country]
     */
    public Country(String countryName)
    {
        this.name = countryName;        
    }

    // old constructor with two parameters 
    public Country(String countryName, int numOfYears)
    {
        this.name = countryName;
        this.subscriptions = new SubscriptionYear[numOfYears];
    }
    
    /**
     * Takes in two parameters and uses it to create a new SubscriptionYear object
     * Saves SubscriptionYear object in subscriptions array
     * @param year[gets stored in subscriptions array as SubscriptionYear year member 
     * @param subscriptionData[gets stored in subscriptions array as SubscriptionYear subscription member]
     */
    public void addSubscriptionYear(int year, double subscriptionData)
    {
        SubscriptionYear currentYearData = new SubscriptionYear(year, subscriptionData);
        this.subscriptions[count] = currentYearData;           

        count++;
    }
    
    /**
     * @override Object.equlas() to check if two objects of type Country are equal, based on their name
     * @return boolean
     */
    public boolean equals(Object someObject)
    {   
        // if someObject is null, simply return
        if (someObject == null)
            return false;
       
        // else checks if name of calling object, ignore case equals object passed in
        // someOject is of type Object, so it is casted in to Country before comparing it with Country object 
        return (this.name.equalsIgnoreCase(((Country) someObject).getName()));                                  
    }   

    /**
     * Takes in two parameters of type 
     * Checks the out of range data
     * Calculates total number of subscriptions for a specified period
     * @param startYear[holds the value passed by user every time method is called and gets updated as the subscriptions array years]
     * @param endYear[holds the value passed by user every time method is called and gets updated as the subscriptions array years]
     * @return total number of subscriptions for a specified period
     */
    public double getNumSubscriptionsForPeriod(int startYear, int endYear)
    {
        double totalSubscriptions = 0;

        if (startYear < this.subscriptions[0].getYear()) 
        {
            System.out.println("Please enter a valid year. The starting year "
                    + "is less than " + subscriptions[0].getYear());

            // updates the start year
            startYear = this.subscriptions[0].getYear();

            System.out.println("Starting from "+ startYear + " total number of subscriptions "); 
        } 
        else if (startYear > this.subscriptions[this.subscriptions.length - 1].getYear())
        {
            System.out.println("Please enter valid years. The requested years are out of range");
            return 0;
        }

        if (endYear < this.subscriptions[0].getYear()) 
        {
            System.out.println("Please enter valid years. The requested years are out of range");


            return 0;
        } 
        else if (endYear >  this.subscriptions[this.subscriptions.length - 1].getYear()) 
        {
            System.out.println("Please enter a valid year. The end year "
                    + "is greater than " + subscriptions[this.subscriptions.length - 1].getYear());

            // updates end year
            endYear = this.subscriptions[this.subscriptions.length - 1].getYear();

            System.out.println("Total number of subscriptions till " + endYear); 
        }

        for(int i = 0; i < this.subscriptions.length; i++)
        {
            if (this.subscriptions[i].getYear() == startYear)    
            {
                for(int j = i; j < this.subscriptions.length; j++)
                {
                    totalSubscriptions += this.subscriptions[j].getSubscriptions();
                    if (this.subscriptions[j].getYear() == endYear) 
                    {
                        break;
                    }
                }
                break;                                       
            }
        }
        return totalSubscriptions;
    }
    /**
     * overrides subscription.toString()
     * @return String of country data, containing its name and subscription data
     */
    public String toString()
    {
        String countryName = this.getName();
        
        String totalCountryData = " ";
        for(int i = 0; i < this.subscriptions.length; i++)
        {
            String countryData = subscriptions[i].toString();
            totalCountryData += countryData;
        
        } 
        return countryName + '\n' + totalCountryData + '\n';
    }
    
    // adding setter() to change name field of Country object from CountryList to test cloned list
    public void setName(String countryName)
    {
        this.name = countryName;
    }
    
    public String getName() { return name; }

    public SubscriptionYear[] getSubscriptions() { return subscriptions; }
    
    /**
     * Clones a Country object by allocating a new object of type Country
     * Then every single array position of attribute "subscriptions" is cloned with a for loop
     * @return Object [a deep copy of Country object]
     */
    protected Object clone()
    {
        Country clonedCountry;
        
        // checks if Country object to be cloned is null
        if (this.count == 0)
            return null;
        
        else
        clonedCountry = new Country(this.name, this.subscriptions.length);       
        
        for(int i = 0; i < this.subscriptions.length; i++)
        {        
            clonedCountry.subscriptions[i] = (SubscriptionYear)subscriptions[i].clone();
        }
        
        clonedCountry.count = this.count;
        
        return clonedCountry;   
    }
    
    /**
     * To change elements of subscriptions field of Country object to test cloned list.
     * @param index [of type int for specifying index to be changed]
     * @param data [of type double to be stored in subscriptions array at specified index]
     */   
    public void changeCountrySubscription(int index, double data)
    {
        this.subscriptions[index].setSubscriptions(data);        
    }
}            