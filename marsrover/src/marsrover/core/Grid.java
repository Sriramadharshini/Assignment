package marsrover.core;

import java.util.*;
import java.util.stream.Collectors;

public class Grid {
    private final int width;
    private final int height;
    private final Set<Position> obstaclePositions;

    public Grid(int width, int height, List<Position> obstacles) {
        this.width = width;
        this.height = height;
        this.obstaclePositions = new HashSet<>(obstacles);
        System.out.println(String.format(
                "Grid created of size %dx%d with obstacles at %s",
                width, height,
                obstacles.stream().map(Position::toString).collect(Collectors.joining(", "))
        ));
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public boolean isWithinBounds(Position position) {
        return position.x >= 0 && position.x < width && position.y >= 0 && position.y < height;
    }

    public boolean hasObstacle(Position position) {
        return obstaclePositions.contains(position);
    }
}
