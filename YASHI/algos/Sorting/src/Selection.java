public class Selection {
    public static void main(String[] args) {
        int[] arr= new int[] {3,2,1,45,1,2,2,32,321,32,4};
        int[] ans = shell.sort(arr);
        for(var an : ans )
        {
            System.out.println(an);
        }
    }
    private static int[] sort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            int min = i;
            for(int j=i;j < n ;j++)
            {
               if(arr[j] < arr[min])
               min = j;                
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
