public class Reverse extends Cards implements IReverse{
    public Reverse(int color) {
        super(color, 10);
    }

    @Override
    public void cardAction(Cycler cycler) {
        // to be implemented
        cycler.toggleDirection();
        super.cardAction(cycler);
    }
}
