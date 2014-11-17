package com.campus.metadbprocessor

class Action {

    String name
    String description
    Integer overviewID
    Integer serviceID
    String clazz
    String actionParams
    String method
    Short txType
    Boolean isActive
    Integer oca

    static mapping = {
        version false
        id column: "ActionID"
    }

}
