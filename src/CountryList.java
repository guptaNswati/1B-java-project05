
/**
 * @class CountryList[contains linked list of CountryNode objects and its size]
 */
public class CountryList implements Cloneable
{
       /**
         * @member head[Type: CountryNode,for pointing the first node of linked list of CountryNode objects]
         * @member size[Type: int, for holding the siz of the list]
         */
        private CountryNode head;
        private int size;

        /**
         * creates an empty CountryList object
         * Initializes head as null and size zero
         */
        public CountryList()
        {
            this.head = null;
            this.size = 0;
        }
        
        /***
         * Checks whether the list is empty or not, to be used in add method
         * @return boolean
         */   
        public boolean isEmpty()
        {
         // If head is not pointing to any nodes, then our list is empty.
            if (this.head == null) 
                return true;

            // Otherwise, there are one or more nodes in the list.
            return false;
        }
         
        /***
         * Takes a Country object and adds it to the end of the list
         * @param someCountry[Country object]
         */
        public void add(Country someCountry)     
        {
            // creates a new node for to be added in the list
            CountryNode newNode = new CountryNode(someCountry);
            
            // if isEmpty() is true, add new node as first node, increase size and make head point to it
            if (this.isEmpty())
            {
                head = newNode;            
                this.size++;
                return;
            }
            // If reaches here, it means that the list is not empty
            // And make a new tempNode variable, points to the head
            // Now, adjust the tempNodes such that it checks the list until its finds the last node
            // Adds newNode to end of list and increase the size of the list   
            CountryNode tempNode = head;

            while (tempNode.getNext() != null)
            {
                tempNode = tempNode.getNext();                
            }
            tempNode.setNext(newNode);
            this.size++;   
        }
        
        /**
         * @overrides Country.toString() to output list of nodes added in the list
         * @return a string containing information about every country in the list
         */
        public String toString()
        {
            String listOfCountries = " ";
            
            CountryNode walker = this.head;
            
            while (walker != null)
            {
                listOfCountries += walker.getCountry().toString() + " " + "\n";
                walker = walker.getNext();            
            }
            return listOfCountries;        
        }
        
        /**
         * 
         * To be used in inserAtIndex()
         * @param index[int, to find the object at specified index]
         * @return Country object
         */
        public Country getIndex(int index)
        {
            // TODO Auto-generated method stub        
                CountryNode walker = this.head;
                int i = 0;

                // traverse the list until either:
                // walker reaches the end of the list; or
                // we've reached client's index of interest.
                while(walker != null && i <= index)
                {
                    // reached requested interest  
                    // so return the node we're at 
                    if (i == index)
                        return walker.getCountry();

                    // move to the next node
                    else
                    walker = walker.getNext();

                    // increment the position
                    i++;
                }
                
                // we have NOT reached the client's index of interest
                // so we have nothing to return
                return null;
         }
        
        public void setIndex(int index, Country someCountry)
        {
            CountryNode walker = this.head;
            int i = 0;

            // traverse the list until either:
            // walker reaches the end of the list; or
            // we've reached client's index of interest.
            while(walker != null && i <= index)
            {
                // reached requested interest  
                // so return the node we're at 
                if (i == index) 
                    walker.setCountry(someCountry);
                
                else
                    walker = walker.getNext();
                i++;
            }
        }
        
        /**
         * Takes a Country object and an int
         * Inserts the country at the location specified by index.
         * @param someCountry[Country object]
         * @param index[an int that specifies the location of Country object to be added in list]
         */
        public void insertAtIndex(Country someCountry, int index)
        {
            //Insert at the beginning
            if (index == 0)
            {
                // creates the new node, sets it next node pointed by head, and then makes head point to it
                CountryNode newNode = new CountryNode(someCountry);            
                newNode.setNext(head);            
                head = newNode;
                
                // outputs the new add
                System.out.println("New Country  " + newNode.getCountry().getName() + 
                        " is added at the begining of the list." + "\n" + 
                        "The details are: " + "\n" + newNode.getCountry());
                this.size++;            
            }
            //Insert in the middle
            else if (index < this.size)
            {
                CountryNode tempNode = head;
                
                // gets the node, before the specified index to be inserted as its next
                for(int i = 1; i < index; i++)
                {
                    tempNode = tempNode.getNext();            
                }
                
                // save the reference for the next node
                CountryNode currentNode = tempNode.getNext(); 
                
                CountryNode newNodeToInsert = new CountryNode(someCountry);
                tempNode.setNext(newNodeToInsert);
                
                System.out.println("New Country  " + newNodeToInsert.getCountry().getName() + 
                        " is added in the middle of the list." + "\n" + 
                        "The details are: " + "\n" + newNodeToInsert.getCountry());
                
                // after inserting the new node, set the current node next to new node
                newNodeToInsert.setNext(currentNode); 
                size++;            
            }
            
            //Insert at the end        
            else if (index >= this.size)
            {
                // simply call the add() will add new node at the end of the list
                this.add(someCountry);
                
                System.out.println("New Country  " + someCountry.getName() + 
                        " is added at the end of the list." + "\n" + 
                        "The details are: " + "\n" + someCountry);
            } 
        }
        
        /**
         * Takes a Country object and checks if the name of the country can be found in the list
         * @param someCountry[Country object]
         * @return Country object
         */
        public Country contains(Country someCountry)
        {  
             CountryNode walker = this.head;
             
             while (walker != null)
             {             
                 if (walker.getCountry().equals(someCountry))                        
                     return walker.getCountry();                              
                                                          
                 walker = walker.getNext();             
             }
           return null;
        } 
               
        /**
         * @return size of the list
         */
        public int size()
        {
            // TODO Auto-generated method stub
            return this.size;
        }
        
        /**
         * Clones a CountryList object by allocating a new object of type CountryList.
         * Then adds a deep copy of all nodes 
         * @return Object     a deep copy of CountryList object
         */
        protected Object clone() 
        {
            CountryList clonedCountryList;
            
            // checks if list to be copied is empty 
            // if it is return null, nothing to copy
            if (this.size == 0)
                return null;
            
            else   
            clonedCountryList = new CountryList();
           
            CountryNode walker = this.head;
            
           // use while loop to clone on each node of our new list
            while (walker != null)
            {
                clonedCountryList.add((Country) walker.getCountry().clone());
                walker = (CountryNode) walker.getNext();
            }
            
            clonedCountryList.size = this.size;
            
            return clonedCountryList;           
        }
        /**
         * Changes the value of the "name" field of Country object in CountryList
         * Changes hard coded three indices in "subscriptions" field of Country object in CounryList
         */
        public void modifyObjectsOfListElement()
        {
            // changing heads fields
            // changing the name of heads Country object to its next nodes Country Object name
            CountryNode walker = this.head;
            walker.getCountry().setName(walker.getNext().getCountry().getName());

            // with a for loop changing the subscription data of Country object of head 
            // with subscription data of heads next Country object subscription data 
            // at hard coded indexes to make the changes visible
            for (int j = 30; j < 33; j++)
            {
                walker.getCountry().changeCountrySubscription(j, walker.getNext().getCountry().getSubscriptions()[j].getSubscriptions());
            }
        }
}