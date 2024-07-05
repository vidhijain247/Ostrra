package edu.osttra.training.SongManagement;

public class SongNotFound extends Exception{
    @Override
    public String getMessage() {
        return "Song Not Found!";
    }
}
