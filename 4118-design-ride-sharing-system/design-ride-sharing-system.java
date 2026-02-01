import java.util.*;

class RideSharingSystem {
    private Queue<Integer> drivers;
    private Queue<Integer> riders;
    private Set<Integer> cancelledRiders;
    private Set<Integer> waitingRiders;

    public RideSharingSystem() {
        drivers = new ArrayDeque<>();
        riders = new ArrayDeque<>();
        cancelledRiders = new HashSet<>();
        waitingRiders = new HashSet<>();
    }

    public void addRider(int riderId) {
        riders.offer(riderId);
        waitingRiders.add(riderId);
    }

    public void addDriver(int driverId) {
        drivers.offer(driverId);
    }

    public int[] matchDriverWithRider() {
        // remove cancelled riders from front
        while (!riders.isEmpty() && cancelledRiders.contains(riders.peek())) {
            int x = riders.poll();
            cancelledRiders.remove(x);
            waitingRiders.remove(x);
        }

        if (drivers.isEmpty() || riders.isEmpty()) return new int[]{-1, -1};

        int driverId = drivers.poll();
        int riderId = riders.poll();

        waitingRiders.remove(riderId); // now matched, not waiting anymore
        return new int[]{driverId, riderId};
    }

    public void cancelRider(int riderId) {
        // cancel ONLY if rider is currently waiting
        if (waitingRiders.contains(riderId)) {
            cancelledRiders.add(riderId);
        }
    }
}
