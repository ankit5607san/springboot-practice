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
}
