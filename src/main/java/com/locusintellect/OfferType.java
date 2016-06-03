package com.locusintellect;

public enum OfferType {

    BOGOF("Apple"), ThreeForPriceOfTwo("Orange");

    private final String itemOnOffer;

    OfferType(final String itemOnOffer) {
        this.itemOnOffer = itemOnOffer;
    }

    public String getItemOnOffer() {
        return itemOnOffer;
    }

}
