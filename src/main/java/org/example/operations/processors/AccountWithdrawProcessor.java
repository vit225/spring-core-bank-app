package org.example.operations.processors;

import org.example.account.AccountService;
import org.example.operations.ConsoleOperationType;
import org.example.operations.OperationCommandProcessor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AccountWithdrawProcessor implements OperationCommandProcessor {

    private final Scanner scanner;
    private final AccountService accountService;

    public AccountWithdrawProcessor(Scanner scanner, AccountService accountService) {
        this.scanner = scanner;
        this.accountService = accountService;
    }

    @Override
    public void processOperation() {
        System.out.println("Enter account id:");
        int accountId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter amount to withdraw:");
        int amountToWithDraw = Integer.parseInt(scanner.nextLine());
        accountService.withDrawFromAccount(accountId, amountToWithDraw);
        System.out.println("Successfully withdraw amount=%s to accountId=%s"
                .formatted(amountToWithDraw, accountId));
    }

    @Override
    public ConsoleOperationType getOperationType() {
        return ConsoleOperationType.ACCOUNT_WITHDRAW;
    }
}
