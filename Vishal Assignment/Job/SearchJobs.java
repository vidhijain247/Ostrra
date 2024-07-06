import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class SearchJobs {
    public static void main(String[] args) {
        List<String> jobs = new ArrayList<>();
            jobs.add("aws");
            jobs.add("java");
            jobs.add("python");
            jobs.add("coud");

        List<String> loc = new ArrayList<>();
            loc.add("mum");
            loc.add("del");
            loc.add("hyd");
            loc.add("chn");
        List<Jobpost> jp= new ArrayList<>();
        for(int i=0;i<100;i++)
        {
            Random r= new Random();
            int ji= r.nextInt(jobs.size());
            int loci= r.nextInt(loc.size());
            jp.add(new Jobpost(jobs.get(ji),loc.get(loci), i));
        }
        Stream<Jobpost> s1 = jp.stream().filter(n -> n.getName().equals("java") && n.getLoc().equals("del"));
        s1.forEach(n->System.out.println(n.toString()));
    }
}