package Exceptions;

public class insufficientFundsException extends RuntimeException { 
    private String message; 
    
    public insufficientFundsException (String message) {
         this.message = message;  
    } 

    @Override 
     public String getMessage(){ 
        return message; 
    } 
}