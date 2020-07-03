package co.com.s4n.delivery.drone;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Position {
    private Point point;
    private Direction direction;

    @Override
    public String toString() {
        return  point + " dirección " + direction;
    }
}
