package Gravytrips3;

public class Field{
    private String[][] field;
    
    public Field(int y, int x){
        this.field = new String[y][x];
    }
    
    public String[][] getField(){
        return this.field;
    }
    
    public void drawField(){
        int x = 0;
        int y = 1;
        separator();
        for(int i=0;i<field.length;i++){
            for(int k=0;k<field[i].length;k++){
                if(i == 0){
                    System.out.print(" "+ x +" ");
                    x = x+1;
                }
                else if(k == 0){
                    System.out.print(" "+ y +" ");
                    y = y+1;
                }
                else if((field[i][k]) == null){
                    System.out.print(" . ");
                }
                else{
                    System.out.print(" "+field[i][k]+" ");
                }
                
            }
            separator();
        }
        separator();
    }
    
    public void separator(){
        System.out.println();
    }
    
    public boolean placeMove(int x, String v){
        int y = 1;
        for(int i=0;i<field.length;i++){
            for(int k=0;k<field[i].length;k++){
                if(y<=field.length-1){
                    if(field[field.length-y][x] != null){
                        y++;
                    }   
                }
                else{
                    System.out.println("This collumn is full, try another one!");
                    return false;
                }
            }
        }
        
        this.field[this.field.length-y][x] = v;
        return true;
    }
    
    public boolean notAllMoves(){
        for(int i=0;i<field.length;i++){
            for(int k=0;k<field[i].length;k++){
                if(i!=0 && k!=0 && field[i][k] == null){
                    return true;
                }
            }
        }
        System.out.println("Board is full! Game is over!");
        return false;
    }
}
