package com.scalar.sample.repositories;

import com.scalar.sample.model.twoColumnPrimarykey.CompositeKey;
import com.scalar.sample.model.twoColumnPrimarykey.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyEntityRepository extends JpaRepository<MyEntity, CompositeKey> {
}
