class PlayerNumber {
    int number = 0;

    public void guess() {
        number = (int) (Math.random() * 100);
        System.out.println("I think this number is - " + number);
    }
}

class GameLauncher {
    public static void main(String[] args) {
        GuessNumber game = new GuessNumber();
        game.startGame();
    }
}

