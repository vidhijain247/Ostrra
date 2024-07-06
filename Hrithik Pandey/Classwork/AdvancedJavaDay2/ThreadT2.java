public class ThreadT2 extends Thread {
    int n;
    ThreadT2(nums n){
        this.n = n.i;
    }
    @Override
    public void run() {
        super.run();
        for(int i=0;i<100;i++)
        {
             n++;
        }
    }

}
