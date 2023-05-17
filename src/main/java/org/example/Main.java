package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;



public class Main {
    public static void main(String[] args) throws IOException {

        Map<String, Long> dublicateGroup = new HashMap<>();

        Map<String, BigInteger> sumWeight = new HashMap<>();

        long min = Long.MAX_VALUE, max = Long.MIN_VALUE;

        // Парсинг csv
//        try (BufferedReader read = new BufferedReader(new FileReader("C:\\project\\infomaksimum\\out.csv"))) {
//
//            String strochka = read.readLine();
//            while ((strochka = read.readLine()) != null) {
//                String[] podstr = strochka.split(",");
//                String gt = podstr[0];
//                BigInteger weight = new BigInteger(podstr[2]);
//
//                dublicateGroup.merge(gt, 1L, (k, v) -> k + v);
//
//                sumWeight.merge(gt, weight, BigInteger::add);
//
//                if (weight.compareTo(BigInteger.valueOf(min)) == -1) {
//                    min = weight.longValue();
//                }
//
//                if (weight.compareTo(BigInteger.valueOf(max)) == 1) {
//                    max = weight.longValue();
//                }
//            }
//            System.out.println("Дубликаты\n");
//            for (String name : dublicateGroup.keySet()) {
//                String key = name;
//                String value = dublicateGroup.get(name).toString();
//                System.out.println(key + " " + value);
//            }
//
//            System.out.println("\nОбщий вес\n");
//            for (String name : sumWeight.keySet()) {
//                String key = name;
//                String value = sumWeight.get(name).toString();
//                System.out.println(key + " " + value);
//            }
//
//            System.out.println("\nМинимальный вес объекта = " + min);
//
//            System.out.println("\nМаксимальный вес объекта = " + max);
//
//        } catch (FileNotFoundException e) {
//            throw e;
//        }

        // Парсинг json

        try (BufferedReader readj = new BufferedReader(new FileReader("C:\\project\\infomaksimum\\out.json"))) {

            Gson gson = new Gson();
            Groups[] groups = gson.fromJson(readj, new TypeToken<Groups[]>() {
            }.getType());

            int iterator = 0;
            while (iterator < groups.length) {
                String gr = groups[iterator].getGroup();
                BigInteger weight = new BigInteger(String.valueOf(groups[iterator].getWeight()));

                dublicateGroup.merge(gr, 1L, (k, v) -> k + v);

                sumWeight.merge(gr, weight, BigInteger::add);

                if (weight.compareTo(BigInteger.valueOf(min)) == -1) {
                    min = weight.longValue();
                }

                if (weight.compareTo(BigInteger.valueOf(max)) == 1) {
                    max = weight.longValue();
                }

                iterator++;
            }

            System.out.println("Дубликаты\n");
            for (String name : dublicateGroup.keySet()) {
                String key = name;
                String value = dublicateGroup.get(name).toString();
                System.out.println(key + " " + value);
            }

            System.out.println("\nОбщий вес\n");
            for (String name : sumWeight.keySet()) {
                String key = name;
                String value = sumWeight.get(name).toString();
                System.out.println(key + " " + value);
            }

            System.out.println("\nМинимальный вес объекта = " + min);

            System.out.println("\nМаксимальный вес объекта = " + max);

        } catch (FileNotFoundException e) {
            throw e;
        }
    }


}