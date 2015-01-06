package com.campus.metadbprocessor

class PropertyPool {

    String name
    String description = ""
    Integer overviewID
    String javaType
    String clazzz = "com.campus.data.impl.BasicProperty"
    String columnName
    Boolean encrypt = false
    Boolean required
    String min
    String max
    String pattern
    Integer size
    String options
    //String dfault
    Boolean isActive = true
    Integer oca = 1

    static constraints = {
        name unique: true
        description nullable: true
        overviewID nullable: true
        columnName nullable: true
        required nullable: true
        min nullable: true
        max nullable: true
        pattern nullable: true
        size nullable: true
        options nullable: true
        //dfault nullable: true
    }

    static mapping = {
        version false
        id column: "propertyPoolID"
        datasource "mds_hir002"
    }
}
