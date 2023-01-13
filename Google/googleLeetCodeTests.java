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
    @Test
    public void LicenseKeyFormattingTest() {
        LicenseKeyFormatting check = new LicenseKeyFormatting();
        String test1 = "5F3Z-2e-9-w";
        int k1 = 4;
        String result = check.licenseKeyFormatting(test1, k1);
        assertEquals("5F3Z-2E9W", result);

        String test2 = "2-5g-3-J";
        int k2 = 2;
        result = check.licenseKeyFormatting(test2, k2);
        assertEquals("2-5G-3J", result);

        String test3 = "2-4A0r7-4k";
        int k3 = 4;
        result = check.licenseKeyFormatting(test3, k3);
        assertEquals("24A0-R74K", result);

        String test4 = "---";
        int k4 = 4;
        result = check.licenseKeyFormatting(test4, k4);
        assertEquals("", result);
    }
}
