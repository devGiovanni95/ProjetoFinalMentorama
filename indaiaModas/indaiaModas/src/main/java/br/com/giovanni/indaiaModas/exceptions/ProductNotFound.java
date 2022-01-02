package br.com.giovanni.indaiaModas.exceptions;

public class ProductNotFound extends  InterruptedException{

    public ProductNotFound(){
        System.out.println("Product not found");
    }

}
