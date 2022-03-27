import java.util.Scanner;

public interface IWild extends ICards{


    // one constructor initialize the color to be and the face value of 10

    public void setWildColor();
    // sets the color of the wild card: both the normal wild card and the +4

    @Override
    public void cardAction(Cycler cycler);
    public String toString();



}
