public class SwitchingPlayer extends Player {
    public SwitchingPlayer(GameshowHost host) {
        super(host, new RandomFirstSelect(), new SwapSecondSelection());
    }
}
