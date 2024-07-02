public class ThreadT1 implements Runnable {
    int n;
    ThreadT1(nums n){
        this.n = n.i;
    }
    @Override
    public void run() {
        for(int i=0;i<100;i++)
       {
            n++;
       }
    }
}
