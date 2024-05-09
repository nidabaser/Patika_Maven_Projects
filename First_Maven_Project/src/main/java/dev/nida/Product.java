package dev.nida;

import jakarta.persistence.*;

import java.util.List;

/**
 * @author Nida Başer
 * April 2024
 */

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "product_price", nullable = false)
    private double price;

    @Column(name = "product_stock")
    private int stock;

    // Fetch type performans sorunlarıyla alakalıdır: iki türü var lazy veya eager(varsayılan)
    // Cascade ise bir tablodaki değişiklikler diğer ilişkili tabloları etkiler. Nesne alt nesneyi etkiler.
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "product_code_id", referencedColumnName = "code_id")
    private Code code;

    @ManyToOne(fetch = FetchType.LAZY) // Bunlarda persist mantıklı değil
    @JoinColumn(name = "product_supplier_id", referencedColumnName = "supplier_id")
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY) // Bunlarda persist mantıklı değil
    @JoinColumn(name = "product_category_id", referencedColumnName = "category_id")
    private Category category;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable( // Bu sefer ara tablo var o yüzden JoinColumn değil JoinTable
            name = "pro2colors",
            joinColumns = {@JoinColumn(name = "pro2color_product_id")},
            inverseJoinColumns = {@JoinColumn(name = "pro2color_color_id")}
    )
    private List<Color> colorList;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Color> getColorList() {
        return colorList;
    }

    public void setColorList(List<Color> colorList) {
        this.colorList = colorList;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", code=" + code +
                ", supplier=" + supplier +
                ", category=" + category +
                ", colorList=" + colorList +
                '}';
    }
}
