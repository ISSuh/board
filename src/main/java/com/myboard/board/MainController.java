package com.myboard.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
  
  @RequestMapping("/board")
  @ResponseBody
  public String index() {
    return "Hello from index";
  }

  @RequestMapping("/")
  public String root() {
    return "redirect:/question/list";
  }
}
