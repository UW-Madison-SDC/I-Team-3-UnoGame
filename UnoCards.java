public class UnoCards {

  private Color color;
  private final Value value;

  //enumeration of all desired colors
  //public method to access/see what color is chosen (will be useful when populating array)
  enum Color {

    RED, BLUE, GREEN, YELLOW, WILD;

    private static final Color[] colors = Color.values();

    public static Color getColor(int i){
      return colors[i];
    }

  }

  //enumeration of all desired values
  //public method to access/see what color is chosen (will be useful when populating array)
  enum Value {

    ONE, TW0, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, REVERSE, SKIP, DRAW_TWO, WILD_FOUR, WILD;

    public static final Value[] values = Value.values();

    public static Value getValue(int i){
      return values[i];
    }
  }

  //create uno card
  public UnoCards (Color color, Value value){
    this.color = color;
    this.value = value;
  }

  public Color getColor(){
    return this.color;
  }

  public Value getValue(){
    return this.value;
  }

}
