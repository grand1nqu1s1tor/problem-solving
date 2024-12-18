package uber.service;

import uber.model.Location;

public class DefaultPricingService implements PricingService {

    public static final Double PER_KM_RATE = 10.0;


    public Double findPrice(Location src, Location dest) {
        return src.getDistance(dest) * PER_KM_RATE;
    }
}
