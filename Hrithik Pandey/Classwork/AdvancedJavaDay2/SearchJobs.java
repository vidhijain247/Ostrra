import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class SearchJobs {
    public static void main(String[] args) {
        List<String> jobs = new ArrayList<>();
            jobs.add("aws");
            jobs.add("java senior");
            jobs.add("java junior");
            jobs.add("java lead");
            jobs.add("python");
            jobs.add("coud");
            jobs.add("sales");
            jobs.add("buy");
            jobs.add("sell");
            jobs.add("get");
            jobs.add("send");

        List<String> loc = new ArrayList<>();
            loc.add("mum");
            loc.add("del");
            loc.add("hyd");
            loc.add("bng");
            loc.add("chn");
        List<String> comp = new ArrayList<>();
            comp.add("c1");
            comp.add("c2");
            comp.add("c3");
            comp.add("c4");  
        List<Jobpost> jp= new ArrayList<>();
        for(int i=0;i<100;i++)
        {
            Random r= new Random();
            int ji= r.nextInt(jobs.size());
            int loci= r.nextInt(loc.size());
            int ci= r.nextInt(comp.size());
            jp.add(new Jobpost(jobs.get(ji),loc.get(loci), i,comp.get(ci)));
        }
        Stream<Jobpost> s1 = jp.stream().filter(n -> n.getName().contains("java") && n.getLoc().equals("del"));
        List<SearchOutput> s2= s1.map(SearchOutput::createObj).toList();
        s2.forEach(n->System.out.println(n.toString()));
    }
}
 