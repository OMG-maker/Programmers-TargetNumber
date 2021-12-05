package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.stream.IntStream;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        int []numbers = {1, 1, 1, 1, 1};
        int answer = solution(numbers, 3);
        System.out.println("답 : " + answer);
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        answer = cal(numbers, target, answer, 0);
        return answer;
    }

    static int cal(int[] numbers, int target, int count, int position){
        int new_count = count;

        int[] new_numbers = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            new_numbers[i] = numbers[i];
        }

        if (position == numbers.length){
            int sum = IntStream.of(new_numbers).sum();

            if(sum == target){
                System.out.println("현재 numbsers : " + Arrays.toString(new_numbers) );
                System.out.println("현재 sum : " + sum );
                new_count++;
            }
        }
        else{
            new_count =  cal(new_numbers, target, new_count, position+1) + cal(change(new_numbers,position), target, new_count, position+1);
        }
        return new_count;
    }

    static int[] change(int[] numbers, int position){
        int[] new_numbers = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            new_numbers[i] = numbers[i];
        }
        new_numbers[position] = new_numbers[position]*(-1);
        return new_numbers;
    }
}
