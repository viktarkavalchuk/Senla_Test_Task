import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exercise_1 {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите строку, программа вычислит сумму цифр, присутствующих в данной строке");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();
        String numberOnly= inputLine.replaceAll("[^0-9]", "");
        try {
            double num = Double.parseDouble(numberOnly);
            System.out.println("Сумма цифр в данной строке: " + sumDigitsNumber(num));

        } catch (NumberFormatException e) {
            System.out.println("Сумма равна 0.");
        }
    }

    public static int sumDigitsNumber(double number)  {
        int sum = 0;
        while (number >= 1) {
            sum += number % 10;
            number = number / 10;
        }
        return(sum);
    }
}
