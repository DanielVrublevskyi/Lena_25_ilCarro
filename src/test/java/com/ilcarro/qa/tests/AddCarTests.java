package com.ilcarro.qa.tests;

import com.ilcarro.qa.model.Car;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddCarTests extends TestBase {
    @BeforeClass
    public void ensurePreconditions() throws InterruptedException {

        if (!app.session().isUserLoggedIn()) {
            app.session().login("zz@zz20.com", "Aa1234567");
        }

    }

    @Test
    public void testFormLetTheCarWork() throws InterruptedException {
//        app.car().addCar();

        app.header().click(By.cssSelector(".header__nav [href='/car']"));

        app.car().fillAddCarForm(new Car()
                .setCountry("Israel")
                .setAddress("Hrtzel 1")
                .setDistance("500")
                .setSerialNumber("12-987-34")
                .setBrand("Honda")
                .setModel("Civic")
                .setYear("2015")
                .setEngine("1.6")
                .setFuelConsumption("6.5")
                .setFuel("petrol")
                .setTransmission("automatic")
                .setWd("2WD")
                .setHorsepower("149")
                .setTorque("240")
                .setDoors("5")
                .setSeats("5")
                .setClasss("C")
                .setAbout("Very good car")
                .setFeature("new one, non smoking, navigator, baby chair")
                .setPrice("55"));
        app.car().submitForm();
    }

//    public void addCar(){
//        click(By.cssSelector(".header__nav [href='/car']"));
//    }
}
