package com.campus.metadbprocessor

class DataProperty {

    Integer dataInfoID
    Integer propertyPoolID
    Integer parentID
    String reference
    String override
    Integer sortOrder
    Boolean isActive
    Integer oca

    static mapping = {
        version false
        id column: "PropertyInfoID"
    }
}
