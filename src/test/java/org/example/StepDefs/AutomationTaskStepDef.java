package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class AutomationTaskStepDef {
    @Given("Use the search icon to start searching on Nagwa lessons")
    public void start_searching(){
        Hooks.driver.findElement(By.xpath("/html/body/header/div[1]/div/div[3]/button/i")).click();
    }
    @And("Write any lesson name for example “addition” then search")
    public void search_for_addition() throws InterruptedException {
        Hooks.driver.findElement(By.id("txt_search_query")).sendKeys("addition");
        Hooks.driver.findElement(By.id("txt_search_query")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }
    @And("A list with all lessons in Nagwa that match this name will appear")
    public void assert_matching_search_field() throws InterruptedException {
        String expected= "[1-100]";
        String actual= Hooks.driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/main/div[1]/h1")).getText();
        Assert.assertTrue(actual.contains(expected));
        Thread.sleep(2000);
    }
    @And("Click on 2nd lesson in the search results to open its home page")
    public void second_lesson() throws InterruptedException {
        Hooks.driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/main/div[3]/ul/li[2]/div/a")).click();
        Thread.sleep(2000);
    }
    @And("Go to worksheet section then click preview button")
    public void preview_link_click() throws InterruptedException {
        Hooks.driver.findElement(By.xpath("//*[@id=\"WorksheetSection\"]/div/div[2]/div/a")).click();
        Thread.sleep(2000);
    }
    @Then("print the count")
    public void print_count(){
        List<WebElement> links = Hooks.driver.findElements(By.className("inline-displayed"));
        System.out.println("Number of questions and their fields is  " +links.size());
    }
}
