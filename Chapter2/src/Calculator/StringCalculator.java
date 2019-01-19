package Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.*;

public class StringCalculator {

    public int add(String text) throws RuntimeException {
        if(isBlank(text)) return 0;
        String[] splitText = splitStringFuc(text);
        int[] splitNumbers = stringsToInts(splitText);
        return sum(splitNumbers);
    }

    // splitFuction 역할 : 문자를 구분자에 맞게 나눠줌 (String -> String[])
    private String[] splitStringFuc(String text) {
        String split = ",|:";
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(matcher.find()) {
            split  += "|"+matcher.group(1);
            text = matcher.group(2);
        }
        return text.split(split);
    }

    // isBlank 역할 : text가 널 또는 빈값인지 체크
    private boolean isBlank(String text) {
       return (text == null || text.isEmpty());
    }

    // sum 역할 : 더한다
    private int sum(int[] numbers) {
        int sum = 0;
        for(int number : numbers) {
            sum += number;
        }
        return sum;
    }

    // StringsToInts : 문자를 숫자로 바꿔줌
    private int[] stringsToInts(String[] texts) {
        int[] results = new int[texts.length];
        for(int i=0; i<texts.length; i++) {
            results[i] = onlyPositive(texts[i]);
        }
        return results;
    }

    // onlyPositive : 양수가 아니면 RuntimeException
    private int onlyPositive(String value) {
        int number = parseInt(value);
        if(number < 0) throw new RuntimeException();
        return number;
    }
}









