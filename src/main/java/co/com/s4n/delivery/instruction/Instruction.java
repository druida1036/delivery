package co.com.s4n.delivery.instruction;

import co.com.s4n.delivery.drone.Position;

public interface Instruction {
    Position execute(Position position);
}
