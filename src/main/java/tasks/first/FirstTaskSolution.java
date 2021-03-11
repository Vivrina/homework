package tasks.first;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class FirstTaskSolution implements FirstTask {
    @Override
    public String breadthFirst(boolean[][] adjacencyMatrix, int startIndex) {
        ArrayDeque<Integer> enter = new ArrayDeque<>();
        enter.addFirst(startIndex);
        ArrayList<Integer> love = new ArrayList<>();

        for (int i=0; i<adjacencyMatrix.length; i++){
            for (int j=0; j<adjacencyMatrix.length; j++){
                if (adjacencyMatrix[enter.getFirst()][j]){
                    if (!love.contains(j) & !enter.contains(j)){
                        enter.addLast(j);
                    }
                }
            }
            love.add(enter.pop());

        }

        String input = love.toString();
        input = input.substring(1, input.length()-1);

        return input;

    }

    @Override
    public Boolean validateBrackets(String s) {
        ArrayDeque<Character> hooks = new ArrayDeque<>();

        for (int i=0; i<s.length(); i++){
            switch (s.charAt(i)) {
                case '(':
                    hooks.addLast(s.charAt(i));
                    break;
                case ')':
                    if (hooks.getLast() == '(') {
                        hooks.removeLast();
                    } else return false;
                    break;
                case '{':
                    hooks.addLast(s.charAt(i));
                    break;
                case '}':
                    if (hooks.getLast() == '{') {
                        hooks.removeLast();
                    } else return false;
                    break;
                case '[':
                    hooks.addLast(s.charAt(i));
                    break;
                case ']':
                    if (hooks.getLast() == '[') {
                        hooks.removeLast();
                    } else return false;
                    break;

            }

        }

        return  true;
    }



    @Override
    public Long polishCalculation(String s) {
        ArrayDeque<Long> numbers = new ArrayDeque<>();
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 48) && (s.charAt(i) <= 57)) {
                temp = temp + s.charAt(i);
            }
            else if ((s.charAt(i) == 32)){
                if((s.charAt(i-1) >= 48) && (s.charAt(i-1) <= 57)) {
                    putNumber(temp, numbers);
                    temp = "";
                }
            } else {
                calculate(s.charAt(i), numbers);
                temp = "";
            }
        }
        return numbers.pop();
    }

    public void putNumber(String temp, ArrayDeque<Long> nums){
        long number = 0;
        long k = 1;
        for(int i = temp.length()-1; i >= 0; i--){
            number = number + (temp.charAt(i)-48)*k;
            k=k*10;
        }
        nums.addFirst(number);
    }

    public void calculate(char op, ArrayDeque<Long> numbers){
        long a = numbers.pop();
        long b = numbers.pop();
        switch(op){
            case('+'):{
                long c = a+b;
                numbers.addFirst(c);
                break;
            }
            case('-'):{
                long c = a-b;
                numbers.addFirst(c);
                break;
            }
            case('*'):{
                long c = a*b;
                numbers.addFirst(c);
                break;
            }
            case('/'):{
                long c = a/b;
                numbers.addFirst(c);
                break;
            }
        }
    }
}
