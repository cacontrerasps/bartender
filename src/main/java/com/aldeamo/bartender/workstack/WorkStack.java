package com.aldeamo.bartender.workstack;

import net.bytebuddy.utility.visitor.StackAwareMethodVisitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WorkStack {
    private int iteracciones;
    private String stack;
    private String numPrimos;



    public WorkStack(int iteracciones, String stack,String numPrimos) {
        this.iteracciones = iteracciones;
        this.stack = stack;
        this.numPrimos=numPrimos;
    }

    public List<String> responseStack(){

        List <String> response= new ArrayList<>();
        List <String> stackB= new ArrayList<String>();
        List <String> stackA= new ArrayList<String>(Arrays.asList(stack.split(",")));
        List <String> primos= new ArrayList<String>(Arrays.asList(numPrimos.split(",")));
        Collections.reverse(stackA);
        for (int i=0;i<iteracciones;i++){
            for(int j=0;j<stackA.size();j++){
                if(Integer.parseInt(stackA.get(j))%Integer.parseInt(primos.get(i))==0){
                    stackB.add(stackA.get(j));
                    stackA.remove(j);
                }
            }
            Collections.sort(stackB,Collections.reverseOrder());
            if(!stackB.isEmpty()) {
                response.add(i, ((i > 0) ? response.get(i - 1) + "," : "") + String.join(",", stackB));
            }
            stackB.clear();
        }
        if(stackA.size()>0){
            response.add(iteracciones, response.get(iteracciones-1)+","+String.join(",",stackA));
        }
        return response;
    }
}
