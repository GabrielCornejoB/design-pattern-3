package com.example.patterns_banking.models.decorator;

import com.example.patterns_banking.models.Account;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class AccountLimitWithdrawalDecorator extends AccountDecorator {

    private static final Double LIMIT = 20000.0;

    public AccountLimitWithdrawalDecorator(Account account) {
        super(account);
    }

    @Override
    public void withdraw(double amount) {
        double fee = super.calculateWithdrawalFee(amount);

        if (amount > (super.getBalance() + LIMIT - fee)) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        if (amount < (super.getBalance() - fee)) {
            super.setBalance(super.getBalance() - (amount + fee));
            return;
        }

        System.out.println("Se hizo el retiro y el excedente fue de " + (amount - super.getBalance()));
        this.getAccount().setBalance(0.0);
    }
}
