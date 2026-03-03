package co.istad.wattana.a01a1webmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

//    @RequestMapping()
    @GetMapping("/index/{page}/category/{number}")
    public String viewIndex(@PathVariable String page, @PathVariable Integer number,
                            @RequestParam(required = false,defaultValue = "") String query){
        System.out.println("page: " + page);
        System.out.println("number: " + number);
        System.out.println("query: " + query);
        return "index";
    }
}
