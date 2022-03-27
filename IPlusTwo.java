public interface IPlusTwo extends ICards{

    // the card action: handles the plus two and advancing the play with super method
    @Override
    public void cardAction(Cycler cycler);
    public String toString();
}
