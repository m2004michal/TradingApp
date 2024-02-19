package com.tradingApp.tradingApp.model;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

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
    @JoinColumn(name = "reportedBy_ID")
    UserEntity reportedBy;

    @OneToOne(optional = false)
    @JoinColumn(name = "reportedUser_ID")
    UserEntity reportedUser;

    private String message;

    @Enumerated(EnumType.STRING)
    private ReportCause cause;




}
