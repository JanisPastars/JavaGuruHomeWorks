package Gravytrips;

public class Player {
    private String name;
    private String plValue;
    
    public Player(String n, String pv){
        this.name = n;
        this.plValue = pv;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getPlVal(){
        return this.plValue;
    }
}
