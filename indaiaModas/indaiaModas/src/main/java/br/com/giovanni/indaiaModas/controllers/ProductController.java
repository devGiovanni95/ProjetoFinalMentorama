package br.com.giovanni.indaiaModas.controllers;

import br.com.giovanni.indaiaModas.entities.Products;
import br.com.giovanni.indaiaModas.exceptions.ProductNotFound;
import br.com.giovanni.indaiaModas.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RequestMapping("/products")
@RestController
@Async
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    public CompletableFuture<List<Products>> findAll(){
        System.out.println("Controller Thread: " + Thread.currentThread().getName());
        return  this.productService.findAll();
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{uuid}")
    public CompletableFuture<Products> findById(@PathVariable("uuid") Integer uuid){
        System.out.println("Controller Thread: " + Thread.currentThread().getName());
        return  this.productService.findById(uuid)
                .thenApply(x -> {
                    try {
                        return x.orElseThrow(ProductNotFound::new);
                    }catch (ProductNotFound e){
                        e.printStackTrace();
                    }
                    return null;
                });
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public CompletableFuture<Products> add(@RequestBody final Products products){
        System.out.println("Controller Thread: " + Thread.currentThread().getName());
        return this.productService.save(products);
    }

//    @ResponseStatus(code = HttpStatus.OK)
//    @PatchMapping(value = "/{id}")
//    public  CompletableFuture<Products> update(@RequestBody final Products products, @PathVariable final UUID uuid);

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable("uuid")Integer uuid){
        productService.delete(uuid);
    }
}
