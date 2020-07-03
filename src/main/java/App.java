import co.com.s4n.delivery.drone.DroneOperator;

public class App {

    public static void main(String[] args) {
        DroneOperator operator = new DroneOperator(20,"input", "output", 3);
        operator.process();

    }

}
