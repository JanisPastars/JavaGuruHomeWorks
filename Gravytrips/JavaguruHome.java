package Gravytrips;
import java.util.Scanner;

public class JavaguruHome {
    //game setups for players
    private static int plaAttWin = 3;
    private static int fieldXnum = 8;
    private static int fieldYnum = 6;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);        
        //create field
        TheGame f = new TheGame(fieldYnum,fieldXnum);
        //set player 1
        Player pl1 = new Player("Player 1", "x");
        //set player 2
        Player pl2 = new Player("Player 2", "o");
        //draw field with players values
        f.drawField(pl1.getPlVal(),pl2.getPlVal());
        //game vars setup
        boolean gameOn = true;
        int xValue;
        
        //run game till one of the players win
        while(gameOn){
            //get player move
            System.out.println("\n"+pl1.getName()+" choose where to place your move: ");
            //check if a number
            if(!in.hasNextInt()){
                System.out.println("Only numbers are alowed! You lost your move!");
                in.next();
            }
            else{
                xValue = in.nextInt();
                //set player move
                f.setMoveValue(xValue, pl1.getPlVal());
                //clear output
                System.out.println();
                //re-draw field with move
                f.drawField(pl1.getPlVal(),pl2.getPlVal());
                //check game status by Y
                if(f.checkGameStatusByY(pl1.getPlVal(),plaAttWin) || f.checkGameStatusByX(pl1.getPlVal(),plaAttWin)){
                    System.out.println(pl1.getName() + " win!");
                    break;
                }
            }
            
            
            //get player move
            System.out.println("\n"+pl2.getName()+" choose where to place your move: ");
            //check if number
            if(!in.hasNextInt()){
                System.out.println("Only numbers are alowed! You lost your move!");
                in.next();
            }
            else{
                xValue = in.nextInt();
                //set player move
                f.setMoveValue(xValue, pl2.getPlVal());
                //clear output
                System.out.println();
                //re-draw field with move
                f.drawField(pl1.getPlVal(),pl2.getPlVal());
                //check game status by Y
                if(f.checkGameStatusByY(pl2.getPlVal(),plaAttWin) || f.checkGameStatusByX(pl2.getPlVal(),plaAttWin)){
                    System.out.println(pl2.getName() + " win!");
                    break;
                }
            }
        }
    }
}