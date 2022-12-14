package com.driver.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public String getEmailId() {
        return emailId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public Card getCard() {
        return card;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Student(String email, String name, int age, String country) {
        this.emailId = email;
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Column(unique = true)
    private String emailId;
    private String name;
    private int age; // in case we want to check on the basis of age while issuing

    private String country;

    public Student() {
    }

    // alter table student add foreign key constraint card references Card(id)

    @OneToOne
    @JoinColumn   // join this column to the primary key of Card table
    @JsonIgnoreProperties("student")
    private Card card;


    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", email='" + emailId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
