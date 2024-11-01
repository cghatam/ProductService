package com.scalar.sample.repositories;

import com.scalar.sample.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    //List<Category> findByProductsId(Long id);
    /* Category findByTitle(String title); */

}
