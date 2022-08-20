package Exceptions;

public class insufficientChangeException extends RuntimeException { 
    private String message; 
    
    public insufficientChangeException (String message) {
         this.message = message;  
    } 

    @Override 
     public String getMessage(){ 
        return message; 
    } 
}