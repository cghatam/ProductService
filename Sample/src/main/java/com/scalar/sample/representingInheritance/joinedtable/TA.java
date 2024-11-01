package com.scalar.sample.representingInheritance.joinedtable;

import com.scalar.sample.representingInheritance.joinedtable.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_ta")
public class TA extends User {
    private int numberOfSessions;
    private double avgRating;
}
