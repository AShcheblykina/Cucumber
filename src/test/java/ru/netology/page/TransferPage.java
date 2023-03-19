package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TransferPage {
    private final SelenideElement transfer = $("[data-test-id='action-transfer']");
    private final SelenideElement amount = $("[data-test-id='amount'] input");
    private final SelenideElement card = $("[data-test-id='from'] input");
    private final SelenideElement replenishment = $x("//h1");

    public TransferPage() {
        transfer.shouldBe(visible);
    }

    public DashboardPage makeReplenishment(String amountToTransfer, String cardNumber) {
        amount.setValue(amountToTransfer);
        card.setValue(cardNumber);
        transfer.click();
        return new DashboardPage();
    }
}