class UrlMappings {

	static mappings = {
        "/crud/$bizObject"(controller: "crud", action: "processAll")
        "/crud/$bizObject/$operation"(controller: "crud", action: "process")
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
