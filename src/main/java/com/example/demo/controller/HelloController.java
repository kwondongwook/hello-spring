package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello-spring")
    public String helloSpring(Model model) {
        model.addAttribute("name", "spring");
        return "hello/hello-spring";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "spring") String name, Model model) {
        model.addAttribute("name", name);
        return "hello/hello";
    }

    @GetMapping("/hello-string")
    @ResponseBody
    public String helloString(@RequestParam(value = "name") String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/hello-json")
    @ResponseBody
    public Hello helloJson(@RequestParam(value = "name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
