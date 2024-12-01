package com.scalar.sample.model.twoColumnPrimarykey;

import jakarta.persistence.Embeddable;

import lombok.*;

import java.util.Objects;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderKey {
    private Long orderId;
    private Long productId;

    //Override equal and hashcode functions
    @Override
    public boolean equals(Object o){
        if (this == o) return true;

        if(o == null || o.getClass() != this.getClass()) return false;

        OrderKey orderKey = (OrderKey) o;
        return (orderKey.orderId.equals(this.orderId)
                && orderKey.productId.equals(this.productId));
    }

    @Override
    public int hashCode(){
        return Objects.hash(orderId, productId);
    }

}
