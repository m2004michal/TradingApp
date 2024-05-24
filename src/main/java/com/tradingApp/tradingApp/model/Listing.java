package com.tradingApp.tradingApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private UserEntity userEntity;
    private Date createdDate;
    private double price;
    private String description;
    private String title;
    private boolean isForTrade;
    private boolean isForSale;
    private boolean isNegotiable;
    private int amount;
    private boolean isQuickBuy;
    private int views;
    private boolean isPromoted;
    private String url;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name="CATEGORY_LISTINGS",
            inverseJoinColumns = @JoinColumn(name="CATEGORY_ID", nullable = false),
            joinColumns = {
                    @JoinColumn(name="LISTING_ID", nullable = false)
            }
    )
    private Category category;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "LISTING_PHOTOS",
            joinColumns = @JoinColumn(name = "LISTING_ID", nullable = false),
            inverseJoinColumns = {
                    @JoinColumn(name = "PHOTO_ID", nullable = false)
            }
    )
    private ArrayList<Photo> photos;
}