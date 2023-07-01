package com.localization.currency.model.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.localization.currency.model.entity.LocalizationEntity;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableLocalizationResponseEntity.class)
public interface LocalizationResponseEntity <T extends LocalizationEntity>{
    String formattedValue();
    T localizationEntity();
}
