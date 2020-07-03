package co.com.s4n.delivery.drone;

public enum Direction {

    Norte {
        public Direction right() {
            return Oriente;
        }

        public Direction left() {
            return Occidente;
        }

        public Point point() {
            return new Point(0,1);
        }
    }, Sur {
        public Direction right() {
            return Occidente;
        }

        public Direction left() {
            return Oriente;
        }

        public Point point() {
            return new Point(0,-1);
        }
    }, Oriente {
        public Direction right() {
            return Sur;
        }

        public Direction left() {
            return Norte;
        }

        public Point point() {
            return new Point(1,0);
        }
    }, Occidente {
        public Direction right() {
            return Norte;
        }

        public Direction left() {
            return Sur;
        }

        public Point point() {
            return new Point(-1,0);
        }
    };

    public abstract Direction right();
    public abstract Direction left();
    public abstract Point point ();

}
