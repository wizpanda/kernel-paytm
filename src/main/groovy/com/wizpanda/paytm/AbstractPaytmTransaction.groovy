package com.wizpanda.paytm

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable
import grails.web.databinding.DataBindingUtils
import org.springframework.transaction.TransactionStatus

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
    TransactionStatus status
    PaytmTransactionType transactionType

    Date transactionDate

    Date dateCreated
    Date lastUpdated

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
