package com.wizpanda.paytm

import groovy.transform.CompileStatic

@CompileStatic
enum PaytmTransactionStatus {

    CREDIT_CARD((Byte) 1, "CC"),
    DEBIT_CARD((Byte) 2, "DC"),
    NET_BANKING((Byte) 3, "NB"),
    PAYTM_WALLET((Byte) 4, "PPI"),
    PAYTM_POSTPAID((Byte) 5, "PAYTM_DIGITAL_CREDIT"),
    UPI((Byte) 6, "UPI"),

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


