public class a9157 {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        if(s.length() < 3)return s;
        int p1 = 0;
        int p2 = 1;
        int count  = 0;
        while (p2 < s.length()) {
            if(s.charAt(p1) == s.charAt(p2)){
                count++;
                if(count < 2)sb.append(s.charAt(p2));
                p2++;
            }else{
                sb.append(s.charAt(p2));
                p1 = p2;
                p2++;
                count = 0;
            }
        }
        return sb.toString();
    }
}
