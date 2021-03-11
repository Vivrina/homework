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
        return null;
    }
}
