package br.com.giovanni.indaiaModas.entities;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private Integer number;
    private Integer cep;
    private String district;
    private String city;
    private String state;

    //um endereço pode ter um cliente
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    public Address() {
    }

    public Address(Integer id, String street, Integer number, Integer cep, String district, String city, String state) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.cep = cep;
        this.district = district;
        this.city = city;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
