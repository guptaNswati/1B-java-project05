import java.util.Random;

/**
 * Tests CountryList to see if clone() works properly.
 * Starts by creating a list and cloning it.
 * Then changes the data in the cloned list to test that the clone is a deep copy.
 * 
 * @author Foothill College, [Swati Gupta]
 */

public class TestCloneableCountryList 
{
	private static final int LIST_SIZE = 4;

	/**
	 * Builds a list of countries to debug.
	 */
	private void debugListOfCountries(Country [] allCountries)
	{
		// TODO: The purpose is to help you debug
		// Note: The implementation of method is optional.
	}

	/**
	 * Creates a list of randomly selected countries
	 * @param allCountries      An array of Country objects
	 * @param selectionSize     Size of the list to be cloned
	 */
	private CountryList createCloneableList(Country [] allCountries, int selectionSize)
	{	
		Random random = new Random();
		CountryList selectedCountries = new CountryList();
		for (int i = 0; i < selectionSize; i++)
		{
			int selectedIndex = random.nextInt(allCountries.length);
			selectedCountries.add(allCountries[selectedIndex]);
		}

		return selectedCountries;
	}

	/**
	 * Modifies one or more countries print the updated list of countries
	 * @param listOfCountries      The list of countries to be cloned and modified.
	 */
	private CountryList testCloneableList(CountryList listOfCountries)
	{
		// TODO: Complete the implementation of this method.
		//       See suggestions in the to dos below.
	 
	    CountryList clonedList = null;
        
	    // check if the list is empty, return null
        if (listOfCountries == null)
            return clonedList;
        
        // if not, then make a deep copy of CountryList Object 
        else
            clonedList = (CountryList) listOfCountries.clone(); 
        
        // First test case 
        // get a Country object from CountryList object
        // to modify and update one of cloned list's Country object at the specified index
        int firstIndex = 0;
        Country updatedCountry = listOfCountries.getIndex(firstIndex);  
        int selectedIndex = 2; 
        
        clonedList.setIndex(selectedIndex, updatedCountry);
        
        // second test case
        int middleIndex = listOfCountries.size()/2;
        Country secondUpdatedCountry = listOfCountries.getIndex(middleIndex);  
        
        // selects a random index to modify
        Random random = new Random();
        selectedIndex = random.nextInt(listOfCountries.size()); 
        
        clonedList.setIndex(selectedIndex, secondUpdatedCountry);
                     
          // additional test cases, which modify the country name 
          // and subscription information for different countries
            clonedList.modifyObjectsOfListElement();            
            
        return clonedList;
	}

	/**
	 * Uses a CSV to parse a CSV file.
	 * Adds the data for each country to an array of Country objects.
	 * Adds a random selection of countries to a CountryList object.
	 * Clones the country list and modifies the clone.
	 */
	public static void main(String[] args) 
	{
		final String FILENAME = "resources/cellular.csv";	// Directory path for Mac OS X
		//final String FILENAME = "resources\\cellular.csv";	// Directory path for Windows OS (i.e. Operating System)


		// Parse the CSV data file
		//
		CSVReader parser = new CSVReader(FILENAME);

		String [] countryNames = parser.getCountryNames();
		int [] yearLabels = parser.getYearLabels();
		double [][] parsedTable = parser.getParsedTable();		


		// Create and set objects of type Country 
		//
		Country [] countries;
		countries = new Country[countryNames.length];
		Country current;

		for (int countryIndex = 0; countryIndex < countries.length; countryIndex++)
		{
			int numberOfYears = yearLabels.length;   // OR numberOfYears = dataTable[countryIndex].length;

			current = new Country(countryNames[countryIndex], numberOfYears);

			for (int yearIndex = 0; yearIndex < numberOfYears; yearIndex++)
			{
				double [] allSubscriptions = parsedTable[countryIndex];
				double countryData = allSubscriptions[yearIndex];
				current.addSubscriptionYear(yearLabels[yearIndex], countryData);
			}
			countries[countryIndex] = current;
		}

		TestCloneableCountryList application = new TestCloneableCountryList();

        CountryList listOfCountries = application.createCloneableList(countries, TestCloneableCountryList.LIST_SIZE);

        // Output the countries added to the CountryList
        System.out.println("\nList of countries: ");
        System.out.println(listOfCountries);


        // Clone and modify the list of nodes
        // TODO: Complete the implementation of "testCloneableList" to:
        //              - Create a clone of your linked list.
        //              - Modify two or more countries in the cloned linked list.
        CountryList clonedAndModifiedList;
        clonedAndModifiedList = application.testCloneableList(listOfCountries);


        // NOTE REGARDING OUTPUT:
        // The difference between the original and the modified node(s) in the cloned list must be apparent.
        System.out.println("\n\nOriginal list of countries: ");
        System.out.println(listOfCountries);
    
        System.out.println("\n\nModified cloned list of countries: ");
        // testing cloned list by inserting Country object at specified index
        Country countryToBeAdded = listOfCountries.getIndex(2);
        clonedAndModifiedList.insertAtIndex(countryToBeAdded, clonedAndModifiedList.size());
        System.out.println(clonedAndModifiedList);

        // flush the error stream
        System.err.flush();

        System.out.println("\nDone with TestCloneableCountryList.");
    }
}