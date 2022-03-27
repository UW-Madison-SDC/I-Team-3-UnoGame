import java.util.Scanner;

public class Wild extends Cards implements IWild{

    public Wild() {
        super(0, 10);
    }

    @Override
    public void setWildColor() {
        // to be implemented
    }

    @Override
    public void cardAction(Cycler cycler){
        this.setWildColor();
        super.cardAction(cycler);
    }
}
