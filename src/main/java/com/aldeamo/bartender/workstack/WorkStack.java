package com.aldeamo.bartender.workstack;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WorkStack {
    private int iteracciones;
    private String stack;
    private String numPrimos;


    public WorkStack(int iteracciones, String stack, String numPrimos) {
        this.iteracciones = iteracciones;
        this.stack = stack;
        this.numPrimos = numPrimos;
    }

    public List<String> responseStack() {
        List<String> response = new ArrayList<>();
        List<String> stackB = new ArrayList<String>();
        List<String> stackA = new ArrayList<String>(Arrays.asList(stack.split(",")));
        List<String> primos = new ArrayList<String>(Arrays.asList(numPrimos.split(",")));
        int j;
        for (int i = 0; i < this.iteracciones; ++i) {
            j = stackA.size() - 1;
            while (stackA.size() > 0) {
                if (j < 0) break;
                if (Integer.parseInt(stackA.get(j)) % Integer.parseInt(primos.get(i)) == 0) {
                    stackB.add(stackA.get(j));
                    stackA.remove(j);
                }
                --j;
            }
            response.add(String.join(",", stackB));
        }
        if (stackA.size() > 0) {
            stackB.add(String.join(",", stackA));
            response.add(String.join(",", stackB));
        }
        response.removeAll(Arrays.asList("", null));
        return response;
    }
}
