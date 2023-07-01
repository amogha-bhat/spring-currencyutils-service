package com.localization.currency.utils;

import com.localization.currency.model.entity.CurrencyLocalizationEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.text.*;
import java.util.Currency;

@Component
public class CurrencyUtils {

    private DecimalFormatSymbols getLocalizedSymbols(CurrencyLocalizationEntity currencyLocalizationEntity) {
        DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(currencyLocalizationEntity.locale());
        decimalFormatSymbols.setCurrency(Currency.getInstance(currencyLocalizationEntity.locale()));
        if(StringUtils.isNotBlank(currencyLocalizationEntity.currencyCode()))
            decimalFormatSymbols.setCurrencySymbol(currencyLocalizationEntity.currencyCode());
        if(currencyLocalizationEntity.groupSeparator() != null) {
            decimalFormatSymbols.setGroupingSeparator(currencyLocalizationEntity.groupSeparator());
            decimalFormatSymbols.setMonetaryGroupingSeparator(currencyLocalizationEntity.groupSeparator());
        }
        if(currencyLocalizationEntity.decimalSeparator() != null) {
            decimalFormatSymbols.setDecimalSeparator(currencyLocalizationEntity.decimalSeparator());
            decimalFormatSymbols.setMonetaryDecimalSeparator(currencyLocalizationEntity.decimalSeparator());
        }
        return decimalFormatSymbols;
    }

    public String format(CurrencyLocalizationEntity currencyLocalizationEntity) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getCurrencyInstance(currencyLocalizationEntity.locale());
        decimalFormat.setCurrency(Currency.getInstance(currencyLocalizationEntity.locale()));
        if(currencyLocalizationEntity.fractionDigits() != null) {
            decimalFormat.setMinimumFractionDigits(currencyLocalizationEntity.fractionDigits());
            decimalFormat.setMaximumFractionDigits(currencyLocalizationEntity.fractionDigits());
        }
        decimalFormat.setDecimalFormatSymbols(getLocalizedSymbols(currencyLocalizationEntity));
        return decimalFormat.format(currencyLocalizationEntity.value());
    }

}
