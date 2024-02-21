package com.tradingApp.tradingApp.model;

import com.tradingApp.tradingApp.model.Enums.PaymentOption;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TopUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @OneToOne(optional = false)
    @JoinColumn(name = "userEntity_id")
    private UserEntity userEntity;
    private double amount;
    @Enumerated(EnumType.STRING)
    private PaymentOption paymentOption;
}
