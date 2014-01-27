import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        String test = "((6.28 + 3.14) + 7.56)";
        String pattern = "\\( |\\) |\\d+\\.?\\d* |[+-/%^!*]";
        String pattern2 = "(\\()|(\\))|(\\d+\\.?\\d*)|([+-/%^!*])";
        
        Pattern r = Pattern.compile(pattern2);
        Matcher m = r.matcher(test);
        
        ArrayList<String> bits = new ArrayList();
        
        while (m.find()) {
            bits.add(m.group());
        }
        for(String s: bits) {
            System.out.println(s);
        }
    }
}
