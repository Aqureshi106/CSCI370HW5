public class PeekingPlayer extends Player {
    public PeekingPlayer(GameshowHost host) {
        super(host, new RandomFirstSelect(), new seeSecondSelect());
    }
}
