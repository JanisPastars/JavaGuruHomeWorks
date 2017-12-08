package Gravytrips;

public class TheGame {
    //set field as 2d Array
    private String[][] field;

    //constructor with setups
    public TheGame(int x, int y) {
        field = new String[x][y];
    }

    //do checks and draw player value at the field
    public void setMoveValue(int x, String pl) {
        if (x > (field[field.length - 1].length - 1) || x < 1) {
            System.out.println("Move value can't be bigger than " + (field[field.length - 1].length - 1) + " and less than 1! You lost your turn!");
        } else {
            int yPos = 1;
            for (int i = 0; i < field.length; i++) {
                for (int k = 0; k < field[i].length; k++) {
                    if (yPos <= field.length) {
                        if (field[field.length - yPos][x] != null) {
                            //due to increase in loop overdose not allowing it to go further
                            yPos++;
                        }
                    } else {
                        break;
                    }
                }
            }

            if (!inBoundsY(field, field.length - yPos)) {
                System.out.println("\nSorry, but this column is already full, you lost your turn!\n");
            } else {
                field[field.length - yPos][x] = pl;
            }
        }
    }

    //draw field with all players and non players values
    public void drawField(String pl1Val, String pl2Val) {
        int x = 0;
        int y = 1;
        for (int i = 0; i < field.length; i++) {
            for (int k = 0; k < field[i].length; k++) {
                if (i == 0) {
                    System.out.print(" " + x++ + " ");
                } else if (k == 0) {
                    System.out.print(" " + y++ + " ");
                } else if (pl1Val.equals(field[i][k])) {
                    System.out.print(" " + pl1Val + " ");
                } else if (pl2Val.equals(field[i][k])) {
                    System.out.print(" " + pl2Val + " ");
                } else {
                    System.out.print(" . ");
                }

            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean checkGameStatusByX(String pl, int cond) {
        int x = 0;
        int movesByX = 1;
        for (int i = 0; i < field.length; i++) {
            for (int k = 0; k < field[i].length; k++) {
                if (pl.equals(field[i][k])) {
                    x = k;
                    if (inBoundsX(field, x + 1) && pl.equals(field[i][x + 1])) {
                        movesByX++;
                    }
                }
            }
        }

        if (movesByX == cond) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkGameStatusByY(String pl, int cond) {
        int y = 0;
        int movesByY = 1;
        for (int i = 0; i < field.length; i++) {
            for (int k = 0; k < field[i].length; k++) {
                if (pl.equals(field[i][k])) {
                    y = i;
                    if (inBoundsY(field, y - 1) && pl.equals(field[y - 1][k])) {
                        System.out.println("Position to count: " + y + " and " + (y - 1) + " at X: " + k);
                        movesByY++;
                        System.out.println("Moves: " + movesByY);
                    }

                }
            }
        }

        if (movesByY == cond) {
            System.out.println("Moves by Y: " + movesByY);
            return true;
        } else {
            return false;
        }
    }

    public boolean inBoundsX(String[][] ar, int indX) {
        if ((indX >= 0) && (indX <= ar[ar.length - 1].length - 1)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean inBoundsY(String[][] ar, int indY) {
        if ((indY > 0) && (indY <= ar.length)) {
            return true;
        } else {
            return false;
        }
    }
}
