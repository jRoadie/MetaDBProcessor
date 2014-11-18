package com.campus.metadbprocessor

class Query {

    String description
    String dataSource
    String SQL
    String processorClass
    String clazz
    Boolean isActive
    Integer oca

    static mapping = {
        version false
        id column: "QueryID"
    }
}
