package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private WebDriver driver;
    By edadLocator = By.name("edad");
    By generoLocator = By.name("genero");
    By btnLocator = By.name("btn_consultar");
    By bodySelector = By.cssSelector("body");

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver","C:/Users/Gabriel/Desktop/SegurosAutoPruebas/demo/src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost");
    }

    @Test
    public void testConsultarPrimaAnual() throws InterruptedException
    {
        Thread.sleep(1000);
        driver.findElement(generoLocator).sendKeys("masculino");
        driver.findElement(edadLocator).sendKeys("18");
        driver.findElement(btnLocator).click();
        assertEquals("El valor de la prima anual de seguro de auto según su género y edad es: 2000 dólares", driver.findElement(bodySelector).getText());
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}