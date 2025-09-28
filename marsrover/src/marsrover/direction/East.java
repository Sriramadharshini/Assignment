package marsrover.direction;

import marsrover.core.Position;

public class East implements Direction {
    private static final East instance = new East();
    private East() {}
    public static East getInstance() { return instance; }

    @Override public Direction turnLeft() { return North.getInstance(); }
    @Override public Direction turnRight() { return South.getInstance(); }
    @Override public Position moveForward(Position pos) { return new Position(pos.x+1, pos.y); }
    @Override public String getName() { return "East"; }
    @Override public char getSymbol() { return '>'; }
}
