package phoneBook;

import javax.annotation.Nonnull;

public class Phone implements ContactData {
    private String phoneNumber;
    private PhoneType type;

    public Phone(@Nonnull String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.type = PhoneType.MOBILE;
    }

    public Phone(@Nonnull String phoneNumber, @Nonnull PhoneType type) {
        this(phoneNumber);
        this.type = type;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public String getContactDataInfo() {
        return "phoneNumber='" + phoneNumber + '\'' + ", type=" + type + "\n";
    }
}
