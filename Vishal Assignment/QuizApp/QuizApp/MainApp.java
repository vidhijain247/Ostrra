package QuizApp;

import java.util.Random;
import java.util.Scanner;
import java.util.zip.CRC32;

public class MainApp {

    public static Boolean isValidOption(char choice){
        if(choice =='A' || choice == 'B'|| choice =='C'|| choice == 'D'|| choice=='Q'|| choice =='P'|| choice =='N' ){
            return true;
        }else{
            System.out.println("Enter Valid option please");
        }
        return false;
    }
public static void main(String[] args) {
    Question[] quesArr=new Question[5];
    quesArr[0]=new Question("MS-Word is an example of _____","A) An operating system\n" + //
                "B) A processing device\n" + //
                "C) Application software\n" + //
                "D) An input device", 'C');
    quesArr[1]=new Question("A computer cannot boot if it does not have the _____\n","A) Compiler\n" + //
                "B) Loader\n" + //
                "C) Operating system\n" + //
                "D) Assembler", 'C');
    quesArr[2]=new Question("Ctrl, Shift and Alt are called .......... keys.","A) modifier\n" + //
                "B) function\n" + //
                "C) alphanumeric\n" + //
                "D) adjustment", 'A');
    quesArr[3]=new Question("________ is the process of dividing the disk into tracks and sectors","A) Tracking\n" + //
                "B) Formatting\n" + //
                "C) Crashing\n" + //
                "D) Allotting\n" + //
                "", 'B');
    quesArr[4]=new Question("Junk e-mail is also called ______\n" + //
                "A) Spam\n" + //
                "B) Spoof\n" + //
                "C) Sniffer script\n" + //
                "D) Spool","", 'B');

    Scanner sc=new Scanner(System.in);
    
    char actAns[]=new char[5];
    for(int i=0;i<5;i++){
        actAns[i]=quesArr[i].answerOption;
    }
    UserAns userA=new UserAns(actAns);
    System.out.println("HELLO STARTING QUIZ---------------------/n");
   int qNo=0;
   Random ran=new Random();
   ran.nextInt(5);
    String userMsg="\n\n\n\nENTER YOUR CHOICE (A,B,C,D) or Q to submit and exit ->";
    char choice;
    do{
        System.out.println("curr ques no = "+(qNo+1));
        quesArr[qNo].printQues();
        System.out.println(userMsg);
        choice=sc.next().toUpperCase().charAt(0);
      
        if(isValidOption(choice) ) {
            
            if(choice=='P'){
                qNo--;
                if(qNo<0) {
                    System.out.println("INVALID");
                    qNo=0;
                }
                continue;
            }else if(choice == 'N'){
                qNo++;
                if(qNo>=5){
                    System.out.println("No More question please exit");
                }
                qNo=4;
                continue;
            }
            else {
              userA.userArr[qNo]=choice;
            
            }
        }
        
        // int nxtQ=ran.nextInt(4);
        // while(nxtQ==qNo) {nxtQ=ran.nextInt(4);
        // }
        qNo++;
        
        

    }while(choice != 'Q' && qNo<=4 );

    System.out.println("Your final score is "+ userA.getResult());
    
}
}
