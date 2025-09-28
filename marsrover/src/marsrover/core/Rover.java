package marsrover.core;

import marsrover.direction.Direction;

public class Rover {
    private Position position;
    private Direction direction;
    private final Grid grid;

    public Rover(Position position, Direction direction, Grid grid) {
        this.position = position;
        this.direction = direction;
        this.grid = grid;
        System.out.println("Rover initialized at " + position + " facing " + direction.getName());
    }

    public Position getPosition() { return position; }
    public Direction getDirection() { return direction; }
    public Grid getGrid() { return grid; }

    public void move() {
        Position nextPosition = direction.moveForward(position);
        if (!grid.isWithinBounds(nextPosition)) {
            System.out.println("Move failed: out of bounds " + nextPosition);
            return;
        }
        if (grid.hasObstacle(nextPosition)) {
            System.out.println("Move failed: obstacle at " + nextPosition);
            return;
        }
        this.position = nextPosition;
        System.out.println("Rover moved to " + this.position);
    }

    public void turnLeft() {
        this.direction = this.direction.turnLeft();
        System.out.println("Rover turned left, now facing " + this.direction.getName());
    }

    public void turnRight() {
        this.direction = this.direction.turnRight();
        System.out.println("Rover turned right, now facing " + this.direction.getName());
    }

    public String getStatusReport() {
        String status = String.format("Rover is at %s facing %s.", position, direction.getName());
        Position nextPos = direction.moveForward(position);
        if (grid.hasObstacle(nextPos)) {
            status += " Obstacle ahead at " + nextPos + ".";
        } else {
            status += " No obstacles ahead.";
        }
        return status;
    }
}
