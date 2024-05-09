package dev.nida;

import jakarta.persistence.*;

import java.util.List;

/**
 * @author Nida Başer
 * April 2024
 */

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private int id;

    @Column(name = "supplier_address")
    private String address;

    @Column(name = "supplier_company")
    private String company;

    @Column(name = "supplier_person")
    private String person;

    @Column(name = "supplier_mail", unique = true)
    private String mail;

    @Column(name = "supplier_contact")
    private String contact;

    // Category'deki remove ile aynı mantık, verilerimiz anlamsızlığa boşluğa düşmemeli
    @OneToMany(mappedBy = "supplier", cascade = CascadeType.REMOVE)
    private List<Product> productList;

    public Supplier() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", company='" + company + '\'' +
                ", person='" + person + '\'' +
                ", mail='" + mail + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}