package com.campus.metadbprocessor

class DomainIndex {

    String name
    Integer domainID
    Integer indexID
    String  groupBy
    String bindTo
    Boolean isUniqueIndex
    Boolean isActive
    Integer oca

    static mapping = {
        version false
        id column: "DomainIndexID"
    }
}
