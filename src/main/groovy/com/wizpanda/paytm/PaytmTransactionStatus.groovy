package com.wizpanda.paytm

import groovy.transform.CompileStatic

@CompileStatic
enum PaytmTransactionStatus {

    SUCCESS((Byte) 1, "TXN_SUCCESS"),
    PENDING((Byte) 2, "PENDING"),
    FAILED((Byte) 3, "TXN_FAILURE")

    final Byte id
    final String paytmMapping

    PaytmTransactionStatus(Byte id, String paytmMapping) {
        this.id = id
        this.paytmMapping = paytmMapping
    }

    static PaytmTransactionStatus lookup(String paytmMapping) {
        if (!paytmMapping) {
            return null
        }

        values().find { it.paytmMapping == paytmMapping.toUpperCase() }
    }
}


