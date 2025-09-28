package marsrover.direction;

import marsrover.core.Position;

public class South implements Direction {
    private static final South instance = new South();
    private South() {}
    public static South getInstance() { return instance; }

    @Override public Direction turnLeft() { return East.getInstance(); }
    @Override public Direction turnRight() { return West.getInstance(); }
    @Override public Position moveForward(Position pos) { return new Position(pos.x, pos.y - 1); }
    @Override public String getName() { return "South"; }
    @Override public char getSymbol() { return 'v'; }
}
