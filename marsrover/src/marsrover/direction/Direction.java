package marsrover.direction;

import marsrover.core.Position;

public interface Direction {
    Direction turnLeft();
    Direction turnRight();
    Position moveForward(Position position);
    String getName();
    char getSymbol();
}
