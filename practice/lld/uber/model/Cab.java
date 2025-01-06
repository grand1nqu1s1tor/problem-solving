package uber.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cab {
    String id;
    String driverName;
    Trip currentTrip;
    Boolean isAvailable;
}
