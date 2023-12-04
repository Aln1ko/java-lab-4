
public class AddressValue {
    private String city;
    private String street;
    private String houseNumber;
    private int apartmentNumber;

    {
        city = "city1";
        street = "street1";
        houseNumber = "1";
        apartmentNumber = 1;
    }
    AddressValue(){}

    AddressValue(String city,String street,String houseNumber,int apartmentNumber){
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
    }
    public String toString() {
        return "Address: " + houseNumber + " " + street + ", " + city + ", Apt. " + apartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
