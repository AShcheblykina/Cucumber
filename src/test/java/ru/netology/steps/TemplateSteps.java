package ru.netology.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;


public class TemplateSteps {
   private DashboardPage dashboardPage;

 @Пусть("Пусть пользователь залогинен с именем {string} и паролем {string}")
  public  void authorization(String login, String password) {
  var loginPage =   open("http://localhost:9999", LoginPage.class);
  var verificationPage = loginPage.validLogin(login,password);
  dashboardPage = verificationPage.validVerify(String.valueOf(DataHelper.getVerificationCode()));
 }
 @Когда("Когда он переводит {string} pублей с карты с номером {string} на свою {int} карту с главной страницы")
  public void makeTransfer(String amount, String debitCardNumber, int creditCardNumber) {
  var transferPage = dashboardPage.selectCard(creditCardNumber);
  dashboardPage = transferPage.makeTransfer(amount, debitCardNumber);
 }
 @Тогда("Тогда баланс его {int} карты из списка на главной странице должен стать {int} рублей")
 public void VerifyCreditBalance(int creditCardNumber, int expectedCreditBalance) {

 }

}