package bankAccount;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class BankAccountTest {

    private static final BigDecimal DEFAULT_VALUE = BigDecimal.ZERO;
    private static final BigDecimal INVALID_VALUE = BigDecimal.valueOf(-2);

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowExpectedIfTheBalancePassedIsLessThenZero() {
        BankAccount bankAccount = new BankAccount("DSK", INVALID_VALUE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowExpectedIfTheNameHasLessThanThreeChars() {
        BankAccount bankAccount = new BankAccount("DS", DEFAULT_VALUE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowExpectedIfTheNameHasMoreThanTwentyFiveChars() {
        BankAccount bankAccount = new BankAccount("DASDASDASDASDASDASDASDASDASDADS", INVALID_VALUE);
    }

    @Test
    public void constructorWithValidArgumentsShouldSetTheirValueToTheCorrespondingVars() {
        BankAccount bankAccount = new BankAccount("DSK", BigDecimal.TEN);
    }

    @Test
    public void getBalanceShouldReturnTheCorrectCurrentBalance() {
        BankAccount bankAccount = new BankAccount("DSK", BigDecimal.TEN);
        assertEquals(BigDecimal.TEN, bankAccount.getBalance());
    }
    @Test
    public void getNameShouldReturnTheCorrectName() {
        BankAccount bankAccount = new BankAccount("DSK", BigDecimal.TEN);
        assertEquals("DSK", bankAccount.getName());
    }
    @Test(expected = UnsupportedOperationException.class)
    public void depositAnAmountLessThanZeroShouldThrowExpected() {
        BankAccount bankAccount = new BankAccount("DSK", BigDecimal.TEN);
        bankAccount.deposit(BigDecimal.valueOf(-2));
    }
    @Test(expected = UnsupportedOperationException.class)
    public void depositZeroShouldThrowExpected() {
        BankAccount bankAccount = new BankAccount("DSK", BigDecimal.TEN);
        bankAccount.deposit(BigDecimal.ZERO);
    }

    @Test
    public void depositShouldAddTheAmountToTheCurrentBalance() {
        BankAccount bankAccount = new BankAccount("DSK", BigDecimal.TEN);
        bankAccount.deposit(BigDecimal.valueOf(2));
        assertEquals(BigDecimal.valueOf(12), bankAccount.getBalance());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void withdrawAnAmountLessThanZeroShouldThrowExpected() {
        BankAccount bankAccount = new BankAccount("DSK", BigDecimal.TEN);
        bankAccount.withdraw(BigDecimal.valueOf(-2));
    }
    @Test
    public void withdrawTheSameMoneyThanPresentInTheBalanceShouldNotThrowException() {
        BankAccount bankAccount = new BankAccount("DSK", BigDecimal.TEN);
        bankAccount.withdraw(BigDecimal.valueOf(10));
    }
    @Test(expected = UnsupportedOperationException.class)
    public void withdrawMoreMoneyThanPresentInTheBalanceShouldThrowExpected() {
        BankAccount bankAccount = new BankAccount("DSK", BigDecimal.TEN);
        bankAccount.withdraw(BigDecimal.valueOf(11));
    }
    @Test
    public void withdrawShouldSubstractTheAmountFromTheBalance() {
        BankAccount bankAccount = new BankAccount("DSK", BigDecimal.TEN);
        bankAccount.withdraw(BigDecimal.valueOf(1));
        assertEquals(0, BigDecimal.valueOf(9).compareTo(bankAccount.getBalance()));
    }
    @Test
    public void withdrawZeroShouldNotSubstractNothingTheAmountFromTheBalance() {
        BankAccount bankAccount = new BankAccount("DSK", BigDecimal.TEN);
        bankAccount.withdraw(BigDecimal.valueOf(0));
        assertEquals(0, BigDecimal.valueOf(10).compareTo(bankAccount.getBalance()));
    }

    @Test
    public void withDrawShouldReturnTheAmountSubtracted() {
        BankAccount bankAccount = new BankAccount("DSK", BigDecimal.TEN);
        assertEquals(BigDecimal.ZERO, bankAccount.withdraw(BigDecimal.ZERO));
    }
}
