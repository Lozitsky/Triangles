import java.util.Arrays;
import java.util.Scanner;

public class Triangles {
    private static int number;
    private static char symbol;

    public static void main(String[] args) {
        System.out.println("Print symbol: ");
        Scanner scanner = new Scanner(System.in);
        symbol = scanner.next().charAt(0);
        System.out.println("Print number of symbol \'" + symbol + "\':");
        number = scanner.nextInt();
        System.out.println("We need " + number + " \'" + symbol + "\'");
        Triangles triangles = new Triangles();
        printRectangle(triangles.getFeelRectangle(symbol));
        printRectangle(triangles.getTriangleA());
        printRectangle(triangles.getTriangleB());
        printRectangle(triangles.getTriangleC());
        printRectangle(triangles.getTriangleD());
    }

    public static void printRectangle(char[][] chars) {
        Arrays.stream(chars).forEach(ch -> System.out.println(ch));
    }

    public char[][] getFeelRectangle(char symbol) {
        char[] chars = new char[number];
        Arrays.fill(chars, symbol);
        char[][] chars2 = new char[number][number];
        for (int i = 0; i < number; i++) {
            chars2[i] = Arrays.copyOfRange(chars, 0, chars.length);
        }
        return chars2;
    }

    public char[][] getTriangleA() {
        char[][] feelRectangle = getFeelRectangle(symbol);
        for (int i = 0; i < feelRectangle.length; i++) {
            for (int j = 0; j < i; j++) {
                feelRectangle[i][j] = ' ';
            }
        }
        return feelRectangle;
    }

    public char[][] getTriangleB() {
        char[][] feelRectangle = getFeelRectangle(symbol);
        for (int j = 0; j < feelRectangle.length; j++) {
            for (int i = 0; i < j; i++) {
                feelRectangle[i][j] = ' ';
            }
        }
        return feelRectangle;
    }

    public char[][] getTriangleC() {
        char[][] feelRectangle = getFeelRectangle(symbol);
        for (int i = 0; i < feelRectangle.length; i++) {
            for (int j = feelRectangle[i].length - i - 2; j > -1; j--) {
                feelRectangle[i][j] = ' ';
            }
        }
        return feelRectangle;
    }

    public char[][] getTriangleD() {
        char[][] feelRectangle = getFeelRectangle(symbol);
        for (int i = 0; i < feelRectangle.length; i++) {
            for (int j = feelRectangle[i].length - 1; feelRectangle.length - j <= i; j--) {
                feelRectangle[i][j] = ' ';
            }
        }
        return feelRectangle;
    }

}
