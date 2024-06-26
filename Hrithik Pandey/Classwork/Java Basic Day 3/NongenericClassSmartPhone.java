public class NongenericClassSmartPhone extends genericClassPhone {
    @Override
    void makeCall(){
        System.out.print("calling");
    }
    @Override
    void sendSMS(){
        System.out.print("calling");
    }
    @Override
    void PlayMusic(){
        System.out.println("playing from child");
        super.PlayMusic();
    }
}
class Main{
    public static void main(String[] args) {
        genericClassPhone smartphone= new NongenericClassSmartPhone();
        smartphone.PlayMusic();
        genericClassPhone p= new genericClassPhone() {
            void makeCall(){
                System.out.println("nmaking call");
            }
            void sendSMS(){
                System.out.println("sending from anonymus");
            }
        };
        p.sendSMS();
    }
}
