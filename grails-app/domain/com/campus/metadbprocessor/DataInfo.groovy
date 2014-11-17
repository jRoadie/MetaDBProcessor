package com.campus.metadbprocessor

class DataInfo {

    String name
    String description
    Integer overviewID
    String dataSource
    String dataSequence
    //String table //create this column manually
    String primaryKey
    String autoKey
    Integer recTypeID
    String dataInfoClass
    Boolean isActive
    Integer oca

    static mapping = {
        version false
        id column: 'dataInfoID'
    }
}
