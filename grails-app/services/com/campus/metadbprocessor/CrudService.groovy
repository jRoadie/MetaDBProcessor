package com.campus.metadbprocessor

import grails.transaction.Transactional
import groovy.json.JsonSlurper

@Transactional
class CrudService {

    Service saveService(String bizObject, List<String> operations) {
        Map testcases = resolveTestCases(bizObject, operations)
        operations.each { operation ->
            Map testcase = testcases[operation]
            Service service = Service.findByName(testcase.service) ?: new Service()
            service.loader = "ola.module/loader.service"
            service.name = testcase.service
            service.description = "CRUD Operation"
            service.clazz = "com.campus.service.crud.DataProcessor"
            service.serviceParams = "{'dataName': '${bizObject}'}"
            service.save()
        }
        return null
    }

    public Map resolveTestCases(String bizObject, List<String> operations) {
        Map<String, Map> testcases = [:]
        operations.each { String operation ->
            File dir = new File("web-app/testcases/crud/${bizObject.toLowerCase()}")
            File testcase = new File(dir.path + "/${operation}.json")
            if(!dir.exists()) {
                dir.mkdirs()
            }
            if(!testcase.exists()) {
                testcase.createNewFile()
                File template = new File("web-app/testcases/testcase-template.json")
                testcase.withWriter { w ->
                    template.eachLine { line ->
                        if(line.indexOf('${service}') != -1) {
                            w << line.replace('${service}', "ola.api.crud.${bizObject.toLowerCase()}")
                        } else {
                            w << line.replace('${action}', operation)
                        }
                    }
                }
            }
            testcases[operation] = new JsonSlurper().parse(testcase)
        }
        return testcases
    }

    def create(String bizObject) {

    }

    def read() {

    }

    def update() {

    }

    def delete() {

    }

    Set<String> listOfProperies(String bizObject) {
        Set<String> properties = []
        def schema = new XmlSlurper().parse("web-app/bizobjects/${bizObject}.xml")
        schema.methods.method.each {
            if(it.@name == "addProperty") {
                it.list.BOPropertyXML.each {
                    properties.add((String)it.@property)
                }
            }
        }
        return properties
    }
}
