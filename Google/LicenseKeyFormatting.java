/*
    482. License Key Formatting: Easy
    https://leetcode.com/problems/license-key-formatting/description/
 */
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder result = new StringBuilder();
        s = s.toUpperCase();
        int subSize = k;
        for (int i = s.length()-1; i >= 0; i--) {
            if (subSize != 0 && s.charAt(i) != '-') {
                result.insert(0, s.charAt(i));
                subSize--;
            }

            if (subSize == 0) {
                result.insert(0, "-");
                subSize = k;
            }
        }

        while (result.length() > 0 && result.charAt(0) == '-') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }
}
