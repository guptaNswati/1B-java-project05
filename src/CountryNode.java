
/**
 * class CountryNode[contains two private instance variables country and next]
 */
public class CountryNode implements Cloneable
{
    /**
     * @member country[Type: Country]
     * @member next[Type: CountryNode]
     */
    private Country country;
    private CountryNode next;
    
    /***
     * A constructor that takes in an object of type Country. 
     * @param someCountry[object of type Country]
     */
    CountryNode(Country someCountry)
    {
        this.country = someCountry;
        this.next = null;        
    }
    
    /***
     * A constructor that takes in an object of type Country 
     * and an object of type CountryNode
     * @param someCountry[object of type Country]
     * @param node[object of type CountryNode]
     */
    CountryNode(Country someCountry, CountryNode node)
    {
        this.country = someCountry;
        this.next = node;
    }
    
    /***
     * sets CountryNode's next element
     * @param node
     */
    public void setNext(CountryNode node)
    {
        this.next = node;       
    }
    
    /***
     * 
     * @return Country object
     */
    public Country getCountry() { return this.country; }
    
    /***
     * 
     * @return next node in the list
     */
    public CountryNode getNext() { return this.next; }

    public void setCountry(Country someCountry)
    {
        // TODO Auto-generated method stub
        this.country = someCountry;        
    }
    
    /**
     * Clones a CountryNode object by allocating a new object of type CountryNode.
     * Using the constructor that takes in an object of type Country and an object of type CountryNode
     * @return Object     a deep copy of CountryNode object
     */
    protected Object clone()
    {       
       CountryNode clonedCountryNode;
       clonedCountryNode = new CountryNode((Country) this.country.clone(), this.next);
       return clonedCountryNode;
    }
}    
   
    
