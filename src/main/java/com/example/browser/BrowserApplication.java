package com.example.browser;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BrowserApplication {

  public static void main(String[] args) {
    System.out.println("Program starting...");

    //		Runtime run = Runtime.getRuntime();
    //		String[] arg = new String[] { "firefox", "http://www.google.com" };
    //		String url = "http://stackoverflow.com";
    //		try {
    //			run.exec("open " + url);
    //		} catch (IOException e) {
    //			e.printStackTrace();
    //		}

    // print the current free memory for this runtime
    //		System.out.println("sdsdsd" + run.freeMemory());
    //		String url = "http://www.google.com";
    //		String os = System.getProperty("os.name").toLowerCase();
    //		Runtime rt = Runtime.getRuntime();
    //
    //		try{
    //
    //			if (os.indexOf( "win" ) >= 0) {
    //
    //				// this doesn't support showing urls in the form of "page.html#nameLink"
    //				rt.exec( "rundll32 url.dll,FileProtocolHandler " + url);
    //
    //			} else if (os.indexOf( "mac" ) >= 0) {
    //
    //				rt.exec( "open " + url);
    //
    //			} else if (os.indexOf( "nix") >=0 || os.indexOf( "nux") >=0) {
    //
    //				// Do a best guess on unix until we get a platform independent way
    //				// Build a list of browsers to try, in this order.
    //				String[] browsers = {"firefox"};
    //
    //				// Build a command string which looks like "browser1 "url" || browser2 "url" ||..."
    //				StringBuffer cmd = new StringBuffer();
    //				for (int i=0; i<browsers.length; i++)
    //					cmd.append( (i==0  ? "" : " || " ) + browsers[i] +" \"" + url + "\" ");
    //
    //				System.out.println(cmd.toString());
    //				rt.exec(new String[] { "sh", "-c", cmd.toString() });
    //
    //			} else {
    //				return;
    //			}
    //		}catch (Exception e){
    //			return;
    //		}

    SpringApplication.run(BrowserApplication.class, args);
  }
}
