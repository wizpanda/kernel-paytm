package com.wizpanda

import grails.plugins.Plugin

class KernelPaytmGrailsPlugin extends Plugin {

    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "3.3.0 > *"

    def profiles = ['web']

    def pluginExcludes = [
            '**/com/wizpanda/UrlMappings*/**'
    ]

    String title = "Kernel Paytm Grails Plugin"
    String author = "Shashank Agrawal"
    String authorEmail = ""
    String description = "A Grails plugin to provide core functionality for Paytm integration"

    // URL to the plugin's documentation
    //String documentation = "http://grails.org/plugin/kernel"

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    //String license = "APACHE"

    Map organization = [name: "Wiz Panda", url: "https://wizpanda.com/"]

    Map issueManagement = [system: "GITHUB", url: "https://github.com/wizpanda/kernel-paytm/issues"]

    Map scm = [url: "https://github.com/wizpanda/kernel-paytm"]
}
