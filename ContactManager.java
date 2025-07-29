import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

public class ContactManager {
    static ArrayList<Contact> contactList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addContact() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        contactList.add(new Contact(name, phone, email));
        System.out.println("Contact added successfully!\n");
    }

    public static void displayContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts to display.\n");
        } else {
            System.out.println("Contact List:");
            for (Contact c : contactList) {
                System.out.println(c);
            }
            System.out.println();
        }
    }

    public static void searchContact() {
        System.out.print("Enter name to search: ");
        String searchName = sc.nextLine();
        boolean found = false;

        for (Contact c : contactList) {
            if (c.name.equalsIgnoreCase(searchName)) {
                System.out.println("Contact Found: " + c);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Contact not found.\n");
        }
    }

    public static void deleteContact() {
        System.out.print("Enter name to delete: ");
        String deleteName = sc.nextLine();
        boolean removed = contactList.removeIf(c -> c.name.equalsIgnoreCase(deleteName));

        if (removed) {
            System.out.println("Contact deleted successfully!\n");
        } else {
            System.out.println("Contact not found.\n");
        }
    }

    public static void updateContact() {
        System.out.print("Enter name to update: ");
        String nameToUpdate = sc.nextLine();
        boolean found = false;

        for (Contact c : contactList) {
            if (c.name.equalsIgnoreCase(nameToUpdate)) {
                System.out.print("Enter new phone: ");
                c.phone = sc.nextLine();
                System.out.print("Enter new email: ");
                c.email = sc.nextLine();
                System.out.println("Contact updated successfully!\n");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Contact not found.\n");
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("==== Contact Management System ====");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: addContact(); break;
                case 2: displayContacts(); break;
                case 3: searchContact(); break;
                case 4: updateContact(); break;
                case 5: deleteContact(); break;
                case 6: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice.\n");
            }
        } while (choice != 6);
    }
}
