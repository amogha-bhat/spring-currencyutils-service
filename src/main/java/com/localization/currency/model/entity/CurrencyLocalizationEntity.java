package com.localization.currency.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;
import org.springframework.lang.Nullable;

import java.util.Locale;

@Value.Immutable
@JsonDeserialize(as = ImmutableCurrencyLocalizationEntity.class)
public interface CurrencyLocalizationEntity extends LocalizationEntity {
    Double value();
    @Nullable
    String currencyCode();
    Locale locale();
    @Nullable
    Integer fractionDigits();
    @Nullable
    Character groupSeparator();
    @Nullable
    Character decimalSeparator();
}
