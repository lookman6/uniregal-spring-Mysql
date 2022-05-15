package com.gestionbuvette.uniregal.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity/*
@Data
@NoArgsConstructor
@AllArgsConstructor */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Product extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double prix;
    private String photo;

    @ManyToOne
    @JoinColumn(name="categoryid", insertable=false, updatable=false)
    private Category category;

    private Integer categoryid;

    public Product() {
    }
    public Product(Integer id, String name, Double prix, String photo, Category category, Integer categoryid) {
        this.id = id;
        this.name = name;
        this.prix = prix;
        this.photo = photo;
        this.category = category;
        this.categoryid = categoryid;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrix() {
        return prix;
    }
    public void setPrix(Double prix) {
        this.prix = prix;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public Integer getCategoryid() {
        return categoryid;
    }
    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }
}
