package com.scalar.sample.representingInheritance.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name="ja_user")
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
}
