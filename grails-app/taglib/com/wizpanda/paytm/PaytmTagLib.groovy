package com.wizpanda.paytm

import grails.compiler.GrailsCompileStatic

/**
 * Common library class for payTm payment integration gsp page
 *
 * @author Viplav Soni
 */
@GrailsCompileStatic
class PaytmTagLib {

    static namespace = "kernelPaytm"

    def paymentForm = { Map<String, Object> attrs, body ->

        PaytmFormFields formFields = attrs.formFields as PaytmFormFields

        out << """<form method="post" action="${formFields.TRANSACTION_URL}" name="paytmForm">"""

        formFields.hiddenParams.each { String key, String value ->
            out << """<input type="hidden" name="${key}" value="${value}">"""
        }

        out << """<input type="hidden" name="CHECKSUMHASH" value="${formFields.checksum}">"""

        out << """
                </form>
                <script type='text/javascript'>
                    document.paytmForm.submit();
                </script>
        """
    }
}
