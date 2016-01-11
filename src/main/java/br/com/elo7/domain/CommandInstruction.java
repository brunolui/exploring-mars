package br.com.elo7.domain;

import java.util.LinkedList;
import java.util.List;

import static java.lang.String.format;

public enum CommandInstruction {

    MOVE("M", new MoveCommand()),
    TURN_LEFT("L", new TurnLeftCommand()),
    TURN_RIGHT("R", new TurnRightCommand());

    private String instruction;
    private Command command;

    CommandInstruction(String instruction, Command command) {
        this.instruction = instruction;
        this.command = command;
    }

    public String getInstruction() {
        return instruction;
    }

    public Command getCommand() {
        return command;
    }

    public static List<Command> convert(String instructions) {

        List<Command> commands = new LinkedList();

        for (char command : instructions.toCharArray()) {
            commands.add(getBy(command).getCommand());
        }

        return commands;
    }

    private static CommandInstruction getBy(char instruction) {
        for (CommandInstruction commandInstruction : values()) {
            if (commandInstruction.getInstruction().equalsIgnoreCase(String.valueOf(instruction))) {
                return commandInstruction;
            }
        }
        throw new IllegalArgumentException(format("Command %s not found", instruction));
    }
}
