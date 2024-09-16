package org.order_management_system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private double price;
    private int quantity;


}

