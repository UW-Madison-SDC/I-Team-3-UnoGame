public class WildPlusFour extends Wild implements IWildPlusFour{

    @Override
    public void cardAction(Cycler cycler) {
        PlusOperation.stack(4);
        super.cardAction(cycler);
    }
}
