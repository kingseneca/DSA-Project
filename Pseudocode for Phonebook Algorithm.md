**// Pseudocode for Phonebook Algorithm**

**1.MODULE Main**

    // Entry point of the application  
    FUNCTION main()  
        DECLARE phonebook AS Phonebook  
        DECLARE scanner AS Scanner  
        INITIALIZE scanner  
        WHILE TRUE DO  
            DISPLAY Phonebook Menu  
            DISPLAY options 1 to 12  
            PROMPT user for choice  
            SET choice TO getValidInteger(scanner)  
            SWITCH choice DO  
                CASE 1: insertContact(scanner, phonebook)  
                CASE 2: searchContact(scanner, phonebook)  
                CASE 3: phonebook.displayContacts()  
                CASE 4: deleteContact(scanner, phonebook)  
                CASE 5: blockContact(scanner, phonebook)  
                CASE 6: unblockContact(scanner, phonebook)  
                CASE 7: updateContact(scanner, phonebook)  
                CASE 8: phonebook.sortContacts()  
                CASE 9: phonebook.displayBlockedContacts()  
                CASE 10: phonebook.displayDeletedContacts()  
                CASE 11: phonebook.analyzeSearchEfficiency()  
                CASE 12: DISPLAY Exiting...; CLOSE scanner; RETURN  
                DEFAULT: DISPLAY Invalid choice\! Please try again.  
            
  END SWITCH  
        END WHILE  
    END FUNCTION

    // Function to insert a new contact  
    FUNCTION insertContact(scanner, phonebook)  
        PROMPT Enter name  
        SET name TO scanner.nextLine()  
        PROMPT Enter phone number  
        SET phoneNumber TO scanner.nextLine()  
        PROMPT Enter email  
        SET email TO scanner.nextLine()  
        PROMPT Enter ID  
        SET ID TO getValidLong(scanner)  
          
        DECLARE contact AS Contact(name, phoneNumber, email, ID)  
        IF phonebook.isValidPhoneNumber(phoneNumber) AND phonebook.isValidID(ID) AND phonebook.isValidEmail(email) THEN  
            phonebook.insertContact(contact)  
        ELSE  
            DISPLAY Invalid input\! Please check the phone number, ID, or email format.  
        END IF  
    END FUNCTION

    // Function to search for a contact  
    FUNCTION searchContact(scanner, phonebook)  
        PROMPT Enter contact name to search  
        SET name TO scanner.nextLine()  
        SET index TO phonebook.searchContact(name)  
          
        IF index \!= \-1 THEN  
            DISPLAY Contact found: phonebook.getContact(index)  
        ELSE  
            DISPLAY Contact not found.  
        END IF  
    END FUNCTION

    // Function to delete a contact  
    FUNCTION deleteContact(scanner, phonebook)  
        PROMPT Enter contact name to delete  
        SET name TO scanner.nextLine()  
        phonebook.deleteContact(name)  
    END FUNCTION

    // Function to block a contact  
    FUNCTION blockContact(scanner, phonebook)  
        PROMPT Enter contact name to block  
        SET name TO scanner.nextLine()  
        phonebook.blockContact(name)  
    END FUNCTION

    // Function to unblock a contact  
    FUNCTION unblockContact(scanner, phonebook)  
        PROMPT Enter contact name to unblock  
        SET name TO scanner.nextLine()  
        phonebook.unblockContact(name)  
    END FUNCTION

    // Function to update a contact  
    FUNCTION updateContact(scanner, phonebook)  
        PROMPT Enter old contact name  
        SET oldName TO scanner.nextLine()  
        PROMPT Enter new name  
        SET name TO scanner.nextLine()  
        PROMPT Enter new phone number  
        SET phoneNumber TO scanner.nextLine()  
        PROMPT Enter new email  
        SET email TO scanner.nextLine()  
        PROMPT Enter new ID  
        SET ID TO getValidLong(scanner)  
          
        DECLARE newContact AS Contact(name, phoneNumber, email, ID)  
        phonebook.updateContact(oldName, newContact)  
    END FUNCTION

    // Function to get a valid long input  
    FUNCTION getValidLong(scanner)  
        WHILE TRUE DO  
            TRY  
                RETURN Long.parseLong(scanner.nextLine())  
            CATCH NumberFormatException e  
                PROMPT Invalid input\! Please enter a valid number  
            END TRY  
        END WHILE  
    END FUNCTION

    // Function to get a valid integer input  
    FUNCTION getValidInteger(scanner)  
        WHILE TRUE DO  
            TRY  
                RETURN Integer.parseInt(scanner.nextLine())  
            CATCH NumberFormatException e  
                PROMPT Invalid input\! Please enter a valid integer  
            END TRY  
        END WHILE  
    END FUNCTION  
