package com.tradingApp.tradingApp.model;

import com.tradingApp.tradingApp.model.Enums.PaymentOption;
import com.tradingApp.tradingApp.model.Enums.TransactionStatus;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    UserEntity userEntity1;
    @OneToOne
    UserEntity userEntity2;
    private Date date;
    private boolean isTrade;
    private boolean isMonetaryTransaction;
    private boolean isUserEntity1Bot;
    private boolean isUserEntity2Bot;
    private StringBuilder chat;
    @Nullable
    @Enumerated(value = EnumType.STRING)
    PaymentOption paymentUsed;
    @Nullable
    @Enumerated(value = EnumType.STRING)
    TransactionStatus transactionStatus;
    @OneToOne
    private Listing listing;


}
