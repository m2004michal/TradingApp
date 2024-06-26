package com.tradingApp.tradingApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int Rating;
    private String opinionMessage;
    @OneToOne
    private UserEntity ratingGiver;
    @OneToOne
    private UserEntity ratingReceiver;
}
