public class KeepingPlayer extends Player {
    public KeepingPlayer(GameshowHost host) {
        super(host, new RandomFirstSelect(), new StaySecondSelect());
    }
}
