public class Skip extends Cards implements ISkip{
    public Skip(int color) {
        super(color, 10);
    }

    @Override
    public void cardAction(Cycler cycler) {
        // uses skip instead of nextPlayer in the cycler class to advance the play
        cycler.skip();
    }
}
