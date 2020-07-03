package co.com.s4n.delivery.drone;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Point {
    private int x;
    private int y;

    public Point add(Point point){
        return new Point(this.x+point.getX(), this.y+point.getY());
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ')';
    }
}
