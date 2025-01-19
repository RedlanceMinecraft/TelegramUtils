package org.redlance.tgutils.tribute.requester.obj;

public class TributeInvoiceProduct {
    /**
     * Product for which this invoice is intended
     */
    public TributeProduct product;

    // TODO cards

    /**
     * Ability to buy by tg wallet
     */
    public boolean acceptWalletPay;

    /**
     * Ability to buy by tg stars
     */
    public boolean acceptStars;

    /**
     * Whether the product has been purchased
     */
    public boolean isPurchased;

    // TODO invoiceId, invoiceStatus

    public long userId;
    public long webUserId;
    public long botId;
}
