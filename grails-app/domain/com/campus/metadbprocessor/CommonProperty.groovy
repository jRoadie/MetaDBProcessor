package com.campus.metadbprocessor

class CommonProperty {

    Integer groupID
    Integer propertyPoolID
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
