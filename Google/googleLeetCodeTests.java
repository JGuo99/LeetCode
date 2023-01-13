import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class googleLeetCodeTests {
    @Test
    public void UniqueEmailAddressesTest() {
        UniqueEmailAddresses check = new UniqueEmailAddresses();
        String[] test1 = {
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
        };
        String[] test2 = {
                "a@leetcode.com",
                "b@leetcode.com",
                "c@leetcode.com"
        };
        int result = check.numUniqueEmails(test1);
        assertEquals(2, result, 0);
        result = check.numUniqueEmails(test2);
        assertEquals(3, result, 0);
    }
}
