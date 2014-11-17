package com.campus.metadbprocessor

class ParamGroup {

    String name
    Integer actionID
    Integer queryID
    Boolean userDefaults
    Integer recTypeID
    Integer joinID
    Integer joinType
    Integer oca

    static mapping = {
        version false
        id column: "ParamGroupID"
    }
}
