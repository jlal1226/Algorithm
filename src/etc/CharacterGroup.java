package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class CharacterGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Pattern koreanPattern = Pattern.compile("^[가-힣]*$");
        Pattern englishPattern = Pattern.compile("^[a-zA-Z]*$");
        Pattern numberPattern = Pattern.compile("^[0-9]*$");
        Pattern symbolPattern = Pattern.compile("[ !@#$%^&*(),.?\":{}|<>]");


        StringBuilder korean = new StringBuilder();
        StringBuilder english = new StringBuilder();
        StringBuilder number = new StringBuilder();
        StringBuilder symbol = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            String subString;
            if (i == input.length() - 1) {
                subString = input.substring(i);
            } else {
                subString = input.substring(i, i+1);
            }
            if (koreanPattern.matcher(subString).find()) {
                korean.append(subString);
            } else if (englishPattern.matcher(subString).find()) {
                english.append(subString);
            } else if (numberPattern.matcher(subString).find()) {
                number.append(subString);
            } else {
                symbol.append(subString);
            }
        }
        System.out.println(korean);
        System.out.println(english);
        System.out.println(number);
        System.out.println(symbol);
    }
}
