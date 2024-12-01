package com.scalar.sample.repositories;

import com.scalar.sample.model.Product;
import com.scalar.sample.projections.ProductWithTitleAndDescription;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(@Nonnull Long id);

    List<Product> findByTitle(String word);

    List<Product> findByTitleContains(String str);

    List<Product> findByTitleAndDescription(String title, String description);

    void delete(@Nonnull Product product);


    Product save(@Nonnull Product product);

    //HQL
    @Query("select p.title as title, p.description as description from Product p where p.id=:id ")
    ProductWithTitleAndDescription someRandomQuery(@Param("id") Long id);

    @Override
    Page<Product> findAll(@Nonnull Pageable pageable);

    //Slice<Product> findByTitle

    @Procedure(name = "getProductById")
    Product getProductById(@Param("i_id") Long id);



}
