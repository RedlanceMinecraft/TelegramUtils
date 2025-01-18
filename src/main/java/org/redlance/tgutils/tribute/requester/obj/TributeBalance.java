package org.redlance.tgutils.tribute.requester.obj;

/**
 * Balance in a specific currency
 * @param amount Balance
 * @param currency Сurrency
 */
public record TributeBalance(int amount, String currency) {
}
