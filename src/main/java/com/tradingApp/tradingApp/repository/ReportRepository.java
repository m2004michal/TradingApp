package com.tradingApp.tradingApp.repository;

import com.tradingApp.tradingApp.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
