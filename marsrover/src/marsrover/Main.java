package marsrover;

import marsrover.core.*;
import marsrover.direction.*;
import marsrover.controller.RoverController;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // --- Simulation 1: Standard Run ---
        System.out.println("--- Starting Simulation 1 ---");

        // 1. Initialize Grid and Obstacles
        List<Position> obstacles = new ArrayList<>();
        obstacles.add(new Position(2, 2));
        obstacles.add(new Position(3, 5));
        Grid grid = new Grid(10, 10, obstacles);

        // 2. Initialize Rover
        Map<Character, Direction> directionMap = new HashMap<>();
        directionMap.put('N', North.getInstance());
        directionMap.put('S', South.getInstance());
        directionMap.put('E', East.getInstance());
        directionMap.put('W', West.getInstance());

        Position startPos = new Position(0, 0);
        Rover rover = new Rover(startPos, directionMap.get('N'), grid);

        // 3. Define Commands
        String commandsInput = "MRMMLMRML";

        // 4. Create controller and execute commands
        RoverController controller = new RoverController(rover);
        controller.addCommandsFromString(commandsInput);
        controller.executeCommands();

        // 5. Print Final Report
        String finalStatus = rover.getStatusReport();
        System.out.println("\n--- Simulation 1 Complete ---");
        System.out.println("Initial Position: (0, 0, N)");
        System.out.println("Commands: ['M', 'M', 'R', 'M', 'L', 'M']");
        System.out.println("Obstacles: [(2, 2), (3, 5)]");
        System.out.println("Final Status: " + finalStatus);
    }
}
