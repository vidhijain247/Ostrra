package date0207;

class T1 implements Runnable {
    @Override
    public void run(){
        for(int i = 0; i<100; i++){
            System.out.println("hi");
        }

    }
}

class T2 extends Thread {
    @Override
    public void run(){
        for(int i = 0; i<100; i++){
            System.out.println("hello");
        }

    }
}

public class Multithread {
    public static void main(String[] args) {
        
        Thread t1 = new Thread(new T1());
        T2 t2 = new T2();
        t2.start();
        t1.start();
    }
}
