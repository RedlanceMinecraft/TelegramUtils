package org.redlance.tgutils.tribute.requester.obj;

import java.util.ArrayList;
import java.util.List;

public class TributeDashboard {
    /**
     * Dashboard mode
     * Can be creator or follower
     */
    public String mode;

    // TODO subscriptionMembers, productPurchases, customProductOrders, subscriptions

    /**
     * Are the terms accepted
     * Present only if {@link TributeDashboard#mode} == creator
     */
    public boolean termsAccepted;

    /**
     * Number of donations (Both sent and received)
     * Present only if {@link TributeDashboard#mode} == creator
     */
    public int donationCount;

    // TODO channels

    /**
     * Purchased/Created Products
     */
    public List<TributeProduct> products = new ArrayList<>();

    /**
     * All transactions
     */
    public List<TributeTransaction> transactions = new ArrayList<>();

    // TODO goals, transactionsNextFrom

    /**
     * Quantities of funds in specific currencies
     * Could be eur, rub, ton, usdt and possibly others
     * Present only if {@link TributeDashboard#mode} == creator
     */
    public List<TributeBalance> balances = new ArrayList<>();

    /**
     * Withdrawal account (one of several)
     * Present only if {@link TributeDashboard#mode} == creator
     */
    public TributeWithdrawalAccount withdrawalAccount;

    /**
     * Present only if {@link TributeDashboard#mode} == creator
     */
    public boolean migrationAvailable;

    /**
     * Identity verification status
     * Could be approved, etc.
     */
    public String verificationStatus;

    /**
     * Ability to receive funds to card
     * Present only if {@link TributeDashboard#mode} == creator
     */
    public boolean acceptCards;

    /**
     * Ability to receive funds to tg wallet
     * Present only if {@link TributeDashboard#mode} == creator
     */
    public boolean acceptWalletPay;

    /**
     * Present only if {@link TributeDashboard#mode} == creator
     */
    public boolean availableReferralOffers;

    public boolean availablePhysicalProducts;

    /**
     * Present only if {@link TributeDashboard#mode} == creator
     */
    public boolean availableManagers;

    /**
     * Present only if {@link TributeDashboard#mode} == creator
     */
    public boolean availableToCreateShowcaseWithoutItems;

    // TODO orders

    /**
     * <a href="https://wiki.tribute.tg/for-content-creators/energy">Tribute Energy</a>
     */
    public int energy;

    /**
     * Present only if {@link TributeDashboard#mode} == creator
     */
    public boolean costCalc;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TributeDashboard other) {
            return this.mode.equals(other.mode);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("TributeDashboard{mode=%s, products=%s, transactions=%s, balances=%s, withdrawalAccount=%s, energy=%s}", this.mode, this.products, this.transactions, this.balances, this.withdrawalAccount, this.energy);
    }
}
