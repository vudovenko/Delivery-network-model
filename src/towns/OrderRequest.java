package towns;

public class OrderRequest {
    private Town town;
    private Integer shopId;
    private TypeProduct typeProduct;

    public OrderRequest(Town town, Integer shopId, TypeProduct typeProduct) {
        this.town = town;
        this.shopId = shopId;
        this.typeProduct = typeProduct;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
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
                ", shopId=" + shopId +
                ", typeProduct=" + typeProduct +
                '}';
    }
}
