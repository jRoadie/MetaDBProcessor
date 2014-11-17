package com.campus.metadbprocessor

class Domain {

    String name
    String description
    Integer overviewID
    Integer queryID
    Integer constructorID
    String clazz
    String domainParams
    Boolean isTopLevel
    Boolean isActive
    Integer oca

    static mapping = {
        version false
        id column: "DomainID"
    }
}
