package com.campus.metadbprocessor

class ParamProperty {

    Integer paramGroupID
    Integer propertyPoolID
    Integer sortOrder
    Integer parentID
    String reference
    String override
    Boolean isActive
    Integer oca

    static mapping = {
        version false
        id column: "PropertyInfoID"
    }
}
