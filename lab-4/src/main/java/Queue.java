import java.util.LinkedList;
import java.util.TreeSet;

public class Queue {
    private LinkedList<QueuePerson> queue;
    private TreeSet<String> tree ;

    Queue(){
        queue = new LinkedList<>();
        tree = new TreeSet<>();
    }
    public void add(QueuePerson person){
        if (!tree.contains(person.getName() + person.getSurname() + person.getMiddleName())) {
            tree.add(person.getName() + person.getSurname() + person.getMiddleName());
            int index = get_index(person.getPriority());
            queue.add(index,person);
        }
    }

    public LinkedList<QueuePerson> getQueue() {
        return queue;
    }

    public void print(){
        for (QueuePerson person:queue){
            System.out.println(person);
        }
    }

    public  int get_index(int randomNumber){
        int index = 0;
        int priority;
        for(int i = 0; i < queue.size(); i++){
            index = i;
            priority = queue.get(i).getPriority();
            if(priority > randomNumber){ break;}
            if( i == queue.size() - 1 ) index = queue.size();
        }
        return index;
    }
}
