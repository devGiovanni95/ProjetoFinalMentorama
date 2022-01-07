package br.com.giovanni.indaiaModas.entities;

import javax.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String cpf;
    private String password;

    @OneToMany
    @JoinColumn(name = "address_id")
    private Address address;

    public Address getAddress() {
        return address;
    }


}
