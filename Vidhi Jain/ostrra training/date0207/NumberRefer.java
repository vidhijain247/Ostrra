package date0207;
import java.util.*;
import java.util.stream.Collectors;


public class NumberRefer {
    public static void main(String[] args) {
        List<Integer> nums =  Arrays.asList(1,2,3,4);
        List<Number> n = new ArrayList<>();
        n=nums.stream().map(Number::new).collect(Collectors.toList());
        n.forEach(System.out::println);
}
}