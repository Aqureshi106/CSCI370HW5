import java.util.Random;

public class Player {
    private int selection;
    private final GameshowHost host;
    private final FirstSelectStrategy firstStrategy;
    private final SecondSelectStrategy secondStrategy;

    public Player(GameshowHost host, FirstSelectStrategy first, SecondSelectStrategy second) {
        this.firstStrategy = first;
        this.secondStrategy = second;
        this.host = host;
    }

    public void selectFirstTime() {
        // random number between 0 and 2 inclusive
        Random rand = new Random();
        selection = rand.nextInt(3);
    }

    public boolean play() {
        Door[] doors = host.getDoors();
        selection = firstStrategy.firstSelect(doors);
        host.hearFirstSelection(selection);
        selection = secondStrategy.secondSelect(selection, doors);
        host.hearSecondSelection(selection);
        return doors[selection].look() == Prize.CAR;
    }
}
