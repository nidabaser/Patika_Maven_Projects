package dev.nida;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * @author Nida Başer
 * April 2024
 */

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id") // columnDefinition = "serial"
    private int id; // customer_id

    @Column(name = "customer_name", length = 100, nullable = false)
    private String name; // customer_name

    @Column(name = "customer_mail", unique = true, nullable = false)
    private String mail;

    @Temporal(TemporalType.DATE)
    @Column(name = "customer_on_date")
    private LocalDate onDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_gender")
    private GENDER gender;
    public enum GENDER {
        MALE,
        FEMALE
    }

    public Customer() {
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getOnDate() {
        return onDate;
    }

    public void setOnDate(LocalDate onDate) {
        this.onDate = onDate;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", onDate=" + onDate +
                ", gender=" + gender +
                '}';
    }
}
