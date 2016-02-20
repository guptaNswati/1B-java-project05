project folder:
project05_swatig/


Brief description of submitted files:

src/CountryNode.java
    - CountryNode Class with two private fields.
    - First constructor that takes in one parameter, an object of type Country.
    - Second constructor that takes in two parameters, an object of type Country and an object of type CountryNode.
    - Implements interface Cloneable. 
    - Added clone() makes a deep copy of CountryNode object by allocating a new object of type CountryNode.
    - Include setter () for the attribute next.
    - Include getter () for all attributes.

src/CountryList.java
    - CountryList class that contains linked list of CountryNode objects and its size.
    - A constructor that creates an empty CountryList object and can store as many objects as the user might want to add to it. 
    - Implements interface Cloneable. 
    - Added clone() that makes a deep copy of CountryList object by allocating a new object of type CountryList and adding a deep copy of all nodes. 
    - Added modifyObjectsOfListElement() that changes the value of the "name" and "subscriptions" field of Country object in CountryList.         
    - Include add() that takes a Country object as parameter and adds that new object to the end of the list.
    - Include contains() that takes a Country object as parameter and checks if the name of the country can be found in the list.    
    - Include toString() which overrides Country.toString() and returns a string containing information about every country in the list.
    - Include insertAtIndex() that takes a Country object and an int index and inserts the country at the location specified by index.

src/CSVReader.java
    - CSVReader Class with three private fields.
    - constructor that takes in filename, reads the cellular.csv file and sets its members data. 
    - getters for members.   


src/SubscriptionYear.java
    - SubscriptionYear Class having two private instance variables, year of type int & subscriptions of type double 
    - A constructor that takes in the year and number of subscriptions.
    - Implements interface Cloneable. 
    - Added clone() that makes a deep copy of SubscriptionYear object by allocating a new object of type SubscriptionYear.
    - Include getter() and setter() for instance variable year.
    - Include getter() and setter() for instance variable subscriptions.
    - Include toString() which returns the number of subscriptions. 
 

src/Country.java
    - Country Class having three private instance variables, name of type String, subscriptions a one dimensional array of type SubscriptionYear & count of type int.
    - Added a new constructor that takes in an object of type String, which is the name of the country. 
    - A constructor that takes in the country name and number of years.
    - Implements interface Cloneable.     
    - Added clone() that makes a deep copy of Country object by allocating a new object of type Country.
    - Added setter() for changing the name field of Country object from CountryList.
    - Added changeCountrySubscription() that takes an int and double to change elements of subscriptions field of Country object to test cloned list.
    - Added equals() that override Object.equlas() to check if two objects of type Country are equal, based on their name
    - Include getter() and setter() for instance variable name.
    - Include getter() and setter() for instance variable subscriptions. 
    - Includes addSubscriptionYear() that create a new SubscriptionYear object and save it in subscriptions array.
    - Includes getNumSubscriptionsForPeriod() returns total number of subscriptions for a specified period.
    - Includes toString() which overrides SubscriptionClass.toString() and returns a representation of the country with its data.
    

src/TestCloneableCountryList.java

    - Includes TestCloneableCountryList Class which creates a list and clones it.
    - Include createCloneableList() that builds a random list of countries from array of Country objects called, allCountries.
    - Include testCloneableList() that clones the country and changes the data in the cloned list to test that the clone is a deep copy. 
    - Tests the TestCloneableCountryList class by cloning the country list and modifying the clone.
    - The implementation of debugListOfCountries() is similar to testRandomListOfCountries() that is to build a list of countries but not randomly.It is used for initial debugging and not to be called in main.
    - Includes main() for running the application.
    - Creates one object of type CSVReader class, which reads input from a CSV file. 
    - Uses the attributes stored in CSVReader object to create objects of type Country class and adds the newest country read into the list .       
    - Adds the data for each country to an array of Country objects.
    - Adds a random selection of countries to a CountryList object.    
       
        
resources/cellular.csv
    - A CSV (Comma Separated Value) file containing cellular data of 252 countries from 1960-2012
    - Row contains the data of each country 
    - First Column contains the country name, followed by its data in a given year 
 
resources/cellular_short.csv 
    - A short CSV file containing cellular data of 3 countries from 1960-2012 
    - Row contains the data of each country 
    - First Column contains the country names, followed by its data in a given year
    
       
resources/RUN.txt
    - console output of CSVReader.java, SubscriptionYear.java, Country.java, CountryNode.java, CountryList.java, TestCloneableCountryList.java.

README.txt
    - description of submitted files