package com.wizpanda.paytm

import groovy.transform.CompileStatic

/**
 * Common class to hold additional data which need to be send to payTm for transaction.
 *
 * @author Shashank Agrawal
 */
@CompileStatic
class PaytmAdditionalData {

    String callbackURL
    PaytmPaymentChannel channelID
}
