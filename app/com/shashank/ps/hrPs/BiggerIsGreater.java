package com.shashank.ps.hrPs;

import java.io.*;
import java.util.*;
import java.util.stream.*;


/**
 * Lexicographical order is often known as alphabetical order when dealing with strings. A string is greater than another string if it comes later in a lexicographically sorted list.
 *
 * Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:
 *
 * It must be greater than the original word
 * It must be the smallest word that meets the first condition
 *
 */
class Result {

    public static String biggerIsGreater(String w) {

        char[] wc = w.toCharArray();
        int len = wc.length;

        int i = len-1;
        while (i > 0 && wc[i-1] >= wc[i]) {
            i--;
        }

        if (i <= 0) {
            return "no answer";
        }

        int j = len-1;

        while (wc[j] <= wc[i-1]) {
            j--;
        }

        char temp = wc[i-1];
        wc[i-1] = wc[j];
        wc[j] = temp;

        Arrays.sort(wc, i, len);

        return new String(wc);
    }

}

public class BiggerIsGreater {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result.biggerIsGreater(w);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

