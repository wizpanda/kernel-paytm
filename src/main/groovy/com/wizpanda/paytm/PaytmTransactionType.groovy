package com.wizpanda.paytm

import groovy.transform.CompileStatic

@CompileStatic
enum PaytmTransactionType {

    DEBIT((Byte) 1),
    CREDIT((Byte) 2)

    final Byte id

    PaytmTransactionType(Byte id) {
        this.id = id
    }
}
