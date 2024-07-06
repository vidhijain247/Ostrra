import java.security.spec.MGF1ParameterSpec;
import java.util.*;
public class main {
    public static void main(String[] args) {
        List<oldAge> boomers= new ArrayList<oldAge>();
        boomers.add(new oldAge("vikram",20));
        boomers.add(new oldAge("hrithik",20));
        boomers.add(new oldAge("abc",53));
        boomers.add(new oldAge("sfa",12));
        boomers.add(new oldAge("sdcaw",90));
        Collections.sort(boomers,(o1,o2)->o1.name.compareTo(o2.name));
       boomers.forEach(boomer->System.out.println(boomer));
            Map dir= new HashMap();
            dir.put("student1", 90 );
            dir.put("student2", 92 );
            dir.put("student3", 91 );
            dir.put("student4", 95 );
            dir.put("student5", 94 );
            
    }   
}
