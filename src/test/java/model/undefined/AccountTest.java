package model.undefined;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void withdrawTest() {
        //Konto starter på 1000
        Account account = new Account();
        account.withdraw(2000);
        assertEquals(0, account.getBalance());
    }

    @Test
    public void depositTest() {
        //Konto starter på 20
        Account account = new Account();
        account.deposit(100);
        assertEquals(120, account.getBalance());

    }
}