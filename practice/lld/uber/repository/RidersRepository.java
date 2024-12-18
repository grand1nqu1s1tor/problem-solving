package uber.repository;

import uber.model.Rider;

import java.util.HashMap;
import java.util.Map;

public class RidersRepository {

    Map<String, Rider> riderDB = new HashMap();
    public void createRider(Rider newRider){
        riderDB.put(newRider.getId(), newRider);
    }

    public Rider getRider(String riderId){
        return riderDB.get(riderId);
    }
}
