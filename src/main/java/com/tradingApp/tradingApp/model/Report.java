package com.tradingApp.tradingApp.model;

import com.tradingApp.tradingApp.model.Enums.ReportCause;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(optional = false)
    @JoinColumn(name = "reportedByUserEntity_id")
    UserEntity reportedBy;
    @OneToOne(optional = false)
    @JoinColumn(name = "reportedUserEntity_id")
    UserEntity reportedUser;
    private String message;
    @Enumerated(EnumType.STRING)
    private ReportCause cause;




}
