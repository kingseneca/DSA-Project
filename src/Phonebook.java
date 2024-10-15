import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;

class Phonebook {
    private ArrayList<Contact> contacts;
    private Stack<Contact> deletedContacts;
    private Stack<Contact> blockedContacts;

    public Phonebook() {
        contacts = new ArrayList<>();
        deletedContacts = new Stack<>();
        blockedContacts = new Stack<>();
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
                deletedContacts.push(contact); // Add to deleted contacts stack
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
                blockedContacts.push(contact);
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

    // QuickSort implementation for sorting contacts
    public void sortContacts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose sorting criteria:");
        System.out.println("1. Sort by Name");
        System.out.println("2. Sort by ID");
        System.out.print("Enter choice: ");
        int criteriaChoice = Integer.parseInt(scanner.nextLine());

        if (criteriaChoice == 1) {
            quickSortByName(0, contacts.size() - 1);
        } else if (criteriaChoice == 2) {
            quickSortByID(0, contacts.size() - 1);
        } else {
            System.out.println("Invalid criteria choice.");
            return;
        }

        System.out.println("Contacts have been sorted.");
    }

    private void quickSortByName(int low, int high) {
        if (low < high) {
            int pivotIndex = partitionByName(low, high);
            quickSortByName(low, pivotIndex - 1);
            quickSortByName(pivotIndex + 1, high);
        }
    }

    private int partitionByName(int low, int high) {
        Contact pivot = contacts.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (contacts.get(j).getName().compareTo(pivot.getName()) <= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    private void quickSortByID(int low, int high) {
        if (low < high) {
            int pivotIndex = partitionByID(low, high);
            quickSortByID(low, pivotIndex - 1);
            quickSortByID(pivotIndex + 1, high);
        }
    }

    private int partitionByID(int low, int high) {
        Contact pivot = contacts.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (contacts.get(j).getID() <= pivot.getID()) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        Contact temp = contacts.get(i);
        contacts.set(i, contacts.get(j));
        contacts.set(j, temp);
    }

    public void analyzeSearchEfficiency() {
        System.out.println("Time complexity of search algorithm: O(n)");
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^(081|085)[0-9]{7}$");
    }

    public boolean isValidID(String id) {
        return id.matches("^[0-9]{1,20}$");
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@gmail\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }
}
