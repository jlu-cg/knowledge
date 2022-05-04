package com.gardener.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchController {

    @PostMapping(path = "/search")
    @ResponseBody
    public String search() {
        return "search";
    }
}
