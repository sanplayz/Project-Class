package com.base;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;

public class BaseClassTest {
public static void main(String[] args) throws InterruptedException, AWTException {
	LibGlobal g=new LibGlobal();
	g.getDriver();
	g.loadUrl("https://www.amazon.in/");
	g.maximize();
	WebElement txtsearch = g.findElementID("twotabsearchtextbox");
	g.sendKeys(txtsearch, "iphone");
	g.enter();
	WebElement findElementXPath = g.findElementXPath("//span[text()='New Apple iPhone 11 (64GB) - Black']");
	g.click(findElementXPath);
	g.switchWindow(1);
	WebElement findElementID = g.findElementID("add-to-cart-button");
	g.click(findElementID);
	g.switchWindow(0);
	WebElement findElementID2 = g.findElementID("twotabsearchtextbox");
	g.sendKeys(findElementID2, "Xr");
	g.enter();
}
}
