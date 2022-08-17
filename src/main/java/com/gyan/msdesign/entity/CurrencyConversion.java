package com.gyan.msdesign.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class CurrencyConversion {
    @NonNull
    private Long id;
    @NonNull
    private String from;
    @NonNull
    private String to;
    @NonNull
    private BigDecimal quantity;
    @NonNull
    private BigDecimal conversionMultiple;
    @NonNull
    private BigDecimal totalCalculatedAmount;
    @NonNull
    private String environment;
}
