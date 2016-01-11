package br.com.elo7.domain;

public class TurnRightCommand implements Command {

    @Override
    public void run(SpaceProbe spaceProbe) {
        spaceProbe.turnRight();
    }
}
