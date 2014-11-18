package com.campus.metadbprocessor

class CrudController {

    CrudService crudService

    def processAll() {
        String bizObject = params.bizObject
        List<String> operations = ["create", "read", "update", "delete"]
        if(params.operation) {
            operations = [params.operation]
        }
        Service service = crudService.saveService(bizObject, operations)
        /*actions.each {
            crudService."$it"(params.bizObject)
        }*/
        render(view: "/index", model: [:])
    }

    def process() {
        String bizObject = params.bizObject
        List<String> operations = [params.operation]
        Service service = crudService.saveService(bizObject, operations)
        /*actions.each {
            crudService."$it"(params.bizObject)
        }*/
        render(view: "/index", model: [:])
    }
}
