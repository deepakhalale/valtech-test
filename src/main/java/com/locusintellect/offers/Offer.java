package com.locusintellect.offers;

public class Offer {

    private final OfferType offerType;
    private final String item;

    public Offer(final OfferType offerType, final String item) {
        this.offerType = offerType;
        this.item = item;
    }

    public OfferType getOfferType() {
        return offerType;
    }

    public String getItem() {
        return item;
    }
}
