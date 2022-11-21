import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int tiers = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of tiers: ");
        tiers = scanner.nextInt();

        if (tiers > 0) {
            sastatuna(tiers);
        }
        scanner.close();
    }

    private static void sastatuna(int tiers) {
        int width = 1;
        int tierHeight = 3;
        int height = maxHeight(tiers);

        for (int i = 0; i < tiers; i++) {
            for (int cursor = 0; cursor < tierHeight; cursor++) {
                width = putCharacters(height, width);
            }
            tierHeight++;
            width = width + 4;
        }
    }

    private static int maxHeight(int tiers) {
        int result = 0;
        int move;
     
        for(move = 0; move < tiers; move++)
        {
            result += (tiers + 2) * 2;
        }
     
        result += (tiers + 2) / 2;
        return result;
    }

    private static void putSpaces(int height, int width) {
        int spaces = ((height + (height - 1)) - width) / 2;
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
    }

    private static int putCharacters(int height, int width) {
        int flag = 0;
        putSpaces(height, width);
        flag = putOutlayer(flag);
        for (int j = 0; j < width; j++) {

            System.out.print("*");
        }
        flag = putOutlayer(flag);
        putSpaces(height, width);
        System.out.println();
        return width += 2;
    }

    private static int putOutlayer(int flag) {
        if (flag == 0) {
            System.out.print("/");
            flag = 1;
        } else {
            System.out.print("\\");
            flag = 0;
        }
        return flag;
    }

}