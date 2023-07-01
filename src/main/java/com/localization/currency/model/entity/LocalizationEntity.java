package com.localization.currency.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableLocalizationEntity.class)
public interface LocalizationEntity {
}
