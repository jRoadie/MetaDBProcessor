package com.campus.config

import org.hibernate.annotations.common.util.StringHelper
import org.hibernate.cfg.ImprovedNamingStrategy

class DatabaseNamingStrategy extends ImprovedNamingStrategy {

    String classToTableName(String className) {
        "mds_" + className.toLowerCase()
    }

    String propertyToColumnName(String propertyName) {
        if(["oca"].contains(propertyName)) return propertyName
        propertyName = StringHelper.unqualify(propertyName)
        return propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1)
    }
}
