package org.redlance.tgutils.tribute.requester.obj;

public class TributeTransaction {
    public int id;

    // TODO channelId, donationRequestId

    /**
     * Transaction type
     * Can be send_donation, etc.
     */
    public String type;

    // TODO objectId

    /**
     * Transaction amount
     * In currency {@link TributeTransaction#currency}
     */
    public int amount;

    /**
     * Transaction currency
     */
    public String currency;

    /**
     * Transaction creation time
     */
    public String createdAt;

    /**
     * Method of payment
     * Can be wallet_pay, etc.
     */
    public String paymentMethod;

    /**
     * Payment currency
     */
    public String paymentCurrency;

    /**
     * Amount of money in the currency of payment
     */
    public String paymentAmount;

    /**
     * Total transaction value
     * In currency {@link TributeTransaction#currency}
     */
    public String total;

    /**
     * Amount of <a href="https://wiki.tribute.tg/for-content-creators/energy">Energy</a> charged for this transaction
     */
    public int energy;

    // TODO donation

    /**
     * Donate to whom the transaction belongs
     */
    public TributeDonationRequest donationRequest;


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TributeTransaction other) {
            return this.id == other.id;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("TributeTransaction{type=%s, amount=%s, currency=%s, donationRequest=%s}", this.type, this.amount, this.currency, this.donationRequest);
    }
}
