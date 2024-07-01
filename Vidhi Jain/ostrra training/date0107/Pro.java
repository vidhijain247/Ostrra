package date0107;

import java.util.*;

public class Pro {


    public static void main(String[] args) {
        List<String> Cource = new ArrayList<String>();

        Cource.add("CSE");
        Cource.add("IT");
        Cource.add("ITE");
        Cource.add("CST");
        Cource.add("AI");

        String str = Cource.stream().filter(c->c.contains("I")).findFirst().orElse("Not Found");
        String str2 = Cource.stream().filter(c->c.contains("z")).findFirst().orElseThrow();
        
        System.out.println(str);
        System.out.println(str2);

    }
}
