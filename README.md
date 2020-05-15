# Kernel Paytm

[ ![Download](https://api.bintray.com/packages/wizpanda/grails-plugins/kernel-paytm/images/download.svg) ](https://bintray.com/wizpanda/grails-plugins/kernel-paytm/_latestVersion)

A simple Grails plugin which provide core functionality and utility for Paytm payment gateway integration. 

## Usage


## Compatibility

Grails Version | Supported
--------- | ---------
3.3.x     |  >= v1.0.0

## Change Log

See [Releases](https://github.com/wizpanda/kernel-paytm/releases) for the changes.

## Installation

### Grails 3

Add the following to `build.gradle` file of your Grails 3 application

**Under `repositories` section**

```groovy
maven { url "http://dl.bintray.com/wizpanda/grails-plugins" }
```

**Under `dependencies` section**

```groovy
compile "com.wizpanda.plugins:kernel-paytm:0.0.1"
```

## Installing locally for development

To develop the plugin locally, you can install this plugin locally and run your app directly. For this, add the following in 
`settings.gradle` of your Grails application:

```groovy
// For inline Kernel plugin development
include ":kernel-paytm"
project(":kernel-paytm").projectDir = new File("../../path/to/kernel-paytm")
```

Then comment the line `compile "com.wizpanda.plugins:kernel-paytm:` from your `build.gradle` and add the line
`compile project (':kernel-paytm')`. That's it.

https://medium.com/wizpanda/another-way-of-adding-local-grails-plugin-to-a-grails-app-using-the-gradle-build-tool-d60ddaf326cb

## Releasing new version

1. Change the version in the `build.gradle`.
2. Make sure Bintray configuration are configured properly as given [here](https://github.com/grails/grails-core/blob/639d7039d24031dbc1353f95b6d2c88a100da850/grails-gradle-plugin/src/main/groovy/org/grails/gradle/plugin/publishing/GrailsCentralPublishGradlePlugin.groovy).
2. Run `gradle bintrayUpload`
