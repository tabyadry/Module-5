package phoneBook;

import javax.management.InstanceAlreadyExistsException;
import java.io.*;
import java.util.ArrayList;

public class Storage {

    public static boolean store(AddressBook addressBook) throws IOException {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream outputStream = new FileOutputStream("test.txt", false);
            oos = new ObjectOutputStream(outputStream);
            oos.writeObject(addressBook);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            if(oos !=null){
                oos.close();
            }
        }
    }

    public static AddressBook load() throws IOException {
        ObjectInputStream objectinputstream = null;
        try {
            FileInputStream streamIn = new FileInputStream("test.txt");
            objectinputstream = new ObjectInputStream(streamIn);
            AddressBook readCase = null;
            readCase = (AddressBook) objectinputstream.readObject();
            if (readCase != null) {
                return readCase;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (objectinputstream != null) {
                objectinputstream.close();
            }
        }
        return null;
    }

    public static void main(String[] args) throws InstanceAlreadyExistsException, IOException {
        AddressBook addressBook = new AddressBook();

        ArrayList<ContactData> contactData = new ArrayList<ContactData>();
        contactData.add(new Phone("0774845251",PhoneType.MOBILE));
        contactData.add(new Email("ion@yahoo.com", EmailType.HOME));
        addressBook.add(new Contact("Alina",contactData));

        ArrayList<ContactData> contactData2 = new ArrayList<ContactData>();
        contactData2.add(new Phone("0244100200",PhoneType.HOME));
        contactData2.add(new Email("ioana@yahoo.com", EmailType.OTHER));
        addressBook.add(new Contact("Anca",contactData2));

        //here I'm using store with serialization is java
        store(addressBook);

        //here I'm using load from a serialized file in Java
        AddressBook addressBook2 = null;
        addressBook2 = load();
        System.out.println(addressBook2.getContacts());

        addressBook2.delete("Alina");
        System.out.println(addressBook2.getContacts());
    }
}
