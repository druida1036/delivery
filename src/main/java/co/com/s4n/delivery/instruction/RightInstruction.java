package co.com.s4n.delivery.instruction;

import co.com.s4n.delivery.drone.Position;

public class RightInstruction implements Instruction {
    @Override
    public Position execute(Position position) {
        return new Position(position.getPoint(), position.getDirection().right());
    }
}
