package com.tradingApp.tradingApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CATEGORY")
@Getter
@Setter
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name="GAME_CATEGORIES",
            inverseJoinColumns = @JoinColumn(name="GAME_ID", nullable = false),
            joinColumns = {
                    @JoinColumn(name="CATEGORY_ID", nullable = false)
            }
    )
    private Game game;
    @OneToMany
    private List<Listing> listings;

}
