package User;

import java.util.LinkedList;

public class ContactInfo {
    String email;
    String telNumber;
    LinkedList<Address> addressList;

    public ContactInfo  (String telNumber,String email,String... addresses) {
        this.addressList=new LinkedList<>(  );
        this.email = email;
        this.telNumber = telNumber;
        getAddresses( addresses );
        
    }
    private LinkedList getAddresses(String[] adresses){
        if(adresses.length%6!=0){
            try{
                throw new IllegalArgumentException(  );
            }catch (IllegalArgumentException e){
                e.getMessage();
                return null;
            }
        }else {
            for (int i =0; i < adresses.length; i = i + 6) {
                String title = adresses[i];
                String country = adresses[i+1];
                String city = adresses[i+2];
                String district = adresses[i+3];
                String street = adresses[i+4];
                String doornumber = adresses[i+5];
                Address address = new Address( title,country,city,district,street,doornumber );
                addressList.add( address );
            }
            return addressList;
        }
    }

    public LinkedList<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(LinkedList<Address> addressList) {
        this.addressList = addressList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
}
