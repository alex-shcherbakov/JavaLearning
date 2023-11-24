package org.example;

public class AccountNotFoundException extends Exception{
    private String accountName;
    public AccountNotFoundException(String accountName){
        super("This account wasn't found. " +
                "Probably name " + accountName + " doesn't exist");
        this.accountName = accountName;
    }


    public string getAccountName() {
        return this.accountName;
    }

    public void setAccountName(String accountName){
        this.accountName = accountName;

    }
}
