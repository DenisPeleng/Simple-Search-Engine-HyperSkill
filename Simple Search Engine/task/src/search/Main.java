package search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArr = scanner.nextLine().split(" ");
        String searchWord = scanner.nextLine();
        for (int i = 0; i < inputArr.length; i++) {
            if (searchWord.equals(inputArr[i])) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println("Not found");
    }
}
