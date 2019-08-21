package phoneBook;

import javax.annotation.Nonnull;

public class Address implements ContactData {
    private String streetName;
    private Integer number;
    private String city;
    private Integer postalCode;

    public Address(@Nonnull String streetName, @Nonnull Integer number, @Nonnull String city, @Nonnull Integer postalCode) {
        this.streetName = streetName;
        this.number = number;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getContactDataInfo() {
        return "Address:" +
                "streetName='" + streetName + '\'' +
                ", number=" + number +
                ", city='" + city + '\'' +
                ", postalCode=" + postalCode + "\n";    }
}
