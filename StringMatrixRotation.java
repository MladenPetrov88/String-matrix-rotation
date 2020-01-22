import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        String input = rd.readLine();
        int degrees = Integer.parseInt(input.substring(input.indexOf('(') + 1, input.indexOf(')')));
        List<String> list = new ArrayList<>();
        int maxSize = 0;

        while (!"END".equals(input = rd.readLine())) {
            if (input.length() > maxSize)
                maxSize = input.length();

            list.add(input);
        }

        switch (degrees % 360 / 90) {
            case 0:
                list.forEach(System.out::println);
                break;

            case 1:
                Collections.reverse(list);
                for (int i = 0; i < maxSize; i++) {
                    for (String s : list)
                        if (s.length() > i)
                            System.out.print(s.charAt(i));
                        else
                            System.out.print(" ");

                    System.out.println();
                }
                break;

            case 2:
                Collections.reverse(list);
                for (String s : list) {
                    StringBuilder word = new StringBuilder(s);
                    while (word.length() < maxSize)
                        word.append(" ");

                    System.out.println(word.reverse().toString());
                }
                break;

            case 3:
                for (int i = 0; i < list.size(); i++) {
                    String s = list.get(i);
                    StringBuilder word = new StringBuilder(s);
                    while (word.length() < maxSize)
                        word.append(" ");

                    list.set(i, word.reverse().toString());
                }

                for (int i = 0; i < maxSize; i++) {
                    for (String word : list)
                        System.out.print(word.charAt(i));

                    System.out.println();
                }
                break;
        }
    }
}