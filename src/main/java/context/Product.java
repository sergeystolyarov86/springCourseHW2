package context;

public class Product {
    Long id;
    String title;
    double coast;

    public Product() {
    }

    public Product(long id, String title, double coast) {
        this.id = id;
        this.title = title;
        this.coast = coast;
    }

    @Override
    public String toString() {
        return "Product:" +
                " id = " + id +
                ", title = '" + title + '\'' +
                ", coast = " + coast +
                ';';
    }

    public Long getId() {
        return this.id;
    }
}
