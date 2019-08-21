package phoneBook;

import javax.annotation.Nonnull;

public class Email implements ContactData {
    private String email;
    private EmailType type;

    public Email(@Nonnull String email) {
        this.email = email;
        type = EmailType.OTHER;
    }

    public Email(@Nonnull String email, @Nonnull EmailType type) {
        this(email);
        this.type = type;
    }

    public void setEmail(@Nonnull String email) {
        this.email = email;
    }

    public void setType(@Nonnull EmailType type) {
        this.type = type;
    }

    public String getContactDataInfo() {
        return "Email: " +
                "email='" + email + '\'' +
                ", type=" + type + "\n";
    }
}
