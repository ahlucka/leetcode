import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        
    }

    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < emails.length; i++) {
            String local = emails[i].substring(0, emails[i].indexOf('@'));
            String domain = emails[i].substring(emails[i].indexOf('@'));

            local = local.replaceAll("\\+.*", "");
            local = local.replaceAll("\\.", "");

            set.add(local + domain);
        }
        return set.size();
    }
}