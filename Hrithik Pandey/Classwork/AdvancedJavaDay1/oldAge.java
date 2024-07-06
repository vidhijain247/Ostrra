public class oldAge implements Comparable<oldAge> {
    String name;
    int age;
    public oldAge(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(oldAge o) {
        return this.name.compareTo(o.name) * -1;
        
    }
    @Override
    public String toString() {
        return "oldAge [name=" + name + ", age=" + age + "]";
    }
    
}
