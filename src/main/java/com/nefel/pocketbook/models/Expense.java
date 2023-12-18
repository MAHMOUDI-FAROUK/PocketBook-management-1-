package com.nefel.pocketbook.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

@Entity
@Data
@Table
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NonNull
    private String name;
    @NonNull
    String vendor;
    @NonNull
    Float amount;
    @NonNull
    String description;

    public Expense() {

    }
}
