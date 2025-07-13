public class KeepStrategy implements PlayerStrategy {
    @Override
    public int selectSecondTime(int firstSelection, Door[] doors) {
        return firstSelection;
    }
}
