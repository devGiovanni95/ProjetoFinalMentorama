package br.com.giovanni.indaiaModas.service;

import br.com.giovanni.indaiaModas.entities.Products;
import br.com.giovanni.indaiaModas.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public CompletableFuture<List<Products>> findAll(){
        System.out.println("ServiceThread: " + Thread.currentThread().getName());
        return  productRepository.findAllBy();
    }

    public CompletableFuture<Optional<Products>> findById(Integer uuid){
        System.out.println("ServiceThread: " + Thread.currentThread().getName());
        return productRepository.findOneById(uuid);
    }

    public CompletableFuture<Products> save(final Products products){
        System.out.println("ServiceThread: " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture(productRepository.save(products));
    }
//
//    public Products updateName( final Products products,  final Integer uuid){
//        CompletableFuture<Optional<Products>> productToUpdate  = productRepository.findOneById(uuid);
//
//        CompletableFuture<Products> updateToBeUpdate = productToUpdate.thenApply(products1 -> {
//            if (products1.isPresent()){
//                products.setId(uuid);
//                return products1.get();
//            }else {
//                return null;
//            }
//        });
//
//        if (updateToBeUpdate.join() != null){
//            products.setId(uuid);
//            return productRepository.save(products);
//        }else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
//        }
//
//    }


    public void delete(Integer uuid){
        productRepository.deleteById(uuid);
    }


}
