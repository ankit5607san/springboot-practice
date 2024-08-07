package com.springpractice.streams;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AlgorithmPractices
{
    public static void main(String[] args)
    {
        /*List<Integer> runs = List.of(1, 4, 4, 4, 5, 3);

        System.out.println(migratoryBirds(runs));*/

        /*
        List<Integer> prices = List.of(3, 10, 2, 9);

        int k = 1; // index not ate item

        int contribution = 12; // contributed by anna

        * */

        /*
        countApplesAndOranges(7, 10, 4, 12, List.of(2, 3, -4), List.of(2, -2, -4));
        * */

        // write program to find no of 'a' from given string repeating upto defined n number
        /*System.out.println(repeatedString("kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm", 23405L));*/

    }

    public static long repeatedString(String s, Long n)
    {
        // Handle base cases
        if (s.length() == 1)
        {
            return s.charAt(0) == 'a' ? n : 0;
        }

        // Count 'a' occurrences in the original string
        long aCountInS = s.chars().filter(c -> c == 'a').count();

        // Calculate repetitions of the entire string
        long repetitions = n / s.length();

        // Calculate remaining length after repetitions
        long remaining = n % s.length();

        // Total count = 'a' in repetitions * count in string + 'a' in remaining substring
        return repetitions * aCountInS + s.chars().limit((int) remaining).filter(c -> c == 'a').count();
    }

    public static void bonAppetit(List<Integer> bill, int k, int b)
    {
        /*int sum = bill.stream().filter(value -> !Objects.equals(value, bill.get(k))).mapToInt(Integer::intValue).sum();

        int result = b - (sum/2);*/

        int summation = 0;

        for (int index = 0; index < bill.size(); index++)
        {
            if (index != k)
            {
                summation += bill.get(index);
            }
        }

        int result = b - (summation / 2);

        if (result == 0)
        {
            System.out.println("Bon Appetit");
        }
        else
        {
            System.out.println(result);
        }
    }

    public static int migratoryBirds(List<Integer> arr)
    {
        // Write your code here
        int counter = 0;

        Map<Integer, Integer> map = new HashMap<>();

        arr.stream().collect(Collectors.groupingBy(Integer::intValue)).forEach((key, value) ->
                map.put(key, value.size()));

        counter = map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).findFirst().get().getKey();

        return counter;
    }

    public static int divisibleSumPairs(int n, int k, List<Integer> ar)
    {
        // Write your code here
        int counter = 0;

        for (int index = 0; index <= (n - 1); index++)
        {
            for (int j = index + 1; j < ar.size(); j++)
            {
                System.out.println(ar.get(index) + " | " + ar.get(j) + " | " + ((ar.get(index) + ar.get(j)) % k));
                if (((ar.get(index) + ar.get(j)) % k) == 0)
                {
                    ++counter;
                }
            }
        }
        return counter;
    }

    public static int birthday(List<Integer> s, int d, int m)
    {
        int counter = 0;

        for (int index = 0; index <= s.size() - 1; index++)
        {
            if (s.size() != 1)
            {
                if (s.subList(index, Math.min(index + m, s.size())).stream().mapToInt(Integer::intValue).sum() == d)
                {
                    ++counter;
                }
            }
            else
            {
                for (Integer i : s)
                {
                    if (i == d)
                    {
                        ++counter;
                    }
                }
            }

        }

        return counter;
    }

    public static void countApplesAndOranges(int s, int t, int a, int o, List<Integer> apples, List<Integer> oranges)
    {

        long counter = 0;

        for (Integer apple : apples)
        {
            if ((apple + a) >= s && (apple + a) <= t)
            {
                ++counter;
            }
        }

        System.out.println(counter);

        counter = 0;

        for (Integer orange : oranges)
        {
            if ((orange + o) <= t && (orange + o) >= s)
            {
                ++counter;
            }
        }

        System.out.println(counter);
        /*
        long appleCounter = apples.stream().filter(apple -> (a + apple) >= s && (a+apple) <= t).count();

        System.out.println(appleCounter);

        long orangeCounter = oranges.stream().filter(orange -> (o + orange) >= a && (o+orange) <= t).count();

        System.out.println(orangeCounter);*/
    }
}
