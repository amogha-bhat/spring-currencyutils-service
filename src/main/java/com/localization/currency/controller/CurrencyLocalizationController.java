package com.localization.currency.controller;

import com.localization.currency.model.entity.CurrencyLocalizationEntity;
import com.localization.currency.model.response.LocalizationResponseEntity;
import com.localization.currency.service.CurrencyLocalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/currencyUtils/v1")
public class CurrencyLocalizationController {

    @Autowired
    private CurrencyLocalizationService currencyLocalizationService;

    @PostMapping("/format")
    public Map<String, LocalizationResponseEntity<CurrencyLocalizationEntity>> dateUtils(@RequestBody Map<String, CurrencyLocalizationEntity> requests) {
        return currencyLocalizationService.format(requests);
    }
}
