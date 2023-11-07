package org.example;

public class AccountNotFoundException extends Exception{
    private string accountName;
    public AccountNotFoundException(String accountName){
        this.accountName = accountName;
        super("This account wasn't found." +
                "probable name" + accountName +" doesn't exist");
    }

    public string getAccountName() {
        return this.accountName;
    }
}
