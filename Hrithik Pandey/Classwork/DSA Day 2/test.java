public class test {
    public static void main(String[] args) {
        int[] ans =HalfMergeSort.merge(new int[]{2,3,23,2,4,2,4}, new int[]{12,32,4,2,1,0,5});
        for(var i : ans)
        {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