END MODULE

// Data Structure  
// The Phonebook class maintains an ArrayList of Contact objects for storing contacts.

**2.MODULE Contact**

    // Define the Contact structure  
    STRUCT Contact  
        STRING name  
        STRING phoneNumber  
        STRING email  
        LONG ID  
        BOOLEAN blocked  
          
    // Constructor to initialize a new Contact  
    FUNCTION CreateContact(name: STRING, phoneNumber: STRING, email: STRING, ID: LONG) \-\> Contact  
        IF name IS NULL OR name.trim().isEmpty() THEN  
            THROW IllegalArgumentException("Name cannot be null or empty.")  
        END IF  
        RETURN Contact(name, phoneNumber, email, ID, FALSE) // Blocked defaults to false  
    END FUNCTION

    // Getters  
    FUNCTION GetName(contact: Contact) \-\> STRING  
        RETURN contact.name  
    END FUNCTION

    FUNCTION GetPhoneNumber(contact: Contact) \-\> STRING  
        RETURN contact.phoneNumber  
    END FUNCTION

    FUNCTION GetEmail(contact: Contact) \-\> STRING  
        RETURN contact.email  
    END FUNCTION

    FUNCTION GetID(contact: Contact) \-\> LONG  
        RETURN contact.ID  
    END FUNCTION

    FUNCTION IsBlocked(contact: Contact) \-\> BOOLEAN  
        RETURN contact.blocked  
    END FUNCTION

    // Setters  
    FUNCTION SetName(contact: Contact, name: STRING)  
        IF name IS NULL OR name.trim().isEmpty() THEN  
            THROW IllegalArgumentException("Name cannot be null or empty.")  
        END IF  
        contact.name \= name  
    END FUNCTION

    FUNCTION SetPhoneNumber(contact: Contact, phoneNumber: STRING)  
        contact.phoneNumber \= phoneNumber  
    END FUNCTION

    FUNCTION SetEmail(contact: Contact, email: STRING)  
        contact.email \= email  
    END FUNCTION

    FUNCTION SetID(contact: Contact, ID: LONG)  
        contact.ID \= ID  
    END FUNCTION

    FUNCTION SetBlocked(contact: Contact, blocked: BOOLEAN)  
        contact.blocked \= blocked  
    END FUNCTION

    // String representation of Contact  
    FUNCTION ToString(contact: Contact) \-\> STRING  
        RETURN "Name: " \+ contact.name \+ "\\n" \+   
               "Phone Number: " \+ contact.phoneNumber \+ "\\n" \+   
               "Email: " \+ contact.email \+ "\\n" \+   
               "ID: " \+ contact.ID \+ "\\n" \+   
               "Blocked: " \+ (contact.blocked ? "Yes" : "No")  
    END FUNCTION

