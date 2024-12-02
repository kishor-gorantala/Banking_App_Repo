package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
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
