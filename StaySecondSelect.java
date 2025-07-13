public class StaySecondSelect implements SecondSelectStrategy {
    @Override
    public int secondSelect(int firstSelection, Door[] doors) {
        return firstSelection;
    }
}
