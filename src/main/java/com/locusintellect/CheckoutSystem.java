package com.locusintellect;

import com.locusintellect.offers.Offer;
import com.locusintellect.offers.OfferCalculator;
import com.locusintellect.providers.ItemPriceProvider;

import java.math.BigDecimal;

public class CheckoutSystem {

    private final ItemPriceProvider itemPriceProvider;
    private final OfferCalculator offerCalculator;

    public CheckoutSystem(final ItemPriceProvider itemPriceProvider, final OfferCalculator offerCalculator) {
        this.itemPriceProvider = itemPriceProvider;
        this.offerCalculator = offerCalculator;
    }

    public String checkout(final String[] items, final Offer[] offers) {
        if (items == null || items.length == 0) {
            return "£0";
        }

        BigDecimal amountWithoutOffer = calculateTotalPriceOfItems(items);

        BigDecimal offerPrice = getOfferPriceOnItems(items, offers);

        return "£" + convertPenceToPounds(amountWithoutOffer.add(offerPrice)).toPlainString();
    }

    private BigDecimal getOfferPriceOnItems(final String[] items, Offer[] offers) {
        final BigDecimal[] offerPrices = offerCalculator.calculate(items, offers);
        BigDecimal finalOfferPrice = new BigDecimal(0);

        for (BigDecimal offerPrice : offerPrices) {
            finalOfferPrice = finalOfferPrice.add(offerPrice);
        }
        return finalOfferPrice;
    }

    private BigDecimal calculateTotalPriceOfItems(final String[] items) {
        BigDecimal finalAmount = new BigDecimal(0);

        for (String item : items) {
            if (itemPriceProvider.provideCostInPence(item) != null) {
                finalAmount = finalAmount.add(itemPriceProvider.provideCostInPence(item));
            } else {
                throw new MissingPriceException(String.format("Price missing for item %s", item));
            }
        }
        return finalAmount;
    }

    private BigDecimal convertPenceToPounds(final BigDecimal amountInPence) {
        return amountInPence.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_EVEN);
    }
}
