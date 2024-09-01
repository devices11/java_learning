package bankAccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private static BankAccount account;

    @BeforeEach
    public void beforeEach() {
        account = new BankAccount("a", "b");
    }

    @Test
    public void shouldNotBeBlockedWhenCreated() {
        assertFalse(account.isBlocked());
    }

    @Test
    public void shouldReturnZeroAmountAfterActivation() {
        account.activate("RUB");
        assertEquals(Integer.valueOf(0), account.getAmount());
        assertEquals("RUB", account.getCurrency());
    }

    @Test
    public void shouldBeBlockedAfterBlockIsCalled() {
        account.activate("RUB");
        account.block();
        assertTrue(account.isBlocked());
    }

    @Test
    public void shouldReturnFirstNameThenSecondName() {
        String[] fullName = account.getFullName();
        String firstName = fullName[0];
        String secondName = fullName[1];
        assertEquals("a", firstName);
        assertEquals("b", secondName);
    }

    @Test
    public void shouldReturnNullAmountWhenNotActive() {
        assertNull(account.getCurrency());
    }
}