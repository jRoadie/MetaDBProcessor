package com.campus.config

import org.hibernate.annotations.common.util.StringHelper
import org.hibernate.cfg.ImprovedNamingStrategy

class DatabaseNamingStrategy extends ImprovedNamingStrategy {

    private static current_class_name

    String classToTableName(String className) {
        current_class_name = className
        return "mds_" + className.toLowerCase()
    }

    String propertyToColumnName(String propertyName) {
        if(["oca"].contains(propertyName)) return propertyName
        if(propertyName == "clazz") return "Class"
        if(propertyName == "clazzz") return "class"
        if(propertyName == "dfault") return "default"
        if(["DataInfo", "PropertyPool"].contains(current_class_name)) return propertyName
        propertyName = StringHelper.unqualify(propertyName)
        return propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1)
    }
}
