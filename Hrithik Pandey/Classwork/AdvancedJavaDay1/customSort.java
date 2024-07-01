import java.util.Comparator;

class customSort implements Comparator<oldAge>{
    @Override
    public int compare(oldAge o1, oldAge o2) {
        if(o1.age>o2.age)
        {
            return -1;
        }
        else if(o1.age == o2.age){
            return o1.name.compareTo(o2.name);
        }
        return 1;
    }
}