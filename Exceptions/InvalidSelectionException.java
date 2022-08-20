package Exceptions;

public class InvalidSelectionException extends RuntimeException { 
    private String message; 
    
    public InvalidSelectionException(String message) {
         this.message = message;  
    } 

    @Override 
     public String getMessage(){ 
        return message; 
    } 
}