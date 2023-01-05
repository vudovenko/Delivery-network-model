package towns;

public class OrderRequest {
    private Town town;
    private Store store;
    private TypeProduct typeProduct;

    public OrderRequest(Town town, Store store, TypeProduct typeProduct) {
        this.town = town;
        this.store = store;
        this.typeProduct = typeProduct;
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
        return "OrderRequest{" +
                "town=" + town +
                ", store=" + store +
                ", typeProduct=" + typeProduct +
                '}';
    }
}
