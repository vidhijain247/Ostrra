public class SongNotFoundException  extends Exception{
    @Override
    public String getMessage() {
        return "EXCEPTION: SONG NOT FOUND";
    }

}
