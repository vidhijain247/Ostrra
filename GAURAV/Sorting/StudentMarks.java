import java.util.Scanner;

public class StudentMarks {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] marks = new int[10];

       
        System.out.println("Enter marks for 10 students:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }

        
        bubbleSort(marks);

      
        System.out.println("Marks after sorting:");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
    }

  
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }
}
