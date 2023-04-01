class Solution {
    public String maskPII(String s) {
        int atIndex = s.indexOf('@');
        if (atIndex != -1) {
            s = s.toLowerCase();
            // 邮箱
            String[] data = s.split("@");
            char first = data[0].charAt(0);
            char last = data[0].charAt(data[0].length() - 1);
            String suffix = data[1];
            return first + "*****" + last + "@" + suffix;
        } else {
            // 手机号
            StringBuffer number = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (Character.isDigit(ch)) {
                    // number = number * 10 + Integer.parseInt(ch);
                    number.append(ch);
                }
            }
            int length = number.length();
            String suffix = number.substring(length - 4, length);
            if (length == 10) {
                return "***-***-" + suffix;
            }
            String prefix = "*".repeat(length - 10);
            return "+" + prefix + "-***-***-" + suffix;
        }
    }
}