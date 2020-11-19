package User;

public abstract class RegularUser extends User {
    private ContactInfo contactInfo;
    public RegularUser(String username,String password,double balance,String telNumber,String email,String... adresses) {
        super(username,password,balance);
        this.contactInfo = new ContactInfo( telNumber, email, adresses );
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
}
