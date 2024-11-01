package com.scalar.sample.service;

import com.scalar.sample.model.twoColumnPrimarykey.CompositeKey;
import com.scalar.sample.model.twoColumnPrimarykey.MyEntity;
import com.scalar.sample.repositories.MyEntityRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class MyEntityService {
    private MyEntityRepository repository;

    public MyEntity save(MyEntity myEntity){
        return repository.save(myEntity);
    }

    public Optional<MyEntity> findById(CompositeKey id){
        return repository.findById(id);
    }

}
