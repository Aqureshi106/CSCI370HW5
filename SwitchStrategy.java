public class SwitchStrategy implements PlayerStrategy {
    @Override
    public int selectSecondTime(int firstSelection, Door[] doors) {
        for (int i = 0; i < doors.length; i++) {
            if (i != firstSelection && doors[i].look() == Prize.UNKNOWN) {
                return i;
            }
        }
        return firstSelection;
    }
}
