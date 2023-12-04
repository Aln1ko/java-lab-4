import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Shop {
    HashMap<Integer, Article> map;
    TreeSet<String> tree;

    Shop() {
        this.map = new HashMap<>();
        this.tree = new TreeSet<>();
    }

    public void add(int number,String name,double price){
        if(!tree.contains(name)){
            tree.add(name);
            map.put(number,new Article(name,price));
        }
        else{
            System.out.print("Article with name " + name +" already exists");
        }
    }
    public void print(){
        for(Map.Entry<Integer,Article> entry: map.entrySet()){
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
