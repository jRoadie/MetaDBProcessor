package com.campus.metadbprocessor

class PropertyPool {

    String name
    String description
    Integer overviewID
    String javaType
    String clazzz
    String columnName
    Boolean encrypt
    Boolean required
    String min
    String max
    String pattern
    Integer size
    String options
    //String dfault
    Boolean isActive
    Integer oca

    static mapping = {
        version false
        id column: "propertyPoolID"
    }
}
