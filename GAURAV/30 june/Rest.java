import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Rest {
    public static void main(String[] args) {
        List<String> jobs = new ArrayList<>();
        jobs.add("aws");
        jobs.add("java");
        jobs.add("python");
        jobs.add("coud");
        jobs.add("sales");
        jobs.add("buy");
        jobs.add("sell");
        jobs.add("get");
        jobs.add("send");
        class Job {
            String name;
            String loc;
            int id;
            public Job(String name, String loc, int id, String s) {
                this.name = name;
                this.loc = loc;
                this.id = id;
            }
            public String getName() {
                return name;
            }
            public void setName(String name) {
                this.name = name;
            }
            public String getLoc() {
                return loc;
            }
            public void setLoc(String loc) {
                this.loc = loc;
            }
            public int getId() {
                return id;
            }
            public void setId(int id) {
                this.id = id;
            }

            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Job{");
                sb.append("name=").append(name);
                sb.append(", loc=").append(loc);
                sb.append(", id=").append(id);
                sb.append('}');
                return sb.toString();
            }

        }
        List<String> loc = new ArrayList<>();
        loc.add("mum");
        loc.add("del");
        loc.add("hyd");
        loc.add("bng");
        loc.add("chn");
        List<String> companies = new ArrayList<>();
        companies.add("Google");
        companies.add("Amazon");
        companies.add("Microsoft");
        companies.add("Facebook");
        companies.add("Apple");

        List<Job> jp = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            int ji = r.nextInt(jobs.size());
            int loci = r.nextInt(loc.size());
            int ci = r.nextInt(companies.size());
            jp.add(new Job(jobs.get(ji), loc.get(loci), i, companies.get(ci)));
        }

        Stream<Job> s1 = jp.stream().filter(n -> n.getName().equals("java") && n.getLoc().equals("del"));
        s1.forEach(n -> System.out.println(n.toString()));
    }
}