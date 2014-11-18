package com.campus.metadbprocessor

import grails.transaction.Transactional

@Transactional
class CrudService {

    Service saveService(String bizObject, List<String> operations) {
        resolveTestCases(bizObject, operations)
        return null
    }

    public void resolveTestCases(String bizObject, List<String> operations) {
        operations.each { operation ->
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
                            w << line.replace('${service}', "ola.api.${bizObject.toLowerCase()}")
                        } else {
                            w << line.replace('${action}', operation)
                        }
                    }
                }
            }
        }
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
