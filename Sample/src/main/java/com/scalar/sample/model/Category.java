package com.scalar.sample.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{

    private String title;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL,fetch= FetchType.LAZY)//, )
    private List<Product> products = new LinkedList<>();


}
