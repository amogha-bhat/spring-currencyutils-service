package com.localization.currency.service;

import com.localization.currency.model.entity.CurrencyLocalizationEntity;
import com.localization.currency.model.response.ImmutableLocalizationResponseEntity;
import com.localization.currency.model.response.LocalizationResponseEntity;
import com.localization.currency.utils.CurrencyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CurrencyLocalizationService {

    @Autowired
    private CurrencyUtils currencyUtils;

    public Map<String, LocalizationResponseEntity<CurrencyLocalizationEntity>> format(Map<String, CurrencyLocalizationEntity> request) {
        return request.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        e2 -> ImmutableLocalizationResponseEntity.<CurrencyLocalizationEntity>builder()
                                .formattedValue(currencyUtils.format(e2.getValue()))
                                .localizationEntity(e2.getValue()).build()));
    }
}
