import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class SeleniumSetup {

    private static WebDriver driver;

    public static final String beforeCountry = "TP" + java.lang.System.currentTimeMillis() + "@gmail.com";

    public static final String afterCountry = "TP" + java.lang.System.currentTimeMillis() + "@gmail.com";
    public static final String email2 = "TP" + java.lang.System.currentTimeMillis() + "@outlook.com";
    public static final String password = "12345678";

    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-109.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static String navigateTo() {
        driver.get("http://18.156.17.83:9095/");
        return driver.getCurrentUrl();
    }

    public static String registerAsAnEndUser() {

        WebElement registrationFromBtn = driver.findElement(By.xpath("/html/body/div[1]/nav/div[3]/ul/li[3]/a"));
        registrationFromBtn.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement registerMeAsLookingForATransporterBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[1]/button"));
        registerMeAsLookingForATransporterBtn.click();

        Select typeOfUser = new Select(driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[1]/div[2]/select")));
        typeOfUser.selectByVisibleText("Физичко лице");

        WebElement firstNameTxt = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        firstNameTxt.sendKeys("Теодор");

        WebElement lastNameTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[4]/div[2]/input"));
        lastNameTxt.sendKeys("Петровски");

        WebElement addressTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[1]/div[2]/input"));
        addressTxt.sendKeys("Илинденска 35");

        WebElement cityTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[3]/div[2]/input"));
        cityTxt.sendKeys("Битола");

        WebElement postalCodeTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[5]/div[2]/input"));
        postalCodeTxt.sendKeys("7000");

        WebElement countryBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[7]/div[2]/country-selector/div/div[1]/span"));
        countryBtn.click();

        WebElement countryTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[7]/div[2]/country-selector/div/input[1]"));
        countryTxt.sendKeys("Macedonia");
        countryTxt.sendKeys(Keys.ENTER);

        WebElement phoneNumberTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[9]/div[2]/input"));
        phoneNumberTxt.sendKeys("078285449");

        WebElement emailTxt = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailTxt.sendKeys(afterCountry);

        WebElement passwordTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordTxt.sendKeys(password);

        WebElement confirmPasswordTxt = driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]"));
        confirmPasswordTxt.sendKeys("12345678");

        WebElement termsAndConditionsCb = driver.findElement(By.xpath("//*[@id=\"acceptTerms\"]"));
        termsAndConditionsCb.click();

        WebElement registerMeBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[15]/input"));
        registerMeBtn.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement registrationSuccessfulMsg = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/h3"));
        return registrationSuccessfulMsg.getText();
    }

    public static String logInToCargodomAsAnEndUser() {

        WebElement userNameLoginTxt = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        userNameLoginTxt.clear();
        userNameLoginTxt.sendKeys(afterCountry);

        WebElement passwordLoginTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordLoginTxt.clear();
        passwordLoginTxt.sendKeys(password);

        WebElement logMeInBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/form/button"));
        logMeInBtn.click();

        WebElement fullNameLbl = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/div/div/h3"));

        return fullNameLbl.getText();

    }

    public static String sendSupportRequest() {

        WebElement clientSupportBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[6]/a"));
        clientSupportBtn.click();

        WebElement subjectTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div/div/div/div[3]/div[1]/input"));
        subjectTxt.sendKeys("Bugs");

        WebElement subjectBodyTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div/div/div/div[3]/div[2]/textarea"));
        subjectBodyTxt.sendKeys("A bug was found.");

        WebElement sendMsgBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div/div/div/div[3]/button"));
        sendMsgBtn.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement requestSuccessfulMsg = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div/div/div/div[1]/strong"));
        return requestSuccessfulMsg.getText();

    }

    public static String createARequestForm1() {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement createARequestFormBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[3]/a"));
        createARequestFormBtn.click();

        WebElement titleOfTheRequestTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[2]/div[2]/input"));
        titleOfTheRequestTxt.sendKeys("Барам транспортер 1");

        Select categoryType = new Select(driver.findElement(By.xpath("//*[@id=\"field_y\"]")));
        categoryType.selectByVisibleText("Разно");

        WebElement fromAddressTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[4]/div[2]/place-search-field/input"));
        fromAddressTxt.sendKeys("Илинденска 35");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fromAddressTxt.sendKeys(Keys.ARROW_DOWN);
        fromAddressTxt.sendKeys(Keys.ENTER);

        WebElement toAddressTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[5]/div[2]/place-search-field/input"));
        toAddressTxt.sendKeys("Партизанска бб");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        toAddressTxt.sendKeys(Keys.ARROW_DOWN);
        toAddressTxt.sendKeys(Keys.ENTER);

        WebElement lengthTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[10]/div/div[3]/div[2]/div[1]/div/div[2]/input"));
        lengthTxt.sendKeys("150");

        WebElement widthTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[10]/div/div[3]/div[2]/div[2]/div/div[2]/input"));
        widthTxt.sendKeys("100");

        WebElement heightTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[10]/div/div[3]/div[2]/div[3]/div/div[2]/input"));
        heightTxt.sendKeys("50");

        WebElement weightTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[10]/div/div[3]/div[2]/div[4]/div/div[2]/input"));
        weightTxt.sendKeys("10");

        WebElement typeOfPaymentCb = driver.findElement(By.xpath("//*[@id=\"cacheDelivery\"]"));
        typeOfPaymentCb.click();

        WebElement postARequestBtn = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[14]/input"));
        postARequestBtn.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement requestTitleLbl = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div/request-list-pagination/request-list/div[2]/div[2]/table/tbody/tr/td[1]/a"));
        return requestTitleLbl.getText();

    }

    public static String createARequestForm2() {

        WebElement createARequestFormBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[3]/a"));
        createARequestFormBtn.click();

        WebElement titleOfTheRequestTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[2]/div[2]/input"));
        titleOfTheRequestTxt.sendKeys("Барам транспортер 2");

        Select categoryType = new Select(driver.findElement(By.xpath("//*[@id=\"field_y\"]")));
        categoryType.selectByVisibleText("Разно");

        WebElement fromAddressTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[4]/div[2]/place-search-field/input"));
        fromAddressTxt.sendKeys("Скопје");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fromAddressTxt.sendKeys(Keys.ARROW_DOWN);
        fromAddressTxt.sendKeys(Keys.ENTER);

        WebElement toAddressTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[5]/div[2]/place-search-field/input"));
        toAddressTxt.sendKeys("Битола");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        toAddressTxt.sendKeys(Keys.ARROW_DOWN);
        toAddressTxt.sendKeys(Keys.ENTER);

        WebElement lengthTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[10]/div/div[3]/div[2]/div[1]/div/div[2]/input"));
        lengthTxt.sendKeys("30");

        WebElement widthTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[10]/div/div[3]/div[2]/div[2]/div/div[2]/input"));
        widthTxt.sendKeys("15");

        WebElement heightTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[10]/div/div[3]/div[2]/div[3]/div/div[2]/input"));
        heightTxt.sendKeys("10");

        WebElement weightTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[10]/div/div[3]/div[2]/div[4]/div/div[2]/input"));
        weightTxt.sendKeys("5");

        WebElement typeOfPaymentCb = driver.findElement(By.xpath("//*[@id=\"cachePickup\"]"));
        typeOfPaymentCb.click();

        WebElement postARequestBtn = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[14]/input"));
        postARequestBtn.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement requestTitleLbl = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div/request-list-pagination/request-list/div[2]/div[2]/table/tbody/tr[1]/td[1]/a"));
        return requestTitleLbl.getText();
    }

    public static String createARequestForm3() {

        WebElement createARequestFormBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[3]/a"));
        createARequestFormBtn.click();

        WebElement titleOfTheRequestTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[2]/div[2]/input"));
        titleOfTheRequestTxt.sendKeys("Барам транспортер 3");

        Select categoryType = new Select(driver.findElement(By.xpath("//*[@id=\"field_y\"]")));
        categoryType.selectByVisibleText("Автомобил");

        WebElement fromAddressTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[4]/div[2]/place-search-field/input"));
        fromAddressTxt.sendKeys("Битола");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fromAddressTxt.sendKeys(Keys.ARROW_DOWN);
        fromAddressTxt.sendKeys(Keys.ENTER);

        WebElement toAddressTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[5]/div[2]/place-search-field/input"));
        toAddressTxt.sendKeys("Berlin");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        toAddressTxt.sendKeys(Keys.ARROW_DOWN);
        toAddressTxt.sendKeys(Keys.ENTER);

        WebElement manufacturerTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[10]/div[2]/div[2]/div[2]/input"));
        manufacturerTxt.sendKeys("Opel");

        WebElement modelTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[10]/div[2]/div[3]/div[2]/input"));
        modelTxt.sendKeys("Corsa");

        WebElement yearTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[10]/div[2]/div[4]/div[2]/input"));
        yearTxt.sendKeys("2004");

        WebElement typeOfPaymentCb = driver.findElement(By.xpath("//*[@id=\"advance\"]"));
        typeOfPaymentCb.click();

        WebElement postARequestBtn = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[14]/input"));
        postARequestBtn.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement requestTitleLbl = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div/request-list-pagination/request-list/div[2]/div[2]/table/tbody/tr[1]/td[1]/a"));
        return requestTitleLbl.getText();
    }

    public static String registerAsATransporter() {

        WebElement registrationFromBtn = driver.findElement(By.xpath("/html/body/div[1]/nav/div[3]/ul/li[3]/a"));
        registrationFromBtn.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement registerMeAsATransporter = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/button"));
        registerMeAsATransporter.click();

        WebElement firstNameTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[1]/div[2]/input"));
        firstNameTxt.sendKeys("Теодор");

        WebElement lastNameTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[3]/div[2]/input"));
        lastNameTxt.sendKeys("Петровски");

        WebElement companyNameTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[5]/div[2]/input"));
        companyNameTxt.sendKeys("Петро Транс");

        WebElement addressTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[7]/div[2]/input"));
        addressTxt.sendKeys("Илинденска 35");

        WebElement cityTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[9]/div[2]/input"));
        cityTxt.sendKeys("Битола");

        WebElement postalCodeTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[11]/div[2]/input"));
        postalCodeTxt.sendKeys("7000");

        WebElement countryBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[13]/div[2]/country-selector/div/div[1]/span"));
        countryBtn.click();

        WebElement countryTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[13]/div[2]/country-selector/div/input[1]"));
        countryTxt.sendKeys("Macedonia");
        countryTxt.sendKeys(Keys.ENTER);

        WebElement taxNumberTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[15]/div[2]/input"));
        taxNumberTxt.sendKeys("2345900043123");

        WebElement phoneNumberTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[16]/div[2]/input"));
        phoneNumberTxt.sendKeys("078285449");

        WebElement emailTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[2]/div[2]/input"));
        emailTxt.sendKeys(email2);

        WebElement passwordTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordTxt.sendKeys(password);

        WebElement confirmPasswordTxt = driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]"));
        confirmPasswordTxt.sendKeys(password);

        WebElement termsAndConditionsCb = driver.findElement(By.xpath("//*[@id=\"acceptTerms\"]"));
        termsAndConditionsCb.click();

        WebElement registerMeBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[10]/input"));
        registerMeBtn.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement registrationSuccessfulMsg = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/h3"));
        return registrationSuccessfulMsg.getText();
    }

    public static String logInToCargodomAsATransporter() {

        WebElement loginFormBtn = driver.findElement(By.xpath("//*[@id=\"login\"]"));
        loginFormBtn.click();

        WebElement userNameLoginTxt = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        userNameLoginTxt.sendKeys(email2);

        WebElement passwordLoginTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordLoginTxt.sendKeys(password);

        WebElement logMeInBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/form/button"));
        logMeInBtn.click();

        WebElement fullNameLbl = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/div/div/h3"));

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return fullNameLbl.getText();

    }

    public static String findRequest() {

        WebElement fromCountryBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/request-search-list/div[1]/div[2]/request-search/div/div/div[2]/div[1]/div/div[1]/country-selector/div/div[1]/span"));
        fromCountryBtn.click();

        WebElement fromCountryTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/request-search-list/div[1]/div[2]/request-search/div/div/div[2]/div[1]/div/div[1]/country-selector/div/input[1]"));
        fromCountryTxt.sendKeys("Macedonia");
        fromCountryTxt.sendKeys(Keys.ENTER);

        WebElement toCountryBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/request-search-list/div[1]/div[2]/request-search/div/div/div[2]/div[1]/div/div[2]/country-selector/div/div[1]/span"));
        toCountryBtn.click();

        WebElement toCountryTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/request-search-list/div[1]/div[2]/request-search/div/div/div[2]/div[1]/div/div[2]/country-selector/div/input[1]"));
        toCountryTxt.sendKeys("Macedonia");
        toCountryTxt.sendKeys(Keys.ENTER);

        Select category = new Select(driver.findElement(By.xpath("//*[@id=\"field_y\"]")));
        category.selectByVisibleText("Разно");

        WebElement searchBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/request-search-list/div[1]/div[2]/request-search/div/div/div[3]/a"));
        searchBtn.click();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement categoryLbl = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/request-search-list/div[2]/request-list/div[2]/div[2]/table/tbody/tr[1]/td[5]/div/span"));
        return categoryLbl.getText();
    }

    public static String sendOffer() {

        WebElement titleOfTheRequestBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/request-search-list/div[2]/request-list/div[2]/div[2]/table/tbody/tr[1]/td[1]"));
        titleOfTheRequestBtn.click();

        WebElement createOfferBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div/button"));
        createOfferBtn.click();

        WebElement priceTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/form/div/div[2]/div[2]/table/tbody/tr/td[5]/input"));
        priceTxt.sendKeys("4000");

        WebElement offerIsValidUntilTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/form/div/div[4]/div/div[1]/div[3]/input"));
        offerIsValidUntilTxt.sendKeys("30.09.2022 00:00");

        WebElement createOfferBtn1 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/form/div/div[5]/button"));
        createOfferBtn1.click();

        WebElement confirmCreateOfferBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/button[1]"));
        confirmCreateOfferBtn.click();

        WebElement editOfferBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div/button[1]"));
        return editOfferBtn.getText();
    }

    public static String logInWithValidEmailAndInvalidPassword() {

        WebElement userNameLoginTxt = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        userNameLoginTxt.clear();
        userNameLoginTxt.sendKeys(beforeCountry);

        WebElement passwordLoginTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordLoginTxt.clear();
        passwordLoginTxt.sendKeys("greshenpassword");

        WebElement logMeInBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/form/button"));
        logMeInBtn.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement logInValidationMsg = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div"));
        return logInValidationMsg.getText();
    }

    public static String logInWithNotRegisteredEmail() {

        WebElement loginFormBtn = driver.findElement(By.xpath("//*[@id=\"login\"]"));
        loginFormBtn.click();

        WebElement userNameLoginTxt = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        userNameLoginTxt.clear();
        userNameLoginTxt.sendKeys("teo123@gmail.com");

        WebElement passwordLoginTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordLoginTxt.clear();
        passwordLoginTxt.sendKeys(password);

        WebElement logMeInBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/form/button"));
        logMeInBtn.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement logInValidationMsg = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div"));

        return logInValidationMsg.getText();
    }

    public static String logInWithBothEmailAndPasswordBlank() {

        WebElement userNameLoginTxt = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        userNameLoginTxt.clear();
        userNameLoginTxt.sendKeys("");

        WebElement passwordLoginTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordLoginTxt.clear();
        passwordLoginTxt.sendKeys("");

        WebElement logMeInBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/form/button"));
        logMeInBtn.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement logInValidationMsg = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div"));

        return logInValidationMsg.getText();
    }

    public static String logInWithInvalidEmailAddress() {

        WebElement userNameLoginTxt = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        userNameLoginTxt.clear();
        userNameLoginTxt.sendKeys("teo123");

        WebElement passwordLoginTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordLoginTxt.clear();
        passwordLoginTxt.sendKeys(password);

        WebElement logMeInBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/form/button"));
        logMeInBtn.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement logInValidationMsg = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div"));

        return logInValidationMsg.getText();
    }

    public static String validationMessages(String inputField, String firstName, String lastName, String address, String city, String postalCode, String country, String phoneNumber, String email, String password, String confirmPassword, String typeOfUser, String clickCheckbox) {

        WebElement registrationFromBtn = driver.findElement(By.xpath("/html/body/div[1]/nav/div[3]/ul/li[3]/a"));
        registrationFromBtn.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement registerMeAsLookingForATransporterBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[1]/button"));
        registerMeAsLookingForATransporterBtn.click();

        Select typeOfUser1 = new Select(driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[1]/div[2]/select")));
        typeOfUser1.selectByVisibleText(typeOfUser);

        WebElement firstNameTxt = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        firstNameTxt.sendKeys(firstName);

        WebElement lastNameTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[4]/div[2]/input"));
        lastNameTxt.sendKeys(lastName);

        WebElement addressTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[1]/div[2]/input"));
        addressTxt.sendKeys(address);

        WebElement cityTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[3]/div[2]/input"));
        cityTxt.sendKeys(city);

        WebElement postalCodeTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[5]/div[2]/input"));
        postalCodeTxt.sendKeys(postalCode);

        WebElement countryBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[7]/div[2]/country-selector/div/div[1]/span"));
        countryBtn.click();

        WebElement countryTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[7]/div[2]/country-selector/div/input[1]"));
        countryTxt.sendKeys(country);
        countryTxt.sendKeys(Keys.ENTER);

        WebElement phoneNumberTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[9]/div[2]/input"));
        phoneNumberTxt.sendKeys(phoneNumber);

        WebElement emailTxt = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailTxt.sendKeys(email);

        WebElement passwordTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordTxt.sendKeys(password);

        WebElement confirmPasswordTxt = driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]"));
        confirmPasswordTxt.sendKeys(confirmPassword);

        WebElement termsAndConditionsCb = driver.findElement(By.xpath("//*[@id=\"acceptTerms\"]"));

        if (Objects.equals(clickCheckbox, "click")) {
            termsAndConditionsCb.click();
        }

        WebElement registerMeBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[15]/input"));
        registerMeBtn.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebElement countryErrorMsg = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[8]/div/p"));
        WebElement firstNameErrorMsg = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[3]/div/p"));
        WebElement lastNameErrorMsg = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[5]/div/p"));
        WebElement addressErrorMsg = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[2]/div/p"));
        WebElement cityErrorMsg = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[4]/div/p"));
        WebElement postalCodeErrorMsg = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[6]/div/p"));
        WebElement phoneNumberErrorMsg = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[10]/div/p"));
        WebElement emailErrorMsg = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[8]/div/p[1]"));
        WebElement passwordErrorMsg = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[10]/div/p[1]"));
        WebElement confirmPasswordErrorMsg = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[12]/div/p[1]"));
        WebElement termsAndConditionsCbErrorMsg = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[14]/div/p"));
        WebElement registrationFormErrorMsg = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[15]/div/p"));
        WebElement invalidEmailErrorMsg = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[8]/div/p[2]"));
        WebElement emailBoundaryShort = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[8]/div/p[3]"));
        WebElement emailBoundaryLong = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[8]/div/p[4]"));
        WebElement passwordBoundaryShort = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[10]/div/p[2]"));
        WebElement passwordBoundaryLong = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[10]/div/p[3]"));
        WebElement confirmPasswordBoundary = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[12]/div/p[2]"));
        WebElement confirmPasswordNotMatchedErrorMsg = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[1]/div[5]"));
        WebElement checkboxNotTickedErrorMsg = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[14]/div/p"));


        String errorMsg;

        switch (inputField) {
            case "emptyCountry", "invalidCountry" -> errorMsg = driver.getCurrentUrl();
            case "endUserLbl" -> errorMsg = typeOfUser1.getFirstSelectedOption().getText();
            case "emptyFirstName" -> errorMsg = firstNameErrorMsg.getText();
            case "emptyLastName" -> errorMsg = lastNameErrorMsg.getText();
            case "emptyAddress" -> errorMsg = addressErrorMsg.getText();
            case "emptyCity" -> errorMsg = cityErrorMsg.getText();
            case "emptyPostalCode" -> errorMsg = postalCodeErrorMsg.getText();
            case "emptyPhoneNumber" -> errorMsg = phoneNumberErrorMsg.getText();
            case "emptyEmail" -> errorMsg = emailErrorMsg.getText();
            case "emptyPassword" -> errorMsg = passwordErrorMsg.getText();
            case "emptyConfirmPassword" -> errorMsg = confirmPasswordErrorMsg.getText();
            case "emptyTermsAndConditions" -> errorMsg = termsAndConditionsCbErrorMsg.getText();
            case "registrationForm", "invalidFirstName", "invalidLastName", "invalidAddress", "invalidCity", "invalidPostalCode", "invalidPhoneNumber" ->
                    errorMsg = registrationFormErrorMsg.getText();
            case "invalidEmail" -> errorMsg = invalidEmailErrorMsg.getText();
            case "boundaryEmailShort" -> errorMsg = emailBoundaryShort.getText();
            case "boundaryEmailLong" -> errorMsg = emailBoundaryLong.getText();
            case "boundaryPasswordShort" -> errorMsg = passwordBoundaryShort.getText();
            case "boundaryPasswordLong" -> errorMsg = passwordBoundaryLong.getText();
            case "boundaryConfirmPassword" -> errorMsg = confirmPasswordBoundary.getText();
            case "confirmPasswordNotMatching" -> errorMsg = confirmPasswordNotMatchedErrorMsg.getText();
            case "checkBoxNotTicked" -> errorMsg = checkboxNotTickedErrorMsg.getText();
            default -> throw new IllegalStateException("Unexpected value: " + inputField);
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return errorMsg;
    }

    public static String countryInputField(){

        WebElement registrationFromBtn = driver.findElement(By.xpath("/html/body/div[1]/nav/div[3]/ul/li[3]/a"));
        registrationFromBtn.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement registerMeAsLookingForATransporterBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[1]/button"));
        registerMeAsLookingForATransporterBtn.click();

        Select typeOfUser = new Select(driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[1]/div[2]/select")));
        typeOfUser.selectByVisibleText("Физичко лице");

        WebElement firstNameTxt = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        firstNameTxt.sendKeys("Теодор");

        WebElement lastNameTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[4]/div[2]/input"));
        lastNameTxt.sendKeys("Петровски");

        WebElement addressTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[1]/div[2]/input"));
        addressTxt.sendKeys("Илинденска 35");

        WebElement cityTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[3]/div[2]/input"));
        cityTxt.sendKeys("Битола");

        WebElement postalCodeTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[5]/div[2]/input"));
        postalCodeTxt.sendKeys("7000");

        WebElement countryBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[7]/div[2]/country-selector/div/div[1]/span"));
        countryBtn.click();

        WebElement countryTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[7]/div[2]/country-selector/div/input[1]"));
        countryTxt.sendKeys("Битола");
        countryTxt.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement phoneNumberTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[9]/div[2]/input"));
        phoneNumberTxt.sendKeys("078285449");

        WebElement emailTxt = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailTxt.sendKeys(beforeCountry);

        WebElement passwordTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordTxt.sendKeys(password);

        WebElement confirmPasswordTxt = driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]"));
        confirmPasswordTxt.sendKeys("12345678");

        WebElement termsAndConditionsCb = driver.findElement(By.xpath("//*[@id=\"acceptTerms\"]"));
        termsAndConditionsCb.click();

        WebElement registerMeBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[15]/input"));
        registerMeBtn.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return driver.getCurrentUrl();
    }

    public static boolean cannotSubmitARequestWithoutTitle() {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement createARequestFormBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[3]/a"));
        createARequestFormBtn.click();

        WebElement inputField = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[2]/div[2]/input"));

        WebElement postARequestBtn = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[13]/input"));
        postARequestBtn.click();

        return inputField.getText().isBlank();
    }

    public static String requestValidationMsgForRequiredField() {

        WebElement createARequestFormBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[3]/a"));
        createARequestFormBtn.click();

        WebElement postARequestBtn = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[13]/input"));
        postARequestBtn.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[2]/div[3]/p"));

        return errorMsg.getText();
    }


    public static String signOut() {
        WebElement signMeOutBtn = driver.findElement(By.xpath("//*[@id=\"logout2\"]"));
        signMeOutBtn.click();

        return driver.getCurrentUrl();
    }

    public static void end() {
        driver.quit();
    }
}

