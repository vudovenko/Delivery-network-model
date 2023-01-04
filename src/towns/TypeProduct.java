package towns;

public enum TypeProduct {
    HEAVY_OVERSIZE("Тяжелый негабарит"),
    HEAVY_EURO_PALLETS("Тяжеллые евро паллеты"),
    PLUMBING("Сантехника"),
    LIGHT_EURO_PALLETS("Легкие евро паллеты");

    private final String productName;

    TypeProduct(String productName) {
        this.productName = productName;
    }

    public String getName() {
        return productName;
    }
}
