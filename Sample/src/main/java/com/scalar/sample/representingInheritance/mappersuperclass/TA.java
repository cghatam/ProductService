package com.scalar.sample.representingInheritance.mappersuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="msc_ta")
@PrimaryKeyJoinColumn(name="user_id")
public class TA extends User {
    private int numberOfSessions;
    private double avgRating;
}
