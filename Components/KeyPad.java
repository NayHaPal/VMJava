package Components;

public class KeyPad {
    String accumulatedString;
    public KeyPad(){
        this.accumulatedString = "";
    }
    
    public String keyPush(char c){
        return this.accumulatedString += c;
    }

    public String getInput(){
        String selection = accumulatedString; 
        accumulatedString = "";
        return selection;
    }
    
    public String pushReset(){
        return this.accumulatedString = "";
    }
    
}
