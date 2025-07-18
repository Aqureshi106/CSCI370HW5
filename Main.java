import java.util.Random;

class RandomFirstSelect implements FirstSelectStrategy {
    private final Random rand = new Random();
    @Override
    public int firstSelect(Door[] doors) {
        return rand.nextInt(doors.length);
    }
}

enum Prize {
    GOAT, CAR, UNKNOWN
}

class Door {
    private boolean open;
    private Prize prize;

    public Door(Prize prize) {
        this.prize = prize;
    }

    public void open() {
        this.open = true;
    }

    public void close() {
        this.open = false;
    }

    public boolean isOpen() {
        return open;
    }

    public Prize look() {
        if (!open)
            return Prize.UNKNOWN;
        else
            return prize;
    }

    public Prize peek() {
        return prize;
    }
}

class GameshowHost {
    private final Door [] doors;

    public GameshowHost() {
        Random rand = new Random();
        doors = new Door[] { new Door(Prize.GOAT), new Door(Prize.GOAT), new Door(Prize.GOAT)};
        doors[rand.nextInt(doors.length)] = new Door(Prize.CAR);
    }

    public Door [] getDoors() {
        return doors;
    }

    public void hearFirstSelection(int selection) {
        // respond by looping through doors, opening
        // the one which is NOT the selection but which contains a Goat
        for (int i = 0; i < doors.length; i++) {
            if (i != selection && doors[i].peek() == Prize.GOAT) {
                doors[i].open();
                return;
            }
        }
    }

    public void hearSecondSelection(int selection) {
        // just open that door
        doors[selection].open();
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int numWins = 0;
        final int NUM_TRIALS = 1000;
        for (int i = 0; i < NUM_TRIALS; i++) {
            GameshowHost montyHall = new GameshowHost();
            Player player = new KeepingPlayer(montyHall);
            boolean won = player.play();
            if (won)
                numWins++;
        }
        System.out.println("KeepingPlayer: " + (numWins / 1000.0));

        numWins = 0;
        for (int i = 0; i < NUM_TRIALS; i++) {
            GameshowHost montyHall = new GameshowHost();
            Player player = new SwitchingPlayer(montyHall);
            boolean won = player.play();
            if (won)
                numWins++;
        }
        System.out.println("SwitchingPlayer: " + (numWins / 1000.0));

        numWins = 0;
        for (int i = 0; i < NUM_TRIALS; i++) {
            GameshowHost montyHall = new GameshowHost();
            Player player = new PeekingPlayer(montyHall);
            boolean won = player.play();
            if (won)
                numWins++;
        }
        System.out.println("PeekingPlayer: " + (numWins / 1000.0));
    }
}
