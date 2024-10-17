package com.ellcoding.demo.question;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuestionController {

    @GetMapping("/questoin/list")
    @ResponseBody
    public String list() {
        return "question list";
    }
}
