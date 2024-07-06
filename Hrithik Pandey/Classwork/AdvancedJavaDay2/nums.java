public class nums {
    int i;
    nums(int i){
        this.i=i;
    }
  
    synchronized void inc(){
        for(int x=0;x<100;x++)
        {
            i++;
        }
    }
    
    @Override
    public String toString() {
        return "nums [i=" + i + "]";
    }
    
}
