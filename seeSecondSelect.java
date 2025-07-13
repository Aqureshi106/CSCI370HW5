public class seeSecondSelect implements SecondSelectStrategy {
    @Override
    public int secondSelect(int firstSelection, Door[] doors) {
        for (int i = 0; i < doors.length; i++) {
            if (doors[i].peek() == Prize.CAR)
                return i;
        }
            return firstSelection;
    }
}
