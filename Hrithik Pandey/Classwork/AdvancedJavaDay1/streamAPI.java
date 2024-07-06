import java.util.stream.Stream;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class streamAPI {
    public static void main(String[] args) {            
            // List<Integer> names = new ArrayList<>();
            // // names.add("sds");
            // // names.add("sewsx");
            // // names.add("iuenccj");
            // for(int i=0;i<10000;i++)
            // {
            //    names.add(i); 
            // }
            // long normal= System.currentTimeMillis();
            // names.stream().map(n->{try {
            // } catch (Exception e) {
            // }
            //     return n*n; }).mapToInt(i->i).sum();
            // long normalend= System.currentTimeMillis();
            // System.out.println(normalend-normal);
            
            // long par= System.currentTimeMillis();
            // names.parallelStream().map(n->{try {
            // } catch (Exception e) {
            // }
            //     return n*n; }).mapToInt(i->i).sum();
            // long parend= System.currentTimeMillis();
            // System.out.println(parend-par);

            // String str= names.stream().findFirst().orElse("not found");
            // System.out.println(str);
            // // int result = nums.stream().filter(n->n%2==0)
            // .mapToInt(n->(int) n)
            // .reduce(0,(n1,n2)->n1+n2);
            // System.out.println(result);
            
    }
}
