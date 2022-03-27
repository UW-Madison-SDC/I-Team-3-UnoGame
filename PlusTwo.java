public class PlusTwo extends Cards implements IPlusTwo{
    public PlusTwo(int color) {
        super(color, 10);
    }

    @Override
    public void cardAction(Cycler cycler) {
        PlusOperation.stack(2);
        super.cardAction(cycler);
    }

    @Override
    public String toString(){
        return "PlusTwo" + super.toString();
    }
}
