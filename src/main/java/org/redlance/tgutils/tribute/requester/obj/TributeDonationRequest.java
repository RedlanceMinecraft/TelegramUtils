package org.redlance.tgutils.tribute.requester.obj;

public class TributeDonationRequest {
    public int id;

    // TODO channelId, amount

    /**
     * Minimum donation amount
     */
    public int minAmount;

    /**
     * Donation currency
     */
    public String currency;

    /**
     * Donation Title
     */
    public String title;

    /**
     * Donation description
     */
    public String description;

    /**
     * Text on the donate button
     */
    public String buttonText;

    /**
     * See {@link TributeImage#id()}
     */
    public int imageId;

    /**
     * Custom donation cover
     */
    public TributeImage image;

    /**
     * Whether the custom cover is set
     */
    public boolean customCover;

    /**
     * Donate link
     * In telegram
     */
    public String link;

    /**
     * Ability to donate by card
     */
    public boolean acceptCards;

    /**
     * Ability to donate by tg wallet
     */
    public boolean acceptWalletPay;

    /**
     * Ability to donate by tg stars
     */
    public boolean acceptStars;

    public boolean isDeleted;
    public boolean isNewDonationRequest;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TributeDonationRequest other) {
            return this.id == other.id;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("TributeDonationRequest{minAmount=%s, currency=%s, title=%s, description=%s, image=%s}", this.minAmount, this.currency, this.title, this.description, this.image);
    }
}
