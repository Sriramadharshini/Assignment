package marsrover.controller;

import marsrover.command.*;
import marsrover.core.*;

import java.util.*;

public class CommandFactory {
    private final Map<Character, Class<? extends Command>> commandsMap = new HashMap<>();
    private final Rover rover;

    public CommandFactory(Rover rover) {
        this.rover = rover;
        commandsMap.put('M', MoveCommand.class);
        commandsMap.put('L', TurnLeftCommand.class);
        commandsMap.put('R', TurnRightCommand.class);
    }

    public Command createCommand(char c) throws InvalidCommandException {
        Class<? extends Command> clazz = commandsMap.get(c);
        if (clazz == null) throw new InvalidCommandException("Invalid command: " + c);
        try {
            return clazz.getDeclaredConstructor(Rover.class).newInstance(rover);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
