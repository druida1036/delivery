package co.com.s4n.delivery.instruction;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class InstructionCommandFactoryTest {

    @Test
    public void getInstruction() {
        InstructionCommandFactory factory = new InstructionCommandFactory();

        assertThat(factory.getInstruction(InstructionCommandFactory.FORWARD), instanceOf(ForwardInstruction.class));

        assertThat(factory.getInstruction(InstructionCommandFactory.LEFT), instanceOf(LeftInstruction.class));

        assertThat(factory.getInstruction(InstructionCommandFactory.RIGHT), instanceOf(RightInstruction.class));
    }


    @Test ( expected = RuntimeException.class)
    public void getInstructionUnsupportedInstruction() {
        InstructionCommandFactory factory = new InstructionCommandFactory();
        factory.getInstruction("T");
        factory.getInstruction("");
        factory.getInstruction(null);
    }
}