package towns;

import java.util.ArrayList;
import java.util.List;

public class Town {
    private List<Store> stores;
    private Integer distanceToBase;
    private Integer demand;

    public Town(Integer numberStores, Integer distanceToBase, Integer demand) {
        stores = new ArrayList<>(numberStores);
        this.distanceToBase = distanceToBase;
        this.demand = demand;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public Integer getDistanceToBase() {
        return distanceToBase;
    }

    public void setDistanceToBase(Integer distanceToBase) {
        this.distanceToBase = distanceToBase;
    }

    public Integer getDemand() {
        return demand;
    }

    public void setDemand(Integer demand) {
        this.demand = demand;
    }

    public void showStatus() {
        for (Store store : stores) {
            store.showStatus();
        }
    }
}
