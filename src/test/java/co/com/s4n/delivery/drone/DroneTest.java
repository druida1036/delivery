package co.com.s4n.delivery.drone;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class DroneTest {

    @Test  (expected = IllegalArgumentException.class)
    public void deliverWithNullDeliver() {
        Drone drone = new Drone(3);
        drone.deliver(null);
    }


    @Test
    public void deliverWithEmptyDeliveres() {
        Drone drone = new Drone(3);
        assertEquals(0, drone.deliver(new ArrayList<>()).size());
    }

    @Test  (expected = RuntimeException.class)
    public void deliverOverCapacity() {
        Drone drone = new Drone(3);
        drone.deliver(Arrays.asList("deliver1", "deliver2", "deliver3", "deliver4"));
    }

    @Test  (expected = RuntimeException.class)
    public void deliverInvalidPathDeliver() {
        Drone drone = new Drone(3);
        drone.deliver(Collections.singletonList("deliver1"));
    }

    @Test
    public void deliverWithValidDeliverer() {
        /*
        AAAAIAA
        DDDAIAD
        AAIADAD
        == Reporte de entregas ==
        (-2, 4) dirección Norte
        (-3, 3) dirección Sur
        (-4, 2) dirección Oriente*/
        Drone drone = new Drone(3);

        //First Instruction
        List<String> result = drone.deliver(Collections.singletonList("AAAAIAA"));
        assertEquals("(-2,4) dirección Occidente", result.get(0));
        assertEquals(1, result.size());

        result = drone.deliver(Arrays.asList("AAAAIAA", "DDDAIAD"));
        assertEquals("(-2,4) dirección Occidente", result.get(0));
        assertEquals("(-1,3) dirección Sur", result.get(1));
        assertEquals(2, result.size());

        result = drone.deliver(Arrays.asList("AAAAIAA", "DDDAIAD", "AAIADAD"));
        assertEquals("(-2,4) dirección Occidente", result.get(0));
        assertEquals("(-1,3) dirección Sur", result.get(1));
        assertEquals("(0,0) dirección Occidente", result.get(2));
        assertEquals(3, result.size());

        result = drone.deliver(Arrays.asList("IIII", "DDDD"));
        assertEquals("(0,0) dirección Norte", result.get(0));
        assertEquals("(0,0) dirección Norte", result.get(1));
        assertEquals(2, result.size());
    }
}