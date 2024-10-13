// Phonebook.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Phonebook {
    private ArrayList<Contact> contacts;
    private ArrayList<Contact> deletedContacts;
    private ArrayList<Contact> blockedContacts;

    public Phonebook() {
        contacts = new ArrayList<>();
        deletedContacts = new ArrayList<>();
        blockedContacts = new ArrayList<>();
    }

    public void insertContact(Contact contact) {
        if (contact.getName() == null || contact.getName().trim().isEmpty()) {
            System.out.println("Contact name cannot be null or empty.");
            return;
        }
        if (isUnique(contact.getPhoneNumber(), contact.getID())) {
            contacts.add(contact);
            System.out.println("Contact added.");
        } else {
            System.out.println("Contact with the same phone number or ID already exists.");
        }
    }

    public boolean isUnique(String phoneNumber, long ID) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber) || contact.getID() == ID) {
                return false;
            }
        }
        return true;
    }

    public int searchContact(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Contact getContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            return contacts.get(index);
        }
        return null;
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }
        for (Contact contact : contacts) {
            if (!contact.isBlocked()) { // Only show non-blocked contacts
                System.out.println(contact);
            }
        }
    }

    public void displayDeletedContacts() {
        if (deletedContacts.isEmpty()) {
            System.out.println("No deleted contacts.");
            return;
        }
        for (Contact contact : deletedContacts) {
            System.out.println(contact);
        }
    }

    public void displayBlockedContacts() {
        if (blockedContacts.isEmpty()) {
            System.out.println("No blocked contacts.");
            return;
        }
        for (Contact contact : blockedContacts) {
            System.out.println(contact);
        }
    }

    public void deleteContact(String name) {
        int index = searchContact(name);
        if (index != -1) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Are you sure you want to delete the contact '" + name + "'? (yes/no): ");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("yes")) {
                Contact contact = contacts.remove(index);
                deletedContacts.add(contact); // Add to deleted contacts list
                System.out.println("Contact '" + name + "' has been deleted.");
            } else {
                System.out.println("Deletion canceled.");
            }
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void blockContact(String name) {
        int index = searchContact(name);
        if (index != -1) {
            Contact contact = contacts.get(index);
            if (!contact.isBlocked()) {
                contact.setBlocked(true);
                blockedContacts.add(contact);
                System.out.println("Contact '" + name + "' has been blocked.");
            } else {
                System.out.println("Contact is already blocked.");
            }
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void unblockContact(String name) {
        int index = searchContact(name);
        if (index != -1) {
            Contact contact = contacts.get(index);
            if (contact.isBlocked()) {
                contact.setBlocked(false);
                blockedContacts.remove(contact);
                System.out.println("Contact '" + name + "' has been unblocked.");
            } else {
                System.out.println("Contact is not blocked.");
            }
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void updateContact(String oldName, Contact newContact) {
        if (newContact.getName() == null || newContact.getName().trim().isEmpty()) {
            System.out.println("New contact name cannot be null or empty.");
            return;
        }
        int index = searchContact(oldName);
        if (index != -1 && isUnique(newContact.getPhoneNumber(), newContact.getID())) {
            contacts.set(index, newContact);
            System.out.println("Contact '" + oldName + "' has been updated to '" +
                    newContact.getName() + "'.");
        } else {
            System.out.println("Contact not found or the new phone number/ID is not valid.");
        }
    }

    public void sortContacts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose sorting criteria:");
        System.out.println("1. Sort by Name");
        System.out.println("2. Sort by ID");
        System.out.print("Enter choice: ");
        int criteriaChoice = Integer.parseInt(scanner.nextLine());
        System.out.println("Choose sort order:");
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        System.out.print("Enter choice: ");
        int orderChoice = Integer.parseInt(scanner.nextLine());

        Comparator<Contact> comparator;
        if (criteriaChoice == 1) {
            comparator = Comparator.comparing(Contact::getName);
        } else if (criteriaChoice == 2) {
            comparator = Comparator.comparingLong(Contact::getID);
        } else {
            System.out.println("Invalid criteria choice.");
            return;
        }
        if (orderChoice == 2) {
            comparator = comparator.reversed();
        } else if (orderChoice != 1) {
            System.out.println("Invalid order choice.");
            return;
        }
        Collections.sort(contacts, comparator);
        System.out.println("Contacts have been sorted.");
    }

    public void analyzeSearchEfficiency() {
        System.out.println("Time complexity of search algorithm: O(n)");
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^(081|085)[0-9]{7}$"); // Regex for phone number validation
    }

    public boolean isValidID(String id) {
        return id.matches("^[0-9]{1,20}$"); // Regex to ensure ID is 1 to 20 digits long
    }

    public boolean isValidEmail(String email) { // Basic email validation regex
        String emailRegex = "^[a-zA-Z0-9._%+-]+@gmail\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }
}
