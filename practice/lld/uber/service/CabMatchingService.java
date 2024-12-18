package uber.service;

import uber.model.Cab;
import uber.model.Location;
import uber.model.Rider;

import java.util.List;
import java.util.Optional;

public interface CabMatchingService {

    //Matches cabs to rider
    Optional<Cab> matchCabToRider(Rider rider, List<Cab> candidateCabs, Location fromPoint, Location toPoint);

}
