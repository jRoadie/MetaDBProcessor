package com.campus.metadbprocessor

class Constructor {

    String name
    String description
    String clazz
    Boolean isActive
    Integer oca

    static mapping = {
        version false
        id column: 'ConstructorID'
    }
}
