// Main.java
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nWelcome to the phonebook manager");
            System.out.println("\nPhonebook Menu:");
            System.out.println("1. Insert New Contact");
            System.out.println("2. Search For a Contact");
            System.out.println("3. Display all Contacts");
            System.out.println("4. Delete Contact");
            System.out.println("5. Block Contact");
            System.out.println("6. Unblock Contact");
            System.out.println("7. Update Contact");
            System.out.println("8. Sort Contacts");
            System.out.println("9. Display Blocked Contacts");
            System.out.println("10. Display Deleted Contacts");
            System.out.println("11. Analyze Search Efficiency");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");
            int choice = getValidInteger(scanner);
            switch (choice) {
                case 1:
                    insertContact(scanner, phonebook);
                    break;
                case 2:
                    searchContact(scanner, phonebook);
                    break;
                case 3:
                    phonebook.displayContacts();
                    break;
                case 4:
                    deleteContact(scanner, phonebook);
                    break;
                case 5:
                    blockContact(scanner, phonebook);
                    break;
                case 6:
                    unblockContact(scanner, phonebook);
                    break;
                case 7:
                    updateContact(scanner, phonebook);
                    break;
                case 8:
                    phonebook.sortContacts();
                    break;
                case 9:
                    phonebook.displayBlockedContacts();
                    break;
                case 10:
                    phonebook.displayDeletedContacts();
                    break;
                case 11:
                    phonebook.analyzeSearchEfficiency();
                    break;
                case 12:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void insertContact(Scanner scanner, Phonebook phonebook) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number (e.g., 0812345678): ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter ID (numeric): ");
        long ID = getValidLong(scanner);
        Contact contact = new Contact(name, phoneNumber, email, ID);
        if (phonebook.isValidPhoneNumber(phoneNumber) && phonebook.isValidID(String.valueOf(ID)) && phonebook.isValidEmail(email)) {
            phonebook.insertContact(contact);
        } else {
            System.out.println("Invalid input! Please check the phone number, ID, or email format.");
        }
    }

    private static void searchContact(Scanner scanner, Phonebook phonebook) {
        System.out.print("Enter contact name to search: ");
        String name = scanner.nextLine();
        int index = phonebook.searchContact(name);
        if (index != -1) {
            System.out.println("Contact found:");
            System.out.println(phonebook.getContact(index));
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void deleteContact(Scanner scanner, Phonebook phonebook) {
        System.out.print("Enter contact name to delete: ");
        String name = scanner.nextLine();
        phonebook.deleteContact(name);
    }

    private static void blockContact(Scanner scanner, Phonebook phonebook) {
        System.out.print("Enter contact name to block: ");
        String name = scanner.nextLine();
        phonebook.blockContact(name);
    }

    private static void unblockContact(Scanner scanner, Phonebook phonebook) {
        System.out.print("Enter contact name to unblock: ");
        String name = scanner.nextLine();
        phonebook.unblockContact(name);
    }

    private static void updateContact(Scanner scanner, Phonebook phonebook) {
        System.out.print("Enter old contact name: ");
        String oldName = scanner.nextLine();
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        System.out.print("Enter new ID: ");
        long ID = getValidLong(scanner);
        Contact newContact = new Contact(name, phoneNumber, email, ID);
        phonebook.updateContact(oldName, newContact);
    }

    private static long getValidLong(Scanner scanner) {
        while (true) {
            try {
                return Long.parseLong(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a valid number: ");
            }
        }
    }

    private static int getValidInteger(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a valid integer: ");
            }
        }
    }
}
