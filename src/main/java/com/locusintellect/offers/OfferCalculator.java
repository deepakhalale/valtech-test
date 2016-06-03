package com.locusintellect.offers;

import com.locusintellect.providers.ItemPriceProvider;

import java.math.BigDecimal;

public class OfferCalculator {

    private final ItemPriceProvider itemPriceProvider;

    public OfferCalculator(final ItemPriceProvider itemPriceProvider) {
        this.itemPriceProvider = itemPriceProvider;
    }

    public BigDecimal[] calculate(final String[] items, final Offer[] offers) {
        return new BigDecimal[0];
    }
}
