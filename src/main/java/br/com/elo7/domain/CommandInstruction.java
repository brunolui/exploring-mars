package br.com.elo7.domain;

import static java.lang.String.format;

public enum CommandInstruction {

    MOVE("M"),
    TURN_LEFT("L"),
    TURN_RIGHT("R");

    private String command;

    CommandInstruction(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static CommandInstruction getBy(char command) {
        for (CommandInstruction commandInstruction : values()) {
            if (commandInstruction.getCommand().equalsIgnoreCase(String.valueOf(command))) {
                return commandInstruction;
            }
        }
        throw new IllegalArgumentException(format("Command %s not found", command));
    }
}
