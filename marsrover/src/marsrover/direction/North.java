package marsrover.direction;

import marsrover.core.Position;

public class North implements Direction {
    private static final North instance = new North();
    private North() {}
    public static North getInstance() { return instance; }

    @Override public Direction turnLeft() { return West.getInstance(); }
    @Override public Direction turnRight() { return East.getInstance(); }
    @Override public Position moveForward(Position pos) { return new Position(pos.x, pos.y + 1); }
    @Override public String getName() { return "North"; }
    @Override public char getSymbol() { return '^'; }
}
