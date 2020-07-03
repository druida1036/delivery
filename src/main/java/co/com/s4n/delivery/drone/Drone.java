package co.com.s4n.delivery.drone;

import co.com.s4n.delivery.instruction.InstructionCommandFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static co.com.s4n.delivery.constants.AppConstants.CAPACITY_EXCEEDED;
import static co.com.s4n.delivery.constants.AppConstants.INVALID_ARGUMENT;

public class Drone {

    private Position position;
    private InstructionCommandFactory instructionCommandFactory;
    private final Integer capacity;

    public Drone(Integer capacity) {
        this.capacity = capacity;
        this.position = new Position(new Point(0, 0), Direction.Norte);
        instructionCommandFactory = new InstructionCommandFactory();
    }

    public List<String> deliver( List<String> deliveryPaths) {
        Optional.ofNullable(deliveryPaths).orElseThrow( () -> new IllegalArgumentException(INVALID_ARGUMENT));
        if(deliveryPaths.size() > capacity){
            throw  new RuntimeException(CAPACITY_EXCEEDED);
        }
        this.position = new Position(new Point(0, 0), Direction.Norte);
        return deliveryPaths.stream()
                .map((instruction)-> deliver(instruction).toString())
                .collect(Collectors.toList());
    }



    private Position deliver(String instruction) {
        for (char c : instruction.toCharArray()) {
            position = instructionCommandFactory.getInstruction(String.valueOf(c)).execute(this.position);
        }
        return position;
    }


}
