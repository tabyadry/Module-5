package phoneBook;

import javax.management.InstanceAlreadyExistsException;
import java.io.Serializable;
import java.util.ArrayList;

public class AddressBook implements Serializable {
    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public void add(Contact contact) throws InstanceAlreadyExistsException {
        if (find(contact.getName()) == null) {
            contacts.add(contact);
        } else
            throw new InstanceAlreadyExistsException(String.format("There is already a contact having the name %s", contact.getName()));
    }

    public boolean delete(String name) {
        boolean deleted = false;
        if (find(name) != null) {
            for (int i = 0; i < contacts.size(); i++) {
                if (contacts.get(i).getName().equals(name)) {
                    contacts.remove(i);
                    deleted = true;
                    break;
                }
            }
        }
        return deleted;
    }

    public Contact find(String name) {
        Contact contactFound = null;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                contactFound = contacts.get(i);
            }
        }
        return contactFound;
    }

    public ArrayList<Contact> getContacts() {
        return new ArrayList<Contact>(contacts);
    }
}
