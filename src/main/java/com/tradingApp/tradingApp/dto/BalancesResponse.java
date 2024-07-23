package com.tradingApp.tradingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BalancesResponse {
    BigDecimal balance;
    BigDecimal escrowBalance;
    BigDecimal securityBalance;
}
