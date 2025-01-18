package org.redlance.tgutils.tribute.requester.obj;

public class TributeWithdrawalAccount {
    public int id;

    /**
     * Creation time
     */
    public long createdAt;

    /**
     * Country
     */
    public String country;

    /**
     * Country in Iso2 format
     */
    public String countryIso2;

    /**
     * Withdrawal method
     * Can be bank_card, etc
     */
    public String methodType;

    /**
     * Currency of withdrawal
     */
    public String currency;

    // TODO taxReference, objectId

    public int userId;
    public boolean isFiatToCrypto;

    // TODO params


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TributeWithdrawalAccount other) {
            return this.id == other.id;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("TributeWithdrawalAccount{id=%s, country=%s, methodType=%s, currency=%s, userId=%s}", this.id, this.country, this.methodType, this.currency, this.userId);
    }
}
