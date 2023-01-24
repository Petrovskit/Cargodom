import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTests {

    @BeforeClass
    public void beforeClass() {
        SeleniumSetup.setup();
    }


    @Test(priority = -100, description = "Verify that the user is navigated to the Cargodom home page.", enabled = true)
    public void testForVerifyingUserReachedHomePage() {
        Assert.assertEquals(SeleniumSetup.navigateTo(), "http://18.156.17.83:9095/");
    }

    @Test(priority = 20, description = "Verify that the user cannot login with an email that has not been registered before.", enabled = true)
    public void testForVerifyingLoginErrorMsgWithInvalidEmail() {
        Assert.assertEquals(SeleniumSetup.logInWithNotRegisteredEmail(), "Вашиот обид е неуспешен! Ве молиме проверете го вашето корисничко име и лозинка и обидете се повторно.");
    }

    @Test(priority = 21, description = "Verify that the user cannot login with invalid password.", enabled = true)
    public void testForVerifyingLoginErrorMsgWithInvalidPassword() {
        Assert.assertEquals(SeleniumSetup.logInWithValidEmailAndInvalidPassword(), "Вашиот обид е неуспешен! Ве молиме проверете го вашето корисничко име и лозинка и обидете се повторно.");
    }

    @Test(priority = 22, description = "Verify that the user cannot login with both required fields left blank.", enabled = true)
    public void testForVerifyingLoginErrorMsgWithBothFieldsBlank() {
        Assert.assertEquals(SeleniumSetup.logInWithBothEmailAndPasswordBlank(), "Вашиот обид е неуспешен! Ве молиме проверете го вашето корисничко име и лозинка и обидете се повторно.");
    }

    @Test(priority = 23, description = "Verify that the user cannot login with mail that is not valid.", enabled = true)
    public void testForVerifyingLoginWithInvalidEmailAddress() {
        Assert.assertEquals(SeleniumSetup.logInWithInvalidEmailAddress(), "Вашиот обид е неуспешен! Ве молиме проверете го вашето корисничко име и лозинка и обидете се повторно.");
    }

    @Test(priority = 19, description = "Verify that the registration as an End user was successful.", enabled = true)
    public void testForVerifyingEndUserIsSuccessfullyRegistered() {
        Assert.assertEquals(SeleniumSetup.registerAsAnEndUser(), "Вашиот профил е успешно креиран! Ве молиме проверете го Вашиот e-mail за да ја завршите регистрацијата.");
    }

    @Test(priority = 24, description = "Verify that the user has logged in successfully.", enabled = true)
    public void testForVerifyingEndUserIsSuccessfullyLoggedIn() {
        Assert.assertEquals(SeleniumSetup.logInToCargodomAsAnEndUser(), "Теодор Петровски");
    }

    @Test(priority = 25, description = "Verify that the request/question is successfully sent.", enabled = true)
    public void testForVerifyingSupportRequestIsSentSuccessful() {
        Assert.assertEquals(SeleniumSetup.sendSupportRequest(), "Вашиот меил е успешно испратен до одделот за корисничка поддршка!");
    }

    @Test(priority = 26, description = "Verify that the request cannot be submitted when title of the request is empty.", enabled = true)
    public void testForVerifyingRequestCannotBeSubmittedWithoutTitle() {
        Assert.assertTrue(SeleniumSetup.cannotSubmitARequestWithoutTitle());
    }

    @Test(priority = 27, description = "Verify that validation message is shown when required field is left empty when creating a request.", enabled = true)
    public void testForVerifyingRequestsValidationMsgWhenFieldIsLeftEmpty() {
        Assert.assertEquals(SeleniumSetup.requestValidationMsgForRequiredField(), "Ова поле е задолжително.");
    }

    @Test(priority = 28, description = "Verify that the first request is submitted.", enabled = true)
    public void testForVerifyingFirstRequestIsSubmitted() {
        Assert.assertEquals(SeleniumSetup.createARequestForm1(), "Барам транспортер 1");
    }

    @Test(priority = 29, description = "Verify that the second request is submitted.", enabled = true)
    public void testForVerifyingSecondRequestIsSubmitted() {
        Assert.assertEquals(SeleniumSetup.createARequestForm2(), "Барам транспортер 2");
    }

    @Test(priority = 30, description = "Verify that the third request is submitted.", enabled = true)
    public void testForVerifyingThirdRequestIsSubmitted() {
        Assert.assertEquals(SeleniumSetup.createARequestForm3(), "Барам транспортер 3");
    }

    @Test(priority = 31, description = "Verify that the user has signed out successfully.", enabled = true)
    public void testForVerifyingUserSignedOutSuccessfully() {
        Assert.assertEquals(SeleniumSetup.signOut(), "http://18.156.17.83:9095/");
    }

    @Test(priority = 32, description = "Verify that the registration as a Transporter was successful.", enabled = true)
    public void testForVerifyingTransporterIsSuccessfullyRegistered() {
        Assert.assertEquals(SeleniumSetup.registerAsATransporter(), "Вашиот профил е успешно креиран! Ве молиме проверете го Вашиот e-mail за да ја завршите регистрацијата.");
    }

    @Test(priority = 33, description = "Verify that the user had logged in successfully.", enabled = true)
    public void testForVerifyingEndUserIsSuccessfullyLoggedIn1() {
        Assert.assertEquals(SeleniumSetup.logInToCargodomAsATransporter(), "Теодор Петровски");
    }

    @Test(priority = 34, description = "Verify that the user has found a request.", enabled = true)
    public void testForVerifyingARequestWasFound() {
        Assert.assertEquals(SeleniumSetup.findRequest(), "Разно");
    }

    @Test(priority = 35, description = "Verify that the user has submitted the offer", enabled = true)
    public void testForVerifyingAnOfferWasSubmittedSuccessfully() {
        Assert.assertEquals(SeleniumSetup.sendOffer(), "ИЗМЕНИ ЈА ПОНУДАТА");
    }

    @Test(priority = 1, description = "Verify that the user has selected to register as an End User instead of as a Company.", enabled = true)
    public void testForVerifyingThatTheRegistrationFormIsForEndUser() {
        Assert.assertEquals(SeleniumSetup.validationMessages("endUserLbl", "Теодор", "Петровски", "Илинденска 35", "Битола", "", "Macedonia", "078285449", SeleniumSetup.beforeCountry, SeleniumSetup.password, SeleniumSetup.password, "Физичко лице", "click"), "Физичко лице");
    }

    @Test(priority = 2, description = "Verify that validation message is shown when Last Name input field is left empty.", enabled = true)
    public void testForVerifyingValidationMsgWhenLastNameFieldIsLeftEmpty() {
        Assert.assertEquals(SeleniumSetup.validationMessages("emptyLastName", "Теодор", "", "Илинденска 35", "Битола", "7000", "Macedonia", "078285449", SeleniumSetup.beforeCountry, SeleniumSetup.password, SeleniumSetup.password, "Физичко лице", "click"), "Ова поле е задолжително.");
    }

    @Test(priority = 3, description = "Verify that validation message is shown when Phone Number input field is left empty.", enabled = true)
    public void testForVerifyingValidationMsgWhenCountryFieldIsLeftEmpty() {
        Assert.assertEquals(SeleniumSetup.validationMessages("emptyPhoneNumber", "Теодор", "Петровски", "Илинденска 35", "Битола", "7000", "Macedonia", "", SeleniumSetup.beforeCountry, SeleniumSetup.password, SeleniumSetup.password, "Физичко лице", "click"), "Ова поле е задолжително.");
    }

    @Test(priority = 4, description = "Verify that validation message is shown when Email input field is left empty.", enabled = true)
    public void testForVerifyingValidationMsgWhenEmailFieldIsLeftEmpty() {
        Assert.assertEquals(SeleniumSetup.validationMessages("emptyEmail", "Теодор", "Петровски", "Илинденска 35", "Битола", "7000", "Macedonia", "078285449", "", SeleniumSetup.password, SeleniumSetup.password, "Физичко лице", "click"), "Задолжително внесете ваш e-mail.");
    }

    @Test(priority = 5, description = "Verify that validation message is shown when Password input field is left empty.", enabled = true)
    public void testForVerifyingValidationMsgWhenPasswordFieldIsLeftEmpty() {
        Assert.assertEquals(SeleniumSetup.validationMessages("emptyPassword", "Теодор", "Петровски", "Илинденска 35", "Битола", "7000", "Macedonia", "078285449", SeleniumSetup.beforeCountry, "", SeleniumSetup.password, "Физичко лице", "click"), "Задолжително внесете лозинка");
    }

    @Test(priority = 6, description = "Verify that validation message is shown when Confirm Password input field is left empty.", enabled = true)
    public void testForVerifyingValidationMsgWhenConfirmPasswordFieldIsLeftEmpty() {
        Assert.assertEquals(SeleniumSetup.validationMessages("emptyConfirmPassword", "Теодор", "Петровски", "Илинденска 35", "Битола", "7000", "Macedonia", "078285449", SeleniumSetup.beforeCountry, SeleniumSetup.password, "", "Физичко лице", "click"), "Задолжително потврдете ја лозинката.");
    }

    @Test(priority = 7, description = "Verify that validation message is shown when invalid data is entered in First Name input field.(@@)-entered data", enabled = true)
    public void testForVerifyingValidationMsgWhenInvalidDataIsEnteredInFirstNameField() {
        Assert.assertEquals(SeleniumSetup.validationMessages("invalidFirstName", "@@", "Петровски", "Илинденска 35", "Битола", "7000", "Macedonia", "078285449", SeleniumSetup.beforeCountry, SeleniumSetup.password, SeleniumSetup.password, "Физичко лице", "click"), "Ве молиме пополнете ги сите задолжителни полиња!");
    }

    @Test(priority = 8, description = "Verify that validation message is shown when invalid data is entered in Last Name input field.(12)-entered data", enabled = true)
    public void testForVerifyingValidationMsgWhenInvalidDataIsEnteredInLastNameField() {
        Assert.assertEquals(SeleniumSetup.validationMessages("invalidLastName", "Теодор", "12", "Илинденска 35", "Битола", "7000", "Macedonia", "078285449", SeleniumSetup.beforeCountry, SeleniumSetup.password, SeleniumSetup.password, "Физичко лице", "click"), "Ве молиме пополнете ги сите задолжителни полиња!");
    }

    @Test(priority = 9, description = "Verify that validation message is shown when invalid data is entered in Address input field.(     35       )-entered data", enabled = true)
    public void testForVerifyingValidationMsgWhenInvalidDataIsEnteredInAddressField() {
        Assert.assertEquals(SeleniumSetup.validationMessages("invalidAddress", "Теодор", "Петровски", "     35       ", "Битола", "7000", "Macedonia", "078285449", SeleniumSetup.beforeCountry, SeleniumSetup.password, SeleniumSetup.password, "Физичко лице", "click"), "Ве молиме пополнете ги сите задолжителни полиња!");
    }

    @Test(priority = 10, description = "Verify that validation message is shown when invalid data is entered in City input field.(Б)-entered data", enabled = true)
    public void testForVerifyingValidationMsgWhenInvalidDataIsEnteredInCityField() {
        Assert.assertEquals(SeleniumSetup.validationMessages("invalidCity", "Теодор", "Петровски", "Илинденска 35", "Б", "7000", "Macedonia", "078285449", SeleniumSetup.beforeCountry, SeleniumSetup.password, SeleniumSetup.password, "Физичко лице", "click"), "Ве молиме пополнете ги сите задолжителни полиња!");
    }

    @Test(priority = 11, description = "Verify that validation message is shown when invalid data is entered in Postal Code input field.(666)-entered data", enabled = true)
    public void testForVerifyingValidationMsgWhenInvalidDataIsEnteredInPostalCodeField() {
        Assert.assertEquals(SeleniumSetup.validationMessages("invalidPostalCode", "Теодор", "Петровски", "Илинденска 35", "Битола", "666", "Macedonia", "078285449", SeleniumSetup.beforeCountry, SeleniumSetup.password, SeleniumSetup.password, "Физичко лице", "click"), "Ве молиме пополнете ги сите задолжителни полиња!");
    }

    @Test(priority = 12, description = "Verify that when invalid data is entered in Country input field the user cannot register.(Битола)-entered data", enabled = true)
    public void testForVerifyingUserCannotRegisterWithInvalidDataInCountryField() {
         Assert.assertEquals(SeleniumSetup.countryInputField(),"http://18.156.17.83:9095/account-type/register-client");
    }

    @Test(priority = 13, description = "Verify that validation message is shown when invalid data in entered in Phone Number input field.(-078285449)-entered data", enabled = true)
    public void testForVerifyingValidationMsgWhenInvalidDataIsEnteredInPhoneNumberField() {
        Assert.assertEquals(SeleniumSetup.validationMessages("invalidPhoneNumber", "Теодор", "Петровски", "Илинденска 35", "Битола", "7000", "Macedonia", "-078285449", SeleniumSetup.afterCountry, SeleniumSetup.password, SeleniumSetup.password, "Физичко лице", "click"), "Ве молиме пополнете ги сите задолжителни полиња!");
    }

    @Test(priority = 14, description = "Verify that validation message is shown when invalid email is entered in E-mail input field.(teopetrovski)-entered data", enabled = true)
    public void testForVerifyingValidationMsgWhenInvalidEmailInEnteredInEmailField() {
        Assert.assertEquals(SeleniumSetup.validationMessages("invalidEmail", "Теодор", "Петровски", "Илинденска 35", "Битола", "7000", "Macedonia", "078285449", "teopetrovski", SeleniumSetup.password, SeleniumSetup.password, "Физичко лице", "click"), "Вашиот e-mail не е валиден.");
    }

    @Test(priority = 15, description = "Verify that validation message is shown when invalid data is entered in E-mail input field.(teo@gmail.commmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm)-entered data", enabled = true)
    public void testForVerifyingValidationMsgWhenInvalidDataIsEnteredInEmailField() {
        Assert.assertEquals(SeleniumSetup.validationMessages("boundaryEmailLong", "Теодор", "Петровски", "Илинденска 35", "Битола", "7000", "Macedonia", "078285449", "teo@gmail.commmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm", SeleniumSetup.password, SeleniumSetup.password, "Физичко лице", "click"), "Вашиот e-mail неможе да биде подолг од 50 карактери.");
    }

    @Test(priority = 16, description = "Verify that validation message is shown when invalid data is entered in Password input field.(123)-entered data", enabled = true)
    public void testForVerifyingValidationMsgWhenInvalidDataIsEnteredInPasswordField() {
        Assert.assertEquals(SeleniumSetup.validationMessages("boundaryPasswordShort", "Теодор", "Петровски", "Илинденска 35", "Битола", "7000", "Macedonia", "078285449", SeleniumSetup.afterCountry, "123", SeleniumSetup.password, "Физичко лице", "click"), "Вашата лозинка треба да биде од најмалку 4 карактери.");
    }

    @Test(priority = 17, description = "Verify that validation message is shown when invalid data is entered in Confirm Password input field.", enabled = true)
    public void testForVerifyingValidationMsgWhenInvalidDataIsEnteredInConfirmPasswordField() {
        Assert.assertEquals(SeleniumSetup.validationMessages("confirmPasswordNotMatching", "Теодор", "Петровски", "Илинденска 35", "Битола", "7000", "Macedonia", "078285449", SeleniumSetup.afterCountry, SeleniumSetup.password, "1234", "Физичко лице", "click"), "Вашата лозинка не соодветсвува со потврдената лозинка!");
    }

    @Test(priority = 18, description = "Verify that validation message is shown when Terms and Conditions checkbox is not ticked.", enabled = true)
    public void testForVerifyingValidationMsgWhenTaCIsNotTicked() {
        Assert.assertEquals(SeleniumSetup.validationMessages("checkBoxNotTicked", "Теодор", "Петровски", "Илинденска 35", "Битола", "7000", "Macedonia", "078285449", SeleniumSetup.afterCountry, SeleniumSetup.password, "1234", "Физичко лице", ""), "Ова поле е задолжително.");
    }

    @Test(priority = 36, description = "Verify that the user has signed out successfully.", enabled = true)
    public void testForVerifyingUserSignedOutSuccessfully1() {
        Assert.assertEquals(SeleniumSetup.signOut(), "http://18.156.17.83:9095/");
    }

    @AfterClass
    public void afterClass() {
        SeleniumSetup.end();
    }
}
