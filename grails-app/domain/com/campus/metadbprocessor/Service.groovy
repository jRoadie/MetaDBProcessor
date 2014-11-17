package com.campus.metadbprocessor

class Service {

    String loader
    String name
    String description
    Integer overviewID
    String serviceParams
    Boolean isActive
    Integer oca

    static mapping = {
        version false
        id column: "ServiceID"
    }

}
