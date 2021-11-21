import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exercise_2 {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите число, программа вычислит и выведет на экран простые множители этого числа");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();
        try {
            simpleNumbers(inputLine);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка! Введённое число не является целым");
        }
    }
    public static void simpleNumbers(String line){
        int currentValue = Integer.parseInt(line);
        double sqrt = Math.sqrt(currentValue);
        int multiplier = 2;
        System.out.print("Множители числа: ");
        while (currentValue > 1 && multiplier <= sqrt)
        {
            if (currentValue % multiplier == 0)
            {
                System.out.print(multiplier + " ");
                currentValue /= multiplier;
            }
            else if (multiplier == 2)
            {
                multiplier++;
            }
            else
            {
                multiplier += 2;
            }
        }
        if (currentValue != 1)
        {
            System.out.print(currentValue);
        }
    }
}
