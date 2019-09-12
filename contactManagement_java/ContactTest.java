package contactManagement_java;

import java.util.LinkedList;

public class ContactTest {
    public static void main(String[] args) {
        LinkedList<Contact> contacts = new LinkedList<>();

        contacts.add(new Contact("A", "1", "123456"));
        contacts.add(new Contact("B", "2", "234567"));
        contacts.add(new Contact("C", "3", "345678"));
        contacts.add(new Contact("D", "4", "456789"));
        contacts.add(new Contact("A", "5", "567891"));
        contacts.add(new Contact("F", "6", "678912"));
        contacts.add(new Contact("G", "7", "789123"));
        contacts.add(new Contact("H", "8", "891234"));
        contacts.add(new Contact("I", "9", "912345"));

        addNewContact(contacts, new Contact("John", "Smith", "492813740"));
        editContact(contacts, 12, new Contact("John", "Smith", "492813740"));
        removeContact(contacts, "1");
        findByInput(contacts, "A");
        viewContact(contacts);

    }

    private static void viewContact(LinkedList<Contact> contacts) {
        for (Contact contact : contacts) {
            System.out.println("Contact: " + contact.getFirstName() + " " + contact.getLastName() + " - Phone number: " + contact.getPhoneNumber());
        }
    }

    private static void addNewContact(LinkedList<Contact> contacts, Contact contact) {
        contacts.addLast(contact);
        System.out.println("Successfully adding new contact");
    }

    private static void editContact(LinkedList<Contact> contacts, int index, Contact contact) {
        try {
            contacts.add(index, contact);
            contacts.remove(index + 1);
            System.out.println("Successfully update the contact");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("There's no matched index");
        }
    }

    private static boolean removeContact(LinkedList<Contact> contacts, String phoneNumber) {
        for (int i = 0; i < contacts.size(); i++) {
            if (phoneNumber.equals(contacts.get(i).getPhoneNumber())) {
                contacts.remove(i);
                System.out.println("Successfully remove the contact: " + phoneNumber);
                return true;
            }
        }
        System.out.println("There's no matched phone number");
        return false;
    }

    private static void findByInput(LinkedList<Contact> contacts, String input) {
        boolean check = false;
        for (Contact contact : contacts) {
            if (input.equals(contact.getPhoneNumber())
                    || input.equals(contact.getFirstName())
                    || input.equals(contact.getLastName())) {
                System.out.println("Contact: " + contact.getFirstName() + " " + contact.getLastName() + " - Phone number: " + contact.getPhoneNumber());
                check = true;
            }
        }
        if (check != true) {
            System.out.println("There's no matched output");
        }
    }
}
