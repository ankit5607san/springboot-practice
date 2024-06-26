package com.springpractice.streams;

import java.util.List;
import java.util.stream.Collectors;

public class MultipleFieldSortingByStream
{
    public static void main(String[] args)
    {

        //count same integers and print maximum count with that number, if count is similar then print biggest number with its count
        // for example list = 1,2,3,4,5,3,2,4,2,2 = output will be 2 = 4
        // for example list = 1,2,3,4,1,2,3,4,1,2,3,4,4,3,4,3= output will be 4=5
        List<Integer> integers = List.of(1, 2, 3, 4, 4, 5, 5, 5, 3, 4, 2, 4, 3, 5, 1, 1, 3);

        System.out.println(integers.stream().collect(Collectors.groupingBy(integer -> integer, Collectors.counting())).entrySet().stream().min((o1, o2) ->
        {
            if (o1.getValue().compareTo(o2.getValue()) == 0)
            {
                return o2.getKey().compareTo(o1.getKey());
            }
            else
            {
                return o2.getValue().compareTo(o1.getValue());
            }
        }).get());

    }
}
