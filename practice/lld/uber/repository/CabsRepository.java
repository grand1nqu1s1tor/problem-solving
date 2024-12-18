package uber.repository;

import uber.model.Cab;
import uber.model.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CabsRepository {

    //Using hashmap as the in-memory database
    Map<String, Cab> cabsDB = new HashMap();

    public void createCab(Cab cab) {

    }

    //Find all the cabs from a source location within a fixed distance
    public List<Cab> getCabs(Location src, Double distance) {
        return null;
    }

    public void updateCabAvailability(String cabId, Boolean newAvailability) {
    }

    public void updateCabLocation(String cabId, Location newLocation) {
    }


}
