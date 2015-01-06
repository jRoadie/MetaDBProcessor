package com.campus.metadbprocessor

import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.JSONObject

class PropertyPoolController {

    PropertyPoolService propertyPoolService

    def index() {
        render(view: "/propertyPool/propertyPool", model: [:])
    }

    def save() {
        JSONObject object = JSON.parse((String)params.propertyObject)
        propertyPoolService.save(object)
        render(view: "/propertyPool/propertyPool", model: [:])
    }
}
