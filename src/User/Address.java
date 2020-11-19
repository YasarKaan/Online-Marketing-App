package User;

public class Address {
    private String title;
    private String country;
    private String city;
    private String district;
    private String street;
    private String doorNumber;

    public Address(String title, String country,String city,String district,  String street, String doorNumber) {
        this.title = title;
        this.country = country;
        this.district= district;
        this.city = city;
        this.street = street;
        this.doorNumber = doorNumber;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }
}
