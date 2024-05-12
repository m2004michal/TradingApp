package com.tradingApp.tradingApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GAME")
@Getter
@Setter
@Builder
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "GAME_CATEGORIES",
            joinColumns = @JoinColumn(name = "GAME_ID", nullable = false),
            inverseJoinColumns = {
                    @JoinColumn(name = "CATEGORY_ID", nullable = false)
            }
    )
    private List<Category> categories;


}