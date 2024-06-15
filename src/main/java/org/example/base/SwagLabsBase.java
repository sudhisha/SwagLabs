package org.example.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class SwagLabsBase {
    public static WebDriver driver=null;
    public void setUp(){
        Path extensionPath = Paths.get(".\\src\\main\\java\\org\\example\\uBlock0.chromium");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("load-extension=" + extensionPath.toAbsolutePath().toString());
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void tearDown(){
//        driver.quit();
    }
}
