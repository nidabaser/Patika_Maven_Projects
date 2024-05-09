package dev.nida;

import jakarta.persistence.*;
import java.util.List;

/**
 * @author Nida Başer
 * April 2024
 */

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;

    @Column(name = "category_name")
    private String name;

    // Category silinirse o kategoriye ait her şey silinmeli, product_category_id foreign_key boşa çıkar çünkü
    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Product> productList;

    public Category() {
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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
