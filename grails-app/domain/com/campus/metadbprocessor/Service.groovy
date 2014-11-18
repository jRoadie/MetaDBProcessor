package com.campus.metadbprocessor

class Service {

    String loader = "ola.module/loader.service"
    String name
    String description = "CRUD Operation"
    Integer overviewID
    String clazz = "com.campus.service.crud.DataProcessor"
    String serviceParams = "{'text':1}"
    Boolean isActive = false
    Integer oca = 1

    static mapping = {
        version false
        id column: "ServiceID"
    }

    static constraints = {
        description(nullable: true)
        overviewID(nullable: true)
    }

}
