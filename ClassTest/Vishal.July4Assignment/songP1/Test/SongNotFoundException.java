package Test;

class SongNotFoundException extends Exception {
    public SongNotFoundException(String message) {
        System.out.println(message);
    }
}
