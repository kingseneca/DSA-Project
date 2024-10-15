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


### **2\. Stack**
 Stack is a linear data structure that follows the Last In, First Out (LIFO) principle. This means the last element added to the stack will be the first one to be removed.

#### **Importance:**
 Stack is used for managing deleted contacts and blocked contacts. Since recently deleted or blocked contacts are more likely to be referenced or recovered, the LIFO nature of the stack ensures the most recent contact is accessed first.
The stack operations are fast and straightforward, making it ideal for managing temporary data like deleted or blocked contacts.
Advantages:

Fast insertion and removal: both are O(1) operations, making it efficient to work with the most recent contacts.
Ensures that the most recent data (deleted or blocked contacts) is handled first, which aligns with typical use cases of recovery or unblocking.

### **2\. QuickSort**
 
QuickSort is a highly efficient sorting algorithm used for rearranging elements in an array or list. It operates on the divide-and-conquer principle, which divides a large problem into smaller sub-problems and recursively solves them.

#### **Importance:**
 QuickSort, with an average time complexity of O(n log n), is faster than simpler sorting algorithms like Selection Sort or Bubble Sort, which have O(n²) time complexity. QuickSort is especially effective for large datasets.

In-Place Sorting: QuickSort operates in-place, meaning it does not require additional memory or storage space, making it efficient in terms of memory usage.

Versatility: QuickSort can handle various types of data, such as integers, floating-point numbers, and even strings, making it suitable for this application's task of sorting contacts by Name or ID.


## **contributers to the project**

*Stephen Indongo (224016393)
*Tukuna Mulundu  (224068199)
*Vetjevera Uandara (224027166)
*Ester Hilukilwa (223136050)
*Cristiano Feijo (224045040)
*Shiwovanhu Iitula (224079255)
