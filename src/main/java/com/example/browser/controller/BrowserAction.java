package com.example.browser.controller;

import com.example.browser.BrowserApplication;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.BindException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.jni.Proc;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class BrowserAction {

  @RequestMapping("/")
  public String index() {
    return "Greetings from Spring Boot!";
  }

  @GetMapping("/start")
  @ResponseBody
  public String start(@RequestParam String browser, @RequestParam String url) {
    System.out.println("url is ---->" + url);
    Runtime run = Runtime.getRuntime();
    try {
      if (browser.equalsIgnoreCase("firefox")) run.exec(
        "open -a /Applications/Firefox.app " + url
      ); else run.exec("open " + url);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "Success";
  }

  @RequestMapping(value = "/stop", method = RequestMethod.GET)
  public String stop(@RequestParam String browser) throws IOException {
    Runtime run = Runtime.getRuntime();
    if (browser.equalsIgnoreCase("firefox")) run.exec("killall firefox");
    if (browser.equalsIgnoreCase("chrome")) run.exec("killall Google\\ Chrome");
    return "Success";
  }

  @RequestMapping(value = "/geturl", method = RequestMethod.GET)
  public String geturl(@RequestParam String browser) throws IOException {
    Runtime run = Runtime.getRuntime();
    String output = null;
    if (browser.equalsIgnoreCase("chrome")) {
      Process proc = run.exec("chrome-cli info");
      BufferedReader stdInput = new BufferedReader(
        new InputStreamReader(proc.getInputStream())
      );

      BufferedReader stdError = new BufferedReader(
        new InputStreamReader(proc.getErrorStream())
      );
      String s = null;
      while ((s = stdInput.readLine()) != null) {
        if (s.contains("Url:")) output = s;
      }
    }
    return output;
  }
}
