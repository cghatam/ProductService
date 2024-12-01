package com.scalar.sample.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Getter
@Setter
@Entity
@NamedStoredProcedureQuery(
        name = "GetProductById",
        procedureName = "getProductById",
        resultClasses = Product.class,
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "i_id", type = Long.class)
        }
)
public class Product extends BaseModel{
    @NotNull(message = "Title is mandatory")
    @NotBlank(message = "Title is blank")
    private String title;

    private Double price;
    private String description;
    private String imageUrl;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private Category category;


}

