package uber.repository;

import uber.model.Cab;
import uber.model.Location;
import uber.model.Rider;
import uber.model.Trip;
import uber.service.CabMatchingService;
import uber.service.PricingService;

import java.util.*;

public class TripsRepository {
    private Map<String, List<Trip>> trips = new HashMap();

    private RidersRepository ridersRepository;
    private CabsRepository cabsRepository;
    private CabMatchingService cabMatchingService;
    private PricingService pricingService;
    public static final Double MAX_ALLOWED_MATCHING_DISTANCE = 10.0;


    public TripsRepository(RidersRepository ridersRepository, CabsRepository cabsRepository, CabMatchingService cabMatchingService, PricingService pricingService){
        this.cabsRepository = cabsRepository;
        this.ridersRepository = ridersRepository;
        this.cabMatchingService = cabMatchingService;
        this.pricingService = pricingService;
    }

    public void createTrip(Rider rider, Location src, Location dest){
        List<Cab> nearbyCabs = cabsRepository.getCabs(src, MAX_ALLOWED_MATCHING_DISTANCE);

        Optional<Cab> selectedCabForTrip = cabMatchingService.matchCabToRider(rider, nearbyCabs, src, dest);
        if(selectedCabForTrip.isEmpty()) throw new RuntimeException();

        Cab selectedCab = selectedCabForTrip.get();

        Double price = pricingService.findPrice(src, dest);

        Trip newTrip = new Trip(rider, selectedCab, price, src, dest);
        if(!trips.containsKey(rider.getId())) {
            trips.put(rider.getId(), new ArrayList());
        }
        trips.get(rider.getId()).add(newTrip);
        selectedCab.setCurrentTrip(newTrip);
    }
}
