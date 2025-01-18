package org.redlance.tgutils.tribute.requester.obj;

public class TributeProduct {
    public int id;

    /**
     * Cost of product
     * In the currency specified in {@link TributeProduct#currency}
     */
    public int amount;

    /**
     * Cost of product in the tg stars
     */
    public int starsAmount;

    /**
     * Indicates whether the price is specified in tg stars
     */
    public boolean starsAmountEnabled;

    /**
     * Automatic price in stars if {@link TributeProduct#starsAmountEnabled} is false
     */
    public int starsAmountConverted;

    /**
     * Currency for {@link TributeProduct#amount}
     */
    public String currency;

    /**
     * Product status.
     * Can be new, etc...
     */
    public String status;

    public boolean isRejected;
    public boolean isDeleted;

    /**
     * Product Name
     */
    public String name;

    /**
     * Product Description
     */
    public String description;

    /**
     * Text on the purchase button
     */
    public String buttonText;

    /**
     * Product Type
     * Can be custom_order, etc...
     */
    public String type;

    public int messageId;

    /**
     * Ability to pay for this product by card
     */
    public boolean acceptCards;

    /**
     * Ability to pay for this product by tg wallet
     */
    public boolean acceptWalletPay;

    /**
     * Payment link via tg vallet
     * In telegram
     */
    public String link;

    /**
     * Payment link via card
     * In www
     */
    public String webLink;

    public int pendingOrders;
    public boolean isCustom;
    public boolean protectContent;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TributeProduct other) {
            return this.id == other.id;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("TributeProduct{name=%s, description=%s, cost=%s, currency=%s}", this.name, this.description, this.amount, this.currency);
    }
}
