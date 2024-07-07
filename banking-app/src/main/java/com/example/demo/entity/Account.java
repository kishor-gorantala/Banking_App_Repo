package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Table(name="accounts")
@Entity
@AllArgsConstructor
public class Account {

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long id;

        @Column(name="account_holder_name")
        private String accountHolderName;
        private double balance;


        public Account() {

        }
}
