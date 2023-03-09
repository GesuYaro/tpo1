package shagiev.dobryagin;

import shagiev.dobryagin.functions.ArctgFunction;

public class Main {
    public static void main(String[] args) {
        ArctgFunction arctgFunction = new ArctgFunction();
        double res = arctgFunction.calculate(2, 100);
        System.out.println(res);
    }
}