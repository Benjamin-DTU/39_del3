package model.undefined;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void withdrawTest() {
        //Konto starter på 1000
        Account account = new Account();
        account.withdraw(2000);
        //Kontoen får i første omgang værdien -1000, men skal rette dette til 0, da man ikke kan have en negativ konto
        assertEquals(0, account.getBalance());
    }

    @Test
    public void depositTest() {
        //Konto starter på 20
        Account account = new Account();
        account.deposit(100);
        //Kontoen får tilført 500, og skal derefter have 1500 efter deposit
        assertEquals(120, account.getBalance());

    }
}