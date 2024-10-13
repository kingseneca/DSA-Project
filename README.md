# **Phonebook Algorithm**

## **Project Description**

The **Phonebook Algorithm** is a Java-based solution designed to manage contacts efficiently. This application allows users to perform various operations on their contact list, including adding, searching, updating, deleting, blocking, and unblocking contacts. The system is built with an intuitive command-line interface that guides users through available functionalities, making it user-friendly and effective for personal or small business use.


## **Solution**

The Phonebook algorithm provides a comprehensive solution for managing contacts effectively. By offering functionalities like searching, updating, and organizing contacts, it aims to enhance user experience while maintaining data integrity.


## **Functionalities**

The Phonebook Algorithm provides the following key functionalities:

1. **Insert a Contact**: Add a new contact to the phonebook.  
2. **Search a Contact**: Find a contact by name.  
3. **Display Contacts**: Show all available contacts.  
4. **Delete a Contact**: Remove a contact from the phonebook.  
5. **Block a Contact**: Prevent a contact from appearing in the contact list.  
6. **Unblock a Contact**: Allow a blocked contact to reappear in the contact list.  
7. **Update a Contact**: Modify the details of an existing contact.  
8. **Sort Contacts**: Organize contacts by name or ID in ascending or descending order.  
9. **Display Blocked Contacts**: View all contacts that have been blocked.  
10. **Display Deleted Contacts**: Review contacts that have been deleted.  
11. **Analyze Search Efficiency**: Get insights into the search algorithm's performance.  
12. **Exit the Application**: Safely terminate the application.

## **Modules and Functions**

The algorithm consists of three main modules: **Main**, **Contact**, and **Phonebook**. Below is a brief overview of each module and its functionalities:

### **1\. Module: Main**

This module serves as the entry point of the application, presenting a menu with options for the user. The main functionalities include:

* **main()**: The primary function that initializes the application and provides the user menu.  
* **insertContact()**: Function to prompt for and add a new contact.  
* **searchContact()**: Function to find a contact by name.  
* **displayContacts()**: Function to show all contacts.  
* **deleteContact()**: Function to remove a specified contact.  
* **blockContact()**: Function to block a specified contact.  
* **unblockContact()**: Function to unblock a specified contact.  
* **updateContact()**: Function to update an existing contact’s details.  
* **sortContacts()**: Function to sort the contacts based on user criteria.  
* **displayBlockedContacts()**: Function to show all blocked contacts.  
* **displayDeletedContacts()**: Function to display deleted contacts.  
* **analyzeSearchEfficiency()**: Function to analyze the search algorithm’s efficiency.

### **2\. Module: Contact**

This module defines the structure of a contact and provides getter and setter methods to manipulate contact data:

* **Contact**: Structure containing fields for name, phone number, email, ID, and blocked status.  
* **CreateContact()**: Constructor to initialize a new Contact object.  
* **Getters and Setters**: Methods to retrieve and update the contact's information.  
* **ToString()**: Method to return a string representation of a contact.

### **3\. Module: Phonebook**

The Phonebook module handles all operations related to managing contacts. Key functions include:

* **insertContact()**: Adds a new contact to the phonebook.  
* **searchContact()**: Searches for a contact by name and returns the index.  
* **displayContacts()**: Displays all non-blocked contacts.  
* **deleteContact()**: Deletes a specified contact and adds it to the deleted contacts list.  
* **blockContact()**: Blocks a specified contact.  
* **unblockContact()**: Unblocks a specified contact.  
* **updateContact()**: Updates the details of an existing contact.  
* **sortContacts()**: Sorts contacts based on user-defined criteria.  
* **isValidPhoneNumber()**: Validates the format of a phone number.  
* **isValidID()**: Validates the ID format.  
* **isValidEmail()**: Validates the email format.


## **Data Structures Used**

### **1\. ArrayList (Java's `ArrayList` class)**

* **Purpose**: Used to store a dynamic list of `Contact` objects.  
* **Reason for Use**: `ArrayList` allows dynamic resizing, making it an excellent choice for managing a growing list of contacts, without needing to define a fixed size in advance.

#### **Importance:**

* **Dynamic Resizing**: As users add or delete contacts, the list grows or shrinks automatically.  
* **Indexed Access**: Contacts can be accessed, updated, or deleted using an index, making operations like searching through the list efficient.

#### **Fundamentals:**

* **Resizing Mechanism**: When the array backing the `ArrayList` fills up, it automatically increases its capacity (usually doubling in size), ensuring that insertion operations remain efficient.  
* **Time Complexity**:  
  * **Search**: O(n) – since each contact needs to be checked one by one unless sorted.  
  * **Add (at end)**: O(1) amortized – adding a contact to the end of the list is constant time unless resizing is needed.  
  * **Remove**: O(n) – removing a contact requires shifting the remaining contacts to fill the gap.

### **2\. HashMap (Java's `HashMap` class)**

* **Purpose**: Used to map phone numbers or contact names to `Contact` objects for quick lookups.  
* **Reason for Use**: To allow constant time retrieval of contact information by phone number or name, avoiding the need to search through the entire list of contacts.

#### **Importance:**

* **Fast Lookup**: Using the hash code of the phone number or name, we can access contact details in constant time O(1), which is crucial for performance in large datasets.  
* **Efficient Storage**: Keys (phone numbers/names) are unique, ensuring no duplicate entries and fast conflict resolution using hashing.

#### **Fundamentals:**

* **Hashing**: A hash function is used to convert the phone number (or name) into a unique hash code. This hash code determines where the `Contact` object is stored in the underlying array.  
* **Time Complexity**:  
  * **Search**: O(1) – on average, retrieving contact information is constant time.  
  * **Insert/Update**: O(1) – adding or updating a contact is done in constant time.  
  * **Remove**: O(1) – removing a contact is also a constant-time operation.

### **3\. TreeMap (Java's `TreeMap` class)**

* **Purpose**: Used to maintain sorted contact names or phone numbers for fast range queries and sorted traversals.  
* **Reason for Use**: Provides an easy way to view contacts in a sorted manner (alphabetically by name or numerically by phone number) while still offering efficient search capabilities.

#### **Importance:**

* **Sorted Data**: Useful for displaying contacts in alphabetical or numerical order without needing to sort the list manually.  
* **Efficient Range Queries**: Allows searching within a specific range of names or numbers (e.g., contacts between 'A' and 'M') efficiently.

#### **Fundamentals:**

* **Balanced Binary Search Tree**: The `TreeMap` is implemented as a Red-Black Tree, a type of self-balancing binary search tree. This ensures that operations such as insertions, deletions, and lookups remain efficient.  
* **Time Complexity**:  
  * **Search**: O(log n) – as the data is structured as a tree, searching for a contact by name or phone number is logarithmic.  
  * **Insert/Delete**: O(log n) – similarly, adding or removing contacts follows logarithmic time complexity due to the balanced tree structure.


## **contributers to the project**

*Stephen Indongo (224016393)
*Tukuna Mulundu  (224068199)
*Vetjevera Uandara (224027166)
*Ester Hilukilwa (223136050)
*Cristiano Feijo (224045040)
*Shiwovanhu Iitula (224079255)
