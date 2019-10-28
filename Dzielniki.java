import java.util.Collection;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

import static java.util.Collections.*;

public class Dzielniki {

    public static void main(String[] args) {
        int number = readNumber();
        int[] dividers = findDividers(number);
        printDividers(number, dividers);
    }

    private static int readNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę, dla której chcesz znaleźć dzielniki:");
        return scanner.nextInt();
    }

    private static boolean checkDivider(int a, int b) {
        return a % b == 0;
    }

    private static int[] findDividers(int number) {
        int[] dividers = new int[number / 2 + 1];
        dividers[0] = number;

        for (int i = 1; i <= number / 2; i++) {
            if (checkDivider(number, i)) {
                dividers[i] = i;
            }
        }

        return removeZerosFromArray(dividers);
    }

    private static int[] removeZerosFromArray(int[] array) {
        Arrays.sort(array);

        int startCopyIndex = 0;

        for (int i = 0; i <= array.length; i++) {
            if (array[i] != 0) {
                startCopyIndex = i;
                break;
            }
        }

        return Arrays.copyOfRange(array, startCopyIndex, array.length);
    }

    private static void printDividers(int number, int[] dividers) {
        String message = "Dzielnikami liczby " + number + " są: ";

        for (int divider : dividers) {
            message += divider + "; ";
        }

        System.out.println(message);
    }
}
