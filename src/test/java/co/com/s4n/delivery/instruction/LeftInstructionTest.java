package co.com.s4n.delivery.instruction;

import co.com.s4n.delivery.drone.Direction;
import co.com.s4n.delivery.drone.Point;
import co.com.s4n.delivery.drone.Position;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeftInstructionTest {

    @Test
    public void execute() {
        Instruction instruction = new LeftInstruction();
        assertEquals("(0,0) dirección Occidente",
                instruction.execute(new Position(new Point(0,0), Direction.Norte)).toString());
        assertEquals("(0,0) dirección Sur",
                instruction.execute(new Position(new Point(0,0), Direction.Occidente)).toString());
        assertEquals("(0,0) dirección Oriente",
                instruction.execute(new Position(new Point(0,0), Direction.Sur)).toString());
        assertEquals("(0,0) dirección Norte",
                instruction.execute(new Position(new Point(0,0), Direction.Oriente)).toString());
    }
}