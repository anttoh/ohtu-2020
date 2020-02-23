package ohtu;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:4567");

        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akep");
        element = driver.findElement(By.name("login"));
        element.submit();

        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        /////////////////////////////////////////////

        element = driver.findElement(By.linkText("back to home"));
        element.click();

        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        element = driver.findElement(By.linkText("register new user"));
        element.click();

        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        Random r = new Random();
        element = driver.findElement(By.name("username"));
        element.sendKeys("antto" + r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("salasana" + r.nextInt(100000));
        element = driver.findElement(By.name("signup"));
        element.submit();

        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        /////////////////////////////////////////////

        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();

        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        element = driver.findElement(By.linkText("logout"));
        element.click();

        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        driver.quit();
    }

}
