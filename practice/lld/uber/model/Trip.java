package uber.model;

import static uber.model.TripStatus.IN_PROGRESS;

enum TripStatus{
    IN_PROGRESS,
    FINISHED
}
public class Trip {
    private Rider rider;
    private Cab cab;
    private TripStatus tripStatus;
    private Double price;
    private Location src;
    private Location dest;

    public Trip(Rider rider, Cab cab, Double price, Location src, Location dest) {
        this.rider = rider;
        this.cab = cab;
        this.price = price;
        this.src = src;
        this.dest = dest;
        this.tripStatus = IN_PROGRESS;
    }
}
