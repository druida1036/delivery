package co.com.s4n.delivery.drone;

import co.com.s4n.delivery.constants.AppConstants;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static co.com.s4n.delivery.constants.AppConstants.NOT_AVAILABLE_DRONES;
import static co.com.s4n.delivery.constants.AppConstants.OUTPUT_FOLDER_PREFIX;
import static co.com.s4n.delivery.util.FileUtil.writeFile;
import static co.com.s4n.delivery.util.FileUtil.readDirectoryFiles;
import static co.com.s4n.delivery.util.FileUtil.readFile;


public class DroneOperator {
    private String input;
    private String output;

    private List<Drone> drones;

    public DroneOperator(Integer numberDrones, String input, String output, int capacity) {
        this.input = input;
        this.output = output;
        drones = new CopyOnWriteArrayList<>();
        IntStream.range(0,numberDrones).forEach((i) ->drones.add(new Drone(capacity)));
    }

    public void process(){
        readDirectoryFiles(input).parallelStream().forEach(deliverInput -> {
            Drone drone = getFreeDrone();
            List<String> results = drone.deliver(readFile(deliverInput));
            writeFile(output, OUTPUT_FOLDER_PREFIX +getNumberInput(deliverInput), results);
            releaseDrone(drone);
        });

    }

    private String getNumberInput(String deliverInput) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(deliverInput);
        String group = "";
        if(m.find()) {
            group = m.group();
        }
        return group;
    }

    private void releaseDrone(Drone drone) {
        this.drones.add(drone);
    }

    private Drone getFreeDrone() {
        if(drones.size() == 0){
            throw new RuntimeException(NOT_AVAILABLE_DRONES);
        }
        Drone drone = drones.get(drones.size() - 1);
        drones.remove(drones.get(drones.size() - 1));
        return drone;
    }
}
