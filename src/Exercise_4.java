import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Exercise_4 {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите число. Программа выведет число в виде символов состоящих из '*', наибольшее цифра ");
        System.out.println("числа будет состоять не из ‘*’, а из соответствующих маленьких (обычных) цифр");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();

        int digitLength = 5;
        int digitHeight = 7;
        String str0 =   " *** " +
                        "*   *" +
                        "*   *" +
                        "*   *" +
                        "*   *" +
                        "*   *" +
                        " *** ";

        String str1 =   "  *  " +
                        " **  " +
                        "  *  " +
                        "  *  " +
                        "  *  " +
                        "  *  " +
                        "*****";

        String str2 =   " *** " +
                        "*   *" +
                        "   * " +
                        "  *  " +
                        " *   " +
                        "*    " +
                        "*****";
        String str3 =   "*****" +
                        "   * " +
                        "  *  " +
                        " ****" +
                        "   * " +
                        "  *  " +
                        " *   ";
        String str4 =   "   **" +
                        "  * *" +
                        " *  *" +
                        "*****" +
                        "    *" +
                        "    *" +
                        "    *";
        String str5 =   "*****" +
                        "*    " +
                        "*    " +
                        "**** " +
                        "    *" +
                        "    *" +
                        "**** ";
        String str6 =   " *** " +
                        "*   *" +
                        "*    " +
                        "**** " +
                        "*   *" +
                        "*   *" +
                        " *** ";
        String str7 =   "*****" +
                        "    *" +
                        "   * " +
                        "  *  " +
                        " *   " +
                        "*    " +
                        "*    ";
        String str8 =   " *** " +
                        "*   *" +
                        " * * " +
                        "  *  " +
                        " * * " +
                        "*   *" +
                        " *** ";
        String str9 =   " *** " +
                        "*   *" +
                        "*   *" +
                        " ****" +
                        "    *" +
                        "*   *" +
                        " *** ";


        String[] digitsArray = {str0, str1, str2, str3, str4, str5, str6, str7, str8, str9};

        String input = inputLine;

        char[] inputArray = inputLine.toCharArray();
            char maxValue = inputArray[0];
            for(int i=1;i < inputArray.length;i++){
                if(inputArray[i] > maxValue){
                    maxValue = inputArray[i];
                }
            }

        int maxDigit = Integer.parseInt(String.valueOf(maxValue));

        for (int row = 0; row < digitHeight; row++) {
            for (int i = 0; i < input.length(); i++) {

                int digit = input.charAt(i) - '0';

                for (int j = 0; j < digitLength; j++) {
                    char ch = digitsArray[digit].charAt(row * digitLength + j);
                    if (digit == maxDigit) {
                        if (ch == '*') {
                            System.out.print(digit + " ");
                        } else {
                            System.out.print(ch + " ");
                        }
                    } else {
                        System.out.print(ch + " ");
                    }
                }
                System.out.print("  ");
            }
            System.out.println();
        }
    }

}