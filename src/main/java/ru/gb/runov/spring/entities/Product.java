package ru.gb.runov.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private String cost;




    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

//    @ManyToOne
//    @JoinColumn(name = "university_id")
//    private  university;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  //  public University getUniversity() {
  //      return university;
  //  }

  //  public void setUniversity(University university) {
  //      this.university = university;
  //  }

    public Product() {
    }

    //public Student(String name, University university) {
    //    this.name = name;
    //    this.university = university;
    //}

    @Override
    public String toString() {
        return String.format("Product [id = %d, name = %s]", id, name);
    }

}

