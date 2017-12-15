package Gravytrips3;

import java.util.Scanner;

public class Game extends Field {
    private Player p1;
    private Player p2;
    private boolean gameOn = true;
    private boolean moved = false;
    private int m;
    public Game(int y, int x, String n, String v, String n1, String v1, int winCond){
        super(y,x);
        Player p1 = new Player(n,v);
        Player p2 = new Player(n1,v1);
        drawField();
        
        while(gameOn){
            if(notAllMoves()){
                while(!moved){
                    m = p1.move(getField());
                    if(m>0){
                        if(placeMove(m,p1.getValue())){
                            moved = true;
                        }
                    }
                }
                
                
                drawField();
                moved = false;
                if(!gameStatus(p1.getValue())){
                    System.out.println(p1.getName()+" win!");
                    break;
                }
            }
            else{
                break;
            }
            
            if(notAllMoves()){
                while(!moved){
                    m = p2.move(getField());
                    if(m>0){
                        if(placeMove(m,p2.getValue())){
                            moved = true;
                        }
                    }
                }

                drawField();
                moved = false;
                if(!gameStatus(p2.getValue())){
                    System.out.println(p2.getName()+" win!");
                    break;
                }
            }
            else{
                break;
            }
        }
    }
    
    private boolean gameStatus(String v){
        String [][] f = getField();
        for(int i = f.length-1 ; i > 0 ; i--){
            for(int k = f[i].length-1; k > 0; k--){
                if(v.equals(f[i][k]) && v.equals(f[i-1][k]) && v.equals(f[i-2][k]) && v.equals(f[i-3][k])){
                    return false;
                }
                else if(v.equals(f[i][k]) && v.equals(f[i][k+1]) && v.equals(f[i][k+2]) && v.equals(f[i][k+3])){
                    return false;
                }
                //check by diagonal
            }
        }
        return true;
    }
    
    
    
//    public boolean checkGameStatusByX(String pl,int cond){
//        int x = 0;
//        int movesByX = 1;
//        for(int i=0;i<field.length;i++){
//            for(int k=0;k<field[i].length;k++){
//                if(pl.equals(field[i][k])){
//                    x = k;
//                    if(inBoundsX(field,x+1) && pl.equals(field[i][x+1])){
//                        movesByX++;
//                    }
//                }
//            }
//        }
//        
//        if(movesByX==cond){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }
//    
//    public boolean checkGameStatusByY(String pl,int cond){
//        int y = 0;
//        int movesByY = 1;
//        for(int i=0;i<field.length;i++){
//            for(int k=0;k<field[i].length;k++){
//                if(pl.equals(field[i][k])){
//                    y = i;
//                    System.out.println("Moves by Y before ++ : " + movesByY);
//                    if(inBoundsY(field,y-1) && pl.equals(field[y-1][k])){
//                        movesByY++;
//                    }
//                    System.out.println("Moves by Y after ++: " + movesByY);
//                }
//            }
//        }
//        
//        if(movesByY>=cond){
//            System.out.println("Moves by Y true: " + movesByY);
//            return true;
//        }
//        else{
//            System.out.println("Moves by Y false: " + movesByY);
//            return false;
//        }
//    }
//    
//    public boolean inBoundsX(String[][] ar, int indX){
//        if((indX >= 0) && (indX <= ar[ar.length-1].length-1)){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }
//    
//    public boolean inBoundsY(String[][] ar, int indY){
//        if((indY > 0) && (indY <= ar.length)){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }
}
