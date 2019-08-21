package phoneBook;

import javax.annotation.Nonnull;
import java.io.Serializable;
import java.util.ArrayList;

public class Contact implements Serializable {
    private String name;
    private ArrayList<ContactData> data;

    public Contact(@Nonnull String name) {
        this.name = name;
        this.data = new ArrayList<ContactData>();
    }

    public Contact(@Nonnull String name, @Nonnull ArrayList<ContactData> contactData) {
        this(name);
        for (int i = 0; i < contactData.size(); i++) {
            data.add(contactData.get(i));
        }
    }

    public String getName() { return name; }

    public void addContactData(ContactData contactData) {
        this.data.add(contactData);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Contact: " + name + " ");
        for (ContactData contactData : data) {
            builder.append(contactData.getContactDataInfo() + " ");
        }
        return builder.toString();
    }
}
