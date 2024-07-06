public class HalfMergeSort {
    static int[] merge(int[] a, int[] b)
    {
        int[] ans= new int[13];
        int[] a1=insertion.sort(a);
        int[] a2=insertion.sort(b);
        int i=0;int j=0;int k=0;
        while(i<a1.length && j<a2.length)
        {
            if(a1[i] < a2[j])
            {
                ans[k++]=a1[i++];
            }
            else
            {
                ans[k++]=a2[j++];
            }
        }
        if(i<a1.length-1)
        {
            while(i!=a1.length-1)
            {
                ans[k++]=ans[i++];
            }
        }
        if(j<a2.length-1)
        {
            while(j!=a2.length-1)
            {
                ans[k++]=ans[j++];
            }
        }
        return ans;
    }
}
