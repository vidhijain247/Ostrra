public class ExceptionHandling {
    public static void bookTickets() throws CustomException{
        System.out.println("Ticket booked");
    }
    public static void main(String[] args) {
        try {
            boolean weekday=false;
            if(weekday) throw new CustomException();
            bookTickets();
        } 
        catch (CustomException e) {
           System.out.println(e);
        }
        finally{
                
        }
    }
}
