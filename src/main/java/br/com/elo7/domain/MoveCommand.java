package br.com.elo7.domain;

public class MoveCommand implements Command {

    @Override
    public void run(SpaceProbe spaceProbe) {
        spaceProbe.move();
    }
}
