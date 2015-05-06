package com.campus.metadbprocessor

class Service {

    String loader
    String name
    String description
    Integer overviewID
    String clazz
    String serviceParams = "{'text':1}"
    Boolean isActive = false
    Integer oca = 1

    static mapping = {
        version false
        id column: "ServiceID"
    }
	/*         */

    static constraints = {
        description(nullable: true)
        overviewID(nullable: true)
    }

}
