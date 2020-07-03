package co.com.s4n.delivery.instruction;

import co.com.s4n.delivery.drone.Direction;
import co.com.s4n.delivery.drone.Point;
import co.com.s4n.delivery.drone.Position;
import org.junit.Test;

import static org.junit.Assert.*;

public class ForwardInstructionTest {

    @Test
    public void execute() {
        Instruction instruction = new ForwardInstruction();
        assertEquals("(0,1) dirección Norte",
                instruction.execute(new Position(new Point(0,0), Direction.Norte)).toString());
        assertEquals("(-1,0) dirección Occidente",
                instruction.execute(new Position(new Point(0,0), Direction.Occidente)).toString());
        assertEquals("(0,-1) dirección Sur",
                instruction.execute(new Position(new Point(0,0), Direction.Sur)).toString());
        assertEquals("(1,0) dirección Oriente",
                instruction.execute(new Position(new Point(0,0), Direction.Oriente)).toString());
    }
}