package br.com.giovanni.indaiaModas.entities;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Autowired
    private String name;
    @Autowired
    private String description;
    @Autowired
    private Double price;
    @Autowired
    private Double pricewithdiscount;
    @Autowired
    private Integer quantityInStock;

    public Products() {
    }

    public Products(Integer id, String name, String description, Double price, Double pricewithdiscount, Integer quantityInStock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.pricewithdiscount = pricewithdiscount;
        this.quantityInStock = quantityInStock;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPricewithdiscount() {
        return pricewithdiscount;
    }

    public void setPricewithdiscount(Double pricewithdiscount) {
        this.pricewithdiscount = pricewithdiscount;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}
