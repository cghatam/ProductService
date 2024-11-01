package com.scalar.sample.model.twoColumnPrimarykey;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class CompositeKey implements Serializable {
    private Long keyPart1;
    private Long keyPart2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeKey that = (CompositeKey) o;
        return Objects.equals(keyPart1, that.keyPart1) &&
                Objects.equals(keyPart2, that.keyPart2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyPart1, keyPart2);
    }

}
