package cars;

import towns.Store;
import towns.Town;
import towns.TypeProduct;

public class Truck extends Car {

    private Town town;
    private Store store;
    private TypeProduct typeProduct;

    public Truck(Integer nightSpeed, Integer daySpeed, Integer timeInWarehouse) {
        super(nightSpeed, daySpeed, timeInWarehouse);
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    @Override
    public String toString() {
        return "Грузовик";
    }
}
