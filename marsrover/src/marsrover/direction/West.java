package marsrover.direction;

import marsrover.core.Position;

public class West implements Direction {
    private static final West instance = new West();
    private West() {}
    public static West getInstance() { return instance; }

    @Override public Direction turnLeft() { return South.getInstance(); }
    @Override public Direction turnRight() { return North.getInstance(); }
    @Override public Position moveForward(Position pos) { return new Position(pos.x-1, pos.y); }
    @Override public String getName() { return "West"; }
    @Override public char getSymbol() { return '<'; }
}
