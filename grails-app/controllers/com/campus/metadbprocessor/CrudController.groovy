package com.campus.metadbprocessor

class CrudController {

    def process() {
        println(params)
        render(view: "/index", model: [:])
    }
}
