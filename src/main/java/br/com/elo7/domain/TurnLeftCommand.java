package br.com.elo7.domain;

public class TurnLeftCommand implements Command {

    @Override
    public void run(SpaceProbe spaceProbe) {
        spaceProbe.turnLeft();
    }
}
