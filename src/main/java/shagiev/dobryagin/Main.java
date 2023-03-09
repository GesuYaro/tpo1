package shagiev.dobryagin;

import shagiev.dobryagin.functions.ArctgFunction;

public class Main {
    public static void main(String[] args) {
        var arctgFunction = new ArctgFunction();
        double res = arctgFunction.calculate(1, 10);
        System.out.println(res);
    }
}