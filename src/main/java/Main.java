import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Integer Size3 = 3;

        String str = "BCA";
        AtomicInteger count3 = new AtomicInteger(0);

        if ((istPalindrom(str)) && (str.length() == Size3)) {
            System.out.println("Полиндром");
            count3.incrementAndGet();
        } else if (((str.length() == Size3) && (istIncement(str))) || ((str.length() == Size3) && istIncement(swap(str)))) {
            System.out.println("Красивый");
            count3.incrementAndGet();
        } else System.out.println("Не прошло проверку");

        out.printf("Красивых слов с длиной %s: %s", Size3, count3);

//        String given = "ABCDEFGabcdefqhijklmnop";
//        String[] characterArray = str.split("");
//        for (int i = 0; i < characterArray.length; i++) {
//            out.print(characterArray[i] + " ");
//            out.println(characterArray[i].hashCode());
//        }
        //returns = [a, s, d, c, b, s, d, c, a, g, f, s, d, b, g, d, f, a, n, f, g, h, b, s, f, d, a, b]

/*        Random random = new Random();
        String[] texts = new String[100_000];
        Integer count3 = 0;
        Integer count4 = 0;
        Integer count5 = 0;

        Thread threadUser3 = new Thread(count3);
        Thread threadUser4 = new Thread(count4);
        Thread threadUser5 = new Thread(count5);

        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
            System.out.println(texts[i]);
        }
    }

    public static String generateText(String letters,int length){
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();*/
    }

    public static boolean istPalindrom(String word) {

        Character[] charObjectArray =
                word.toLowerCase().chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        int i1 = 0;
        int i2 = charObjectArray.length - 1;
        while (i2 > i1) {
            if (charObjectArray[i1] != charObjectArray[i2]) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }

    public static String swap(String word) {
        List<Character> charObjectArray = new java.util.ArrayList<>(word.toLowerCase().chars().mapToObj(c -> (char) c).toList());
        for (int i = 1; i <= (charObjectArray.size() + 1) / 2; i++) {
            Collections.swap(charObjectArray, i - 1, charObjectArray.size() - i);
        }
        return charObjectArray.toString();
    }

    public static boolean istIncement(String word) {
        Character[] charObjectArray =
                word.toLowerCase().chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        int i1 = 0;
        int i2 = i1 + 1;
        while (charObjectArray.length != i2) {
            if (charObjectArray[i1] > charObjectArray[i2]) {
                return false;
            }
            i1++;
            i2++;
        }

        return true;
    }
}