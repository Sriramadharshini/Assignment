package marsrover.controller;

import marsrover.command.Command;
import marsrover.core.*;

import java.util.*;

public class RoverController {
    private final Rover rover;
    private final CommandFactory factory;
    private final List<Command> commandQueue = new ArrayList<>();

    public RoverController(Rover rover) {
        this.rover = rover;
        this.factory = new CommandFactory(rover);
    }

    public void addCommandsFromString(String commandsStr) {
        for (char c : commandsStr.toCharArray()) {
            try {
                commandQueue.add(factory.createCommand(c));
            } catch (InvalidCommandException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void executeCommands() {
        System.out.println("\nInitial State:");
        displayGrid();

        for (Command command : commandQueue) {
            command.execute();
            System.out.println("\nGrid after command:");
            displayGrid();
        }
        commandQueue.clear();
    }

    private void displayGrid() {
        Grid grid = rover.getGrid();
        Position roverPos = rover.getPosition();
        char roverSymbol = rover.getDirection().getSymbol();

        for (int y = grid.getHeight() - 1; y >= 0; y--) {
            for (int x = 0; x < grid.getWidth(); x++) {
                Position current = new Position(x, y);
                if (current.equals(roverPos)) {
                    System.out.print(" " + roverSymbol + " ");
                } else if (grid.hasObstacle(current)) {
                    System.out.print(" X ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }
}
