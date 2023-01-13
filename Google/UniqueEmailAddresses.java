import java.util.*;
/*
    929. Unique Email Addresses: Easy
    https://leetcode.com/problems/unique-email-addresses/description/
 */
class UniqueEmailAddresses {
    public static int numUniqueEmails(String[] emails) {
        Set<String> database = new HashSet<>();
        for (String email : emails) {
            StringBuilder local = new StringBuilder();
            String domain = "";
            for (int i = 0; i < email.length(); i++) {
                char e = email.charAt(i);
                if (e == '@') {
                    domain = email.substring(i, email.length());
                    break;
                } else {
                    local.append(e);
                }
            }
            database.add(decodeLocal(local)+domain);   
        }            
        return database.size();
    }
        
    private static String decodeLocal(StringBuilder local) {
        StringBuilder newLocal = new StringBuilder();
        for (int i = 0; i < local.length(); i++) {
            if (local.charAt(i) == '.') continue;
            else if (local.charAt(i) == '+') break;
            else newLocal.append(local.charAt(i));
        }
        return newLocal.toString();
    }
}