package Exceptions;

public class ItemNotAvailableException extends RuntimeException { 
    private String message; 
    
    public ItemNotAvailableException (String message) {
         this.message = message;  
    } 

    @Override 
     public String getMessage(){ 
        return message; 
    } 
}