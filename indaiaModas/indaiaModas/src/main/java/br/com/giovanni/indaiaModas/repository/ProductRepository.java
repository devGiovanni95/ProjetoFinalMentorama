package br.com.giovanni.indaiaModas.repository;

import br.com.giovanni.indaiaModas.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Async("executorService")
@Repository
public interface ProductRepository extends JpaRepository<Products,Integer> {

    CompletableFuture<Optional<Products>> findOneById(final Integer uuid);

    CompletableFuture<List<Products>> findAllBy();

    void deleteById(final Integer uuid);
}
