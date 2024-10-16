package com.tradingApp.tradingApp.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String filePath;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name="LISTING_PHOTOS",
            inverseJoinColumns = @JoinColumn(name="LISTING_ID", nullable = false),
            joinColumns = {
                    @JoinColumn(name="PHOTO_ID", nullable = false)
            }
    )
    private Listing listing;
}
