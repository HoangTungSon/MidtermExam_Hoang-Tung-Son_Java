package contactManagement_java;

import java.util.LinkedList;

public class ContactTest {
    public static void main(String[] args) {
        LinkedList<Contact> contacts = new LinkedList<>();

        contacts.add(new Contact("A", "1", "123456"));
        contacts.add(new Contact("B", "2", "234567"));
        contacts.add(new Contact("C", "3", "345678"));
        contacts.add(new Contact("D", "4", "456789"));
        contacts.add(new Contact("E", "5", "567891"));
        contacts.add(new Contact("F", "6", "678912"));
        contacts.add(new Contact("G", "7", "789123"));
        contacts.add(new Contact("H", "8", "891234"));
        contacts.add(new Contact("I", "9", "912345"));

        addNewContact(contacts, new Contact("John", "Smith", "492813740"));
        editContact(contacts, 12, new Contact("John", "Smith", "492813740"));
        removeContact(contacts, "123123213");
        viewContact(contacts);

    }

    private static void viewContact(LinkedList<Contact> contacts) {
        for (Contact contact : contacts) {
            System.out.println("Contact: " + contact.getFirstName() + " " + contact.getLastName() + " - Phone number: " + contact.getPhoneNumber());
        }
    }

    private static void addNewContact(LinkedList<Contact> contacts, Contact contact) {
        contacts.addLast(contact);
    }

    private static void editContact(LinkedList<Contact> contacts, int index, Contact contact) {
        try {
            contacts.add(index, contact);
            contacts.remove(index + 1);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("There's no matched index");
        }
    }

    private static boolean removeContact(LinkedList<Contact> contacts, String phoneNumber) {
        for (int i = 0; i < contacts.size(); i++) {
            if (phoneNumber.equals(contacts.get(i).getPhoneNumber())) {
                contacts.remove(i);
                return true;
            }
        }
        System.out.println("There's no matched phone number");
        return false;
    }

    private static boolean findByInput(LinkedList<Contact> contacts, String input) {
        for (int i = 0; i < contacts.size(); i++) {
            if (input.equals(contacts.get(i).getPhoneNumber())
                    || input.equals(contacts.get(i).getFirstName())
                    || input.equals(contacts.get(i).getLastName())) {
                contacts.remove(i);
                return true;
            }

        }
        System.out.println("There's no matched output");
        return false;
    }
}
