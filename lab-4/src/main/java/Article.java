
public class Article {
    private String name;
    private double price;

    Article(String name,double price){
        this.name = name;
        this.price = price;
    }
    Article()
    {
        name = "name1";
        price = 5.00;
    }
    public String toString() {
        return  "Name: " + name + " price: " + String.format("%.2f", price);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
