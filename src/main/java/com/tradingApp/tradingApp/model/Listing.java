package com.tradingApp.tradingApp.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private UserEntity userEntity;
    private Date createdDate;
    private BigDecimal price;
    private String description;
    private String title;
    private boolean isForTrade;
    private boolean isForSale;
    private boolean isNegotiable;
    private int quantity;
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

    @OneToMany(mappedBy = "listing", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Photo> photos;
}