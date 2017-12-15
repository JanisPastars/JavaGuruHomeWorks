package Gravytrips3;

import java.util.Scanner;

public class Player{
    private String value;
    private String name;
    
    public Player(String n, String v){
        this.value = v;
        this.name = n;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getValue(){
        return this.value;
    }
    
    public boolean checkInput(int x, String[][] ar){
        if(x<=ar[ar.length-1].length-1 && x>0){
            return true;
        }
        else{
            System.out.println("Move must be between 1 and " + (ar[ar.length-1].length-1));
            return false;
        }
    }
    
    public int move(String[][] f){
        System.out.println(this.getName()+" move: ");
        int move = input();
        if(move != -1){
            if(this.checkInput(move, f)){
                return move;
            }
        }
        return -1;
    }
    
    
    public int input(){
        Scanner in = new Scanner(System.in);
        try{
            return in.nextInt();
        }
        catch(Exception e){
            System.out.println("Only integers are allowed");
            return -1;
        }
    }
}