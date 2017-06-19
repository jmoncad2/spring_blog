package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @RequestMapping(path = "/add/{number}/and/{secondNumber}", method = RequestMethod.GET)
    @ResponseBody
    public String addNumber(@PathVariable int number, @PathVariable int secondNumber) {
        return number + " plus " + secondNumber + " equals = " + (number + secondNumber);
    }

    @RequestMapping(path = "/subtract/{number}/from/{secondNumber}", method = RequestMethod.GET)
    @ResponseBody
    public String subtractNumber(@PathVariable int number, @PathVariable int secondNumber) {
        return secondNumber + " minus " + number + " equals = " + (secondNumber - number);
    }

    @RequestMapping(path = "/multiply/{number}/and/{secondNumber}", method = RequestMethod.GET)
    @ResponseBody
    public String multiplyNumber(@PathVariable int number, @PathVariable int secondNumber) {
        return number + " multiply by " + secondNumber + " equals = " + (secondNumber * number);
    }

    @RequestMapping(path = "/divide/{number}/by/{secondNumber}", method = RequestMethod.GET)
    @ResponseBody
    public String divideNumber(@PathVariable int number, @PathVariable int secondNumber) {
        return number + " divide by " + secondNumber + " equals = " + (number / secondNumber);
    }

    @RequestMapping(path = "/posts{post}", method = RequestMethod.GET)
    @ResponseBody
    public String posts(@PathVariable String post) {
        return post.replaceAll("", "posts index page");
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String postsId(@PathVariable int id) {
        return "Individual post id is " + id;
    }
}
