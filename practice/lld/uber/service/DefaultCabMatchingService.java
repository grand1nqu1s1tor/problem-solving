package uber.service;

import uber.model.Cab;
import uber.model.Location;
import uber.model.Rider;

import java.util.List;
import java.util.Optional;

public class DefaultCabMatchingService implements CabMatchingService{
    @Override
    public Optional<Cab> matchCabToRider(Rider rider, List<Cab> candidateCabs, Location src, Location dest) {
        return candidateCabs.stream().findAny();
    }
}
