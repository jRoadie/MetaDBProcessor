package com.campus.metadbprocessor

class Action {

    String name
    String description
    Integer overviewID
    Integer serviceID
    String clazz
    String actionParams
    String method
    Short txType = 1
    Boolean isActive = true
    Integer oca = 1

    static mapping = {
        version false
        id column: "ActionID"
    }

    static constraints = {
        overviewID(nullable: true)
        actionParams(nullable: true)
    }

}
