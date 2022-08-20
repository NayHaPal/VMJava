package Exceptions;

public class InvalidCashException extends RuntimeException { 
    private String message; 
    
    public InvalidCashException(String message) {
         this.message = message;  
    } 

    @Override 
     public String getMessage(){ 
        return message; 
    } 
}