package co.com.s4n.delivery.instruction;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InstructionCommandFactory {

    public static final String FORWARD = "A";
    public static final String LEFT = "I";
    public static final String RIGHT = "D";

    private final Map<String, Instruction> instructions;


    public InstructionCommandFactory() {
        instructions = new HashMap<>();
        instructions.put(FORWARD, new ForwardInstruction());
        instructions.put(LEFT, new LeftInstruction());
        instructions.put(RIGHT, new RightInstruction());
    }

    public Instruction getInstruction(String instruction) {
        Optional.ofNullable(instruction).orElseThrow(IllegalArgumentException::new);
        if (instructions.containsKey(instruction)){
            return instructions.get(instruction);
        }
        throw new RuntimeException("Unsupported Instruction");
    }
}
