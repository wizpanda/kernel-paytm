package com.wizpanda.paytm

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable
import grails.web.databinding.DataBindingUtils

/**
 * An abstract class which can be extended by any Grails domain class to hold basic data returned from Paytm.
 *
 * @author Shashank Agrawal
 */
//@GrailsCompileStatic
abstract class AbstractPaytmTransaction implements Validateable {

    static constraints = {
        pgName maxSize: 50
        responseCode maxSize: 5
        pgTransactionID maxSize: 64
        bankTransactionID nullable: true, maxSize: 50
        paymentMode nullable: true
        pgName nullable: true
        pgTransactionID nullable: true
        transactionDate nullable: true
    }

    static mapping = {
        status enumType: "identity"
        paymentMode enumType: "identity"
        transactionType enumType: "identity"
        amount updateable: false
        pgName updateable: false
        responseCode updateable: false
        pgTransactionID updateable: false
        paymentMode updateable: false
        transactionType updateable: false
        transactionDate updateable: false
        dateCreated updateable: false
        lastUpdated updateable: false
    }

    BigDecimal amount

    String pgName
    String responseCode
    String pgTransactionID
    String bankTransactionID

    PaytmPaymentMode paymentMode
    PaytmTransactionStatus status
    PaytmTransactionType transactionType

    Date transactionDate

    Date dateCreated
    Date lastUpdated

    boolean isFailed() {
        this.status == PaytmTransactionStatus.FAILED
    }

    boolean isSucceed() {
        this.status == PaytmTransactionStatus.SUCCESS
    }

    @GrailsCompileStatic
    void bindFromPaytmParams(TreeMap<String, String> paytmParams) {
        Map data = [
                amount           : paytmParams.TXNAMOUNT,
                pgName           : paytmParams.GATEWAYNAME,
                responseCode     : paytmParams.RESPCODE,
                pgTransactionID  : paytmParams.TXNID,
                paymentMode      : PaytmPaymentMode.lookup(paytmParams.PAYMENTMODE),
                status           : PaytmTransactionStatus.lookup(paytmParams.STATUS),
                transactionType  : PaytmTransactionType.CREDIT,
                transactionDate  : paytmParams.TXNDATE,
                bankTransactionID: paytmParams.BANKTXNID
        ]

        DataBindingUtils.bindObjectToInstance(this, data)
    }
}
