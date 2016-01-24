package it.gabrieletondi.hexagonalbooks.rest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SampleController
{
  @RequestMapping("/")
  @ResponseBody
  public String home()
  {
    return "Hello World!";
  }
}