END MODULE  
**3.MODULE Phonebook**

    // Data Structures  
    DECLARE contacts AS LIST OF Contact   // List to store all contacts  
    DECLARE deletedContacts AS LIST OF Contact   // List to store deleted contacts  
    DECLARE blockedContacts AS LIST OF Contact   // List to store blocked contacts

    // Constructor to initialize the Phonebook  
    FUNCTION Phonebook()  
        // Initialize contact lists  
        SET contacts \= new ArrayList\<\>()  
        SET deletedContacts \= new ArrayList\<\>()  
        SET blockedContacts \= new ArrayList\<\>()  
    END FUNCTION

    // Method to insert a new contact  
    FUNCTION insertContact(contact AS Contact)  
        IF contact.getName() IS NULL OR contact.getName().trim().isEmpty() THEN  
            PRINT "Contact name cannot be null or empty."  
            RETURN  
        END IF  
        IF isUnique(contact.getPhoneNumber(), contact.getID()) THEN  
            contacts.add(contact) // Add contact to the contacts list  
            PRINT "Contact added."  
        ELSE  
            PRINT "Contact with the same phone number or ID already exists."  
        END IF  
    END FUNCTION

    // Method to check if the contact is unique  
    FUNCTION isUnique(phoneNumber AS STRING, ID AS LONG) RETURNS BOOLEAN  
        FOR EACH contact IN contacts DO  
            IF contact.getPhoneNumber() EQUALS phoneNumber OR contact.getID() EQUALS ID THEN  
                RETURN FALSE // Duplicate found  
            END IF  
        END FOR  
        RETURN TRUE // No duplicates found  
    END FUNCTION

    // Method to search for a contact by name  
    FUNCTION searchContact(name AS STRING) RETURNS INTEGER  
        FOR i FROM 0 TO contacts.size() \- 1 DO  
            IF contacts.get(i).getName() EQUALS name THEN  
                RETURN i // Return the index of the found contact  
            END IF  
        END FOR  
        RETURN \-1 // Not found  
    END FUNCTION

    // Method to get a contact by index  
    FUNCTION getContact(index AS INTEGER) RETURNS Contact  
        IF index \>= 0 AND index \< contacts.size() THEN  
            RETURN contacts.get(index) // Return the contact at the given index  
        END IF  
        RETURN NULL // Invalid index  
    END FUNCTION

    // Method to display all non-blocked contacts  
    FUNCTION displayContacts()  
        IF contacts.isEmpty() THEN  
            PRINT "No contacts available."  
            RETURN  
        END IF  
        FOR EACH contact IN contacts DO  
            IF NOT contact.isBlocked() THEN  
                PRINT contact // Display non-blocked contact  
            END IF  
        END FOR  
    END FUNCTION

    // Method to display deleted contacts  
    FUNCTION displayDeletedContacts()  
        IF deletedContacts.isEmpty() THEN  
            PRINT "No deleted contacts."  
            RETURN  
        END IF  
        FOR EACH contact IN deletedContacts DO  
            PRINT contact // Display deleted contacts  
        END FOR  
    END FUNCTION

    // Method to display blocked contacts  
    FUNCTION displayBlockedContacts()  
        IF blockedContacts.isEmpty() THEN  
            PRINT "No blocked contacts."  
            RETURN  
        END IF  
        FOR EACH contact IN blockedContacts DO  
            PRINT contact // Display blocked contacts  
        END FOR  
    END FUNCTION

    // Method to delete a contact by name  
    FUNCTION deleteContact(name AS STRING)  
        SET index \= searchContact(name) // Search for the contact  
        IF index \!= \-1 THEN  
            PRINT "Are you sure you want to delete the contact '" \+ name \+ "'? (yes/no): "  
            SET confirmation \= SCANNER.nextLine() // Get user confirmation  
            IF confirmation EQUALS "yes" THEN  
                DECLARE contact AS Contact \= contacts.remove(index) // Remove contact from list  
                deletedContacts.add(contact) // Add to deleted contacts  
                PRINT "Contact '" \+ name \+ "' has been deleted."  
            ELSE  
                PRINT "Deletion canceled."  
            END IF  
        ELSE  
            PRINT "Contact not found."  
        END IF  
    END FUNCTION

    // Method to block a contact by name  
    FUNCTION blockContact(name AS STRING)  
        SET index \= searchContact(name)  
        IF index \!= \-1 THEN  
            DECLARE contact AS Contact \= contacts.get(index)  
            IF NOT contact.isBlocked() THEN  
                contact.setBlocked(TRUE) // Block the contact  
                blockedContacts.add(contact) // Add to blocked contacts  
                PRINT "Contact '" \+ name \+ "' has been blocked."  
            ELSE  
                PRINT "Contact is already blocked."  
            END IF  
        ELSE  
            PRINT "Contact not found."  
        END IF  
    END FUNCTION

    // Method to unblock a contact by name  
    FUNCTION unblockContact(name AS STRING)  
        SET index \= searchContact(name)  
        IF index \!= \-1 THEN  
            DECLARE contact AS Contact \= contacts.get(index)  
            IF contact.isBlocked() THEN  
                contact.setBlocked(FALSE) // Unblock the contact  
                blockedContacts.remove(contact) // Remove from blocked contacts  
                PRINT "Contact '" \+ name \+ "' has been unblocked."  
            ELSE  
                PRINT "Contact is not blocked."  
            END IF  
        ELSE  
            PRINT "Contact not found."  
        END IF  
    END FUNCTION

    // Method to update a contact's details  
    FUNCTION updateContact(oldName AS STRING, newContact AS Contact)  
        IF newContact.getName() IS NULL OR newContact.getName().trim().isEmpty() THEN  
            PRINT "New contact name cannot be null or empty."  
            RETURN  
        END IF  
        SET index \= searchContact(oldName) // Search for the old contact  
        IF index \!= \-1 AND isUnique(newContact.getPhoneNumber(), newContact.getID()) THEN  
            contacts.set(index, newContact) // Update the contact in the list  
            PRINT "Contact '" \+ oldName \+ "' has been updated to '" \+ newContact.getName() \+ "'."  
        ELSE  
            PRINT "Contact not found or the new phone number/ID is not valid."  
        END IF  
    END FUNCTION

    // Method to sort contacts  
    FUNCTION sortContacts()  
        PRINT "Choose sorting criteria:"  
        PRINT "1. Sort by Name"  
        PRINT "2. Sort by ID"  
        PRINT "Enter choice: "  
        SET criteriaChoice \= INTEGER(SCANNER.nextLine()) // Get sorting criteria

        PRINT "Choose sort order:"  
        PRINT "1. Ascending"  
        PRINT "2. Descending"  
        PRINT "Enter choice: "  
        SET orderChoice \= INTEGER(SCANNER.nextLine()) // Get sorting order

        DECLARE comparator AS Comparator\<Contact\>

        // Determine comparator based on user choice  
        IF criteriaChoice EQUALS 1 THEN  
            comparator \= Comparator.comparing(Contact::getName)  
        ELSE IF criteriaChoice EQUALS 2 THEN  
            comparator \= Comparator.comparingLong(Contact::getID)  
        ELSE  
            PRINT "Invalid criteria choice."  
            RETURN  
        END IF

        // Determine order based on user choice  
        IF orderChoice EQUALS 2 THEN  
            comparator \= comparator.reversed() // Reverse order for descending  
        ELSE IF orderChoice \!= 1 THEN  
            PRINT "Invalid order choice."  
            RETURN  
        END IF

        Collections.sort(contacts, comparator) // Sort the contacts  
        PRINT "Contacts have been sorted."  
    END FUNCTION

    // Method to analyze search efficiency  
    FUNCTION analyzeSearchEfficiency()  
        PRINT "Time complexity of search algorithm: O(n)"  
    END FUNCTION

    // Method to validate phone number  
    FUNCTION isValidPhoneNumber(phoneNumber AS STRING) RETURNS BOOLEAN  
        RETURN phoneNumber.matches("^(081|085)\[0-9\]{7}$") // Regex for phone number validation  
    END FUNCTION

    // Method to validate ID  
    FUNCTION isValidID(id AS STRING) RETURNS BOOLEAN  
        RETURN id.matches("^\[0-9\]{1,20}$") // Regex for ID validation  
    END FUNCTION

    // Method to validate email  
    FUNCTION isValidEmail(email AS STRING) RETURNS BOOLEAN  
        DECLARE emailRegex AS STRING \= "^\[a-zA-Z0-9.\_%+-\]+@gmail\\\\.\[a-zA-Z\]{2,}$"  
        RETURN email.matches(emailRegex) // Validate email against regex  
     
 END FUNCTION  
END MODULE

