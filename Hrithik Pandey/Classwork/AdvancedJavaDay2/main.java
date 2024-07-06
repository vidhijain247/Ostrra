import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.Thread.State;
import java.time.format.TextStyle;

class main{
    public static void main(String[] args) {
        // DemoInterface d= MethodReferences::print;
        // MethodReferences mr= new MethodReferences();
        // DemoInterface d1= mr::objPrint;
        // DemoInterface d2= MethodReferences::new;
        // d.display();
        // d1.display();
        // d2.display();
        // List<Integer> nums = Arrays.asList(1,2,3,4,5);
        // List<nums> n= new ArrayList<nums>();

        // n=nums.stream().map(nums::new).toList();
        
        // n.forEach(System.out::println);
        // nums n= new nums(0);
        // Runnable r = new Runnable() {
        //     public void run() {
        //         n.inc();
        //     }
        // };
        // Thread t1= new Thread(r);
        // Thread t2= new Thread(r);
        // t1.start();
        // t2.start();
        // try {
        //     t1.join();
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        // try {
        //     t2.join();
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        //System.out.println(n.i);
        File f= new File("Test.txt");
        FileOutputStream fin;
        DataOutputStream ds;
        byte[] b= new byte[]{65,66,68,79};
        try {
            fin = new FileOutputStream(f);
            ds= new DataOutputStream(fin);
            ds.writeUTF("sdsdsdsdsd");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        FileInputStream filein;
        try {
            filein = new FileInputStream(f);
            DataInputStream din = new DataInputStream(filein);
            System.out.println(din.readUTF());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}