package com.scalar.sample.model.twoColumnPrimarykey;

import com.scalar.sample.model.twoColumnPrimarykey.CompositeKey;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MyEntity {
    @EmbeddedId
    private CompositeKey compositeKey;
    private String someOtherKey;
}
