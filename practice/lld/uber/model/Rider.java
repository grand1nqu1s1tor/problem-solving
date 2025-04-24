package uber.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rider {
    String id;
    String riderName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRiderName() {
        return riderName;
    }

    public void setRiderName(String riderName) {
        this.riderName = riderName;
    }
}
