package br.com.giovanni.indaiaModas.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class ProductOrder {

    @Id
    private Integer id;

    private List<Products> products;

    private TypePayment typePayment;



}
