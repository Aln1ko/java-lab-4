
public class QueuePerson {
    private String name;
    private String surname;
    private String middleName;
    private int priority;
    private AddressValue adress;

    QueuePerson()
    {
        name = "name1";
        surname = "surname1";
        middleName = "middleName1";
        priority = 1;
        adress = new AddressValue();
    }
    QueuePerson(String name,String surname,String middleName,int priority,AddressValue adress){
        this.adress = adress;
        this.middleName = middleName;
        this.name = name;
        this.priority = priority;
        this.surname = surname;
    }

    public int compareTo(QueuePerson other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Priority: " + priority + ", Name: " + name + " " + surname + " " + middleName + ", " + adress;
    }
    public AddressValue getAdress() {
        return adress;
    }

    public void setAdress(AddressValue adress) {
        this.adress = adress;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
