package Components;

public class Display {
    String componentName = "Display";
    public Display(){

    }
    
    public void showMessage(String msg){
        System.out.println("[" + componentName + "]: " + msg);
    }
}
