import java.util.Scanner;

class Pattern{
   public static void main(String[] args) {
       try (Scanner s = new Scanner(System.in)) {
           String num1= s.nextLine();
           char num2= num1.charAt(0);
           int num=num2;
           for (int i = 65; i <=num; i++) {
               for (int j = i; j >=65; j--) {
                   System.out.print((char)j);
               }
               System.out.println();
           }  }
        }
}
   
