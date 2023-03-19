package ru.netology.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;
import ru.netology.page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;


public class TemplateSteps {
   private DashboardPage dashboardPage;

 @Пусть("Пусть пользователь залогинен с именем {string} и паролем {string}")
  public  void authorization(String login, String password) {
  var loginPage =   open("http://localhost:9999", LoginPage.class);
  var verificationPage = loginPage.validLogin(login,password);
  dashboardPage = verificationPage.validVerify(DataHelper.getVerificationCode());
 }
}