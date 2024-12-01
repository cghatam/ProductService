package com.scalar.sample.repositories;

import com.scalar.sample.model.twoColumnPrimarykey.Order;
import com.scalar.sample.model.twoColumnPrimarykey.OrderKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, OrderKey> {
}
