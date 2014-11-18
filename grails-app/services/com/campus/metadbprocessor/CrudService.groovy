package com.campus.metadbprocessor

import grails.transaction.Transactional
import groovy.json.JsonSlurper

@Transactional
class CrudService {

    public Service saveService(String bizObject, List<String> operations) {
        Map testcases = resolveTestCases(bizObject, operations)
        String serviceName = testcases[operations.first()].service
        Service service = Service.findByName(serviceName) ?: new Service()
        service.loader = "ola.module/loader.service"
        service.name = serviceName
        service.description = "CRUD Operation"
        service.clazz = "com.campus.service.crud.DataProcessor"
        service.serviceParams = "{'dataName': '${bizObject}'}"
        service.save()
        if(!service.hasErrors()) {
            operations.each { operation ->
                Map testcase = testcases[operation]
                saveAction(operation, service)
            }
        }
        return service
    }

    public Action saveAction(String operation, Service service) {
        Action action = Action.findByServiceIDAndMethod(service.id, operation) ?: new Action()
        action.name = operation
        action.description = operation + " " + service.name
        action.serviceID = service.id
        action.clazz = "com.campus.service.RunnableAction"
        action.method = operation
        action.save()
        return action
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
