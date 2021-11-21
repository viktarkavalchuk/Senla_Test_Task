import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.util.Collections.swap;

public class Exercise_3 {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите слова, русскими буквами, через пробел. Программа вычислит количество гласных в " +
                "каждом слове и сделает первую гласную букву в слове заглавной");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();
        String[] array = firstLetterToUppercase(inputLine);
        sortArray(array);
    }

    public static void sortArray(String[] inputArray) throws Exception {

        String[] arrayVowels = new String[inputArray.length];
        System.arraycopy(inputArray, 0, arrayVowels, 0, inputArray.length);

        for (int i = 0; i < arrayVowels.length; i++) {
            arrayVowels[i] = arrayVowels[i].replaceAll("[^аеёиоуэыюяАЕЁИОУЭЫЮЯ]", "");
        }

        for (int i = 1; i < inputArray.length; i++) {
            if (arrayVowels[i].length() > arrayVowels[i - 1].length()) {
                swap(Arrays.asList(arrayVowels), i, i - 1);
                swap(Arrays.asList(inputArray), i, i - 1);
                for (int z = i - 1; (z - 1) >= 0; z--) {
                    if (arrayVowels[z].length() > arrayVowels[z - 1].length()) {
                        swap(Arrays.asList(arrayVowels), z, z - 1);
                        swap(Arrays.asList(inputArray), z, z - 1);
                    } else {
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < inputArray.length; i++) {
            System.out.println(inputArray[i] + ", количество гласных: " + arrayVowels[i].length());
        }
    }

    public static String[] firstLetterToUppercase(String letterToUppercase) {
        String[] inputArray = letterToUppercase.split(" ");
        for (int i = 0; i < inputArray.length; i++) {
            boolean firstLetterFound = false;
            char[] chArray = inputArray[i].toCharArray();
            for (int a = 0; a < chArray.length; a++) {
                switch (chArray[a]) {
                    case 'а':
                    case 'е':
                    case 'ё':
                    case 'и':
                    case 'о':
                    case 'у':
                    case 'э':
                    case 'ы':
                    case 'ю':
                    case 'я':
                        chArray[a] = Character.toUpperCase(chArray[a]);
                        firstLetterFound = true;
                        break;
                }
                if (firstLetterFound) {
                    break;
                }
            }
            inputArray[i] = String.valueOf(chArray);
        }
        return (inputArray);
    }
}



