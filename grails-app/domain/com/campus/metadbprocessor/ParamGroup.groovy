package com.campus.metadbprocessor

class ParamGroup {

    String name
    Integer actionID
    Integer queryID
    Boolean userDefaults = false
    Integer recTypeID
    Integer joinID
    Integer joinType
    Integer oca = 1

    static mapping = {
        version false
        id column: "ParamGroupID"
    }

    static constraints = {
        queryID(nullable: true)
        joinID(nullable: true)
    }
}
