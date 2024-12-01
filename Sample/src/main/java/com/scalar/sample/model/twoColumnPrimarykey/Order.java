package com.scalar.sample.model.twoColumnPrimarykey;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "orders")
public class Order {
    @EmbeddedId
    private OrderKey orderKey;

    private Date orderDate;
}
