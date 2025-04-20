java
enum TrafficSignal {
    RED, YELLOW, GREEN;
}

public class TrafficLight {
    public static void main(String[] args) {
        TrafficSignal signal = TrafficSignal.RED;

        switch (signal) {
            case RED -> System.out.println("Stop");
            case YELLOW -> System.out.println("Slow Down");
            case GREEN -> System.out.println("Go");
        }
    }
}
