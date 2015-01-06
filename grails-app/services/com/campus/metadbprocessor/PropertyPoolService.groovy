package com.campus.metadbprocessor

import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.JSONObject

import java.text.SimpleDateFormat

@Transactional
class PropertyPoolService {

    static dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    def save(JSONObject object) {
        object.each {key, val ->
            PropertyPool propertyPool = PropertyPool.findByName(key) ?: new PropertyPool()
            propertyPool.name = key
            propertyPool.description = key
            String javaType = val.getClass().simpleName
            try {
                Date date = dateFormat.parse(val)
                javaType = Date.getSimpleName()
            } catch (Exception e) {

            }
            if(javaType == "Null") {
                javaType = String.getSimpleName()
            }
            if(javaType == "JSONObject") {
                javaType = Map.getSimpleName()
                save(val)
            }
            propertyPool.javaType = javaType
            propertyPool.save()
        }
    }
}
