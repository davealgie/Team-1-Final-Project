package com.qa.choonz.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RouteContoller {
	
    @GetMapping(value = "/")
    public String index() {
        return "index.html";
    }

    @GetMapping(value = "/home")
    public String home() {
        return "index.html";
    }

    @GetMapping(value = "/tracks")
    public String tracks() {
        return "tracks.html";
    }
    
    
    @GetMapping(value = "/albums")
    public String albums() {
        return "album.html";
    }
    
    @GetMapping(value = "/tracks/read/{trackid}")
    public String trackview(@PathVariable Long trackId ) {
        return "trackview.html";
    }
    
}
