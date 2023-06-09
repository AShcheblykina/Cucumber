package ru.netology.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TemplateSteps {
    private DashboardPage dashboardPage;

    @Пусть("Пусть пользователь залогинен с именем {} и паролем {}")
    public void authorization(String login, String password) {
        var loginPage = open("http://localhost:9999/", LoginPage.class);
        var verificationPage = loginPage.validLogin(login, password);
        dashboardPage = verificationPage.validVerify(DataHelper.getVerificationCode());
    }

    @Когда("Когда он переводит {} рублей с карты с номером {} на свою {} карту с главной страницы")
    public void makeTransfer(String amount, String debitCardNumber, int creditCardNumber) {
        var transferPage = dashboardPage.selectCard(creditCardNumber);
        dashboardPage = transferPage.makeTransfer(amount, debitCardNumber);
    }

    @Тогда("Тогда баланс его {} карты из списка на главной странице должен стать {} рублей")
    public void VerifyCreditBalance(int creditCardNumber, int expectedCreditBalance) {
        var actualCreditBalance = dashboardPage.getCardBalance(creditCardNumber);
        assertEquals(expectedCreditBalance, actualCreditBalance);

    }

}