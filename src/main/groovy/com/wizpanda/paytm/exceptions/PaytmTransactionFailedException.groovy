package com.wizpanda.paytm.exceptions

import com.wizpanda.paytm.AbstractPaytmTransaction
import groovy.transform.CompileStatic

/**
 *
 * @author Shashank Agrawal
 */
@CompileStatic
class PaytmTransactionFailedException extends RuntimeException {

    AbstractPaytmTransaction transaction

    PaytmTransactionFailedException(String message, AbstractPaytmTransaction transaction = null) {
        super(message)
        this.transaction = transaction
    }
}
