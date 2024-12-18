package uber.service;

import uber.model.Location;

public interface PricingService {
    Double findPrice(Location src, Location dest);

}
