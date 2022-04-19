package main.java.exercise;

public class DataMissingException extends RuntimeException {
    public DataMissingException(){
        super("DataMissingException, you not provided correct data");
    }
}
