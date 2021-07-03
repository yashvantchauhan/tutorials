package org.yash.data.structure;

import java.util.*;
import java.util.stream.Collectors;

public class RecurringElement {

    public Integer findFirstRecurringElement(Integer elements[]){
        TreeMap<Integer, Integer> recurringIndex= new TreeMap<>();

      /*  Arrays.stream(elements).sequential().forEach(el->{
            if(recurringIndex.get(el)!=null){

            }
        });*/

        for(int i=0; i<elements.length-1;i ++){
            for (int j=i+1; j<elements.length; j++){
                if(elements[i]==elements[j] && recurringIndex.get(elements[i])==null){
                    recurringIndex.put( j, elements[i]);
                }
            }
        }
        System.out.println(recurringIndex);
        return recurringIndex.size()>0?recurringIndex.get(recurringIndex.firstKey()): null;



    }

    public static void main(String[] args) {

        RecurringElement recurringElement = new RecurringElement();
        Scanner scanner= new Scanner(System.in);

        String newLine= scanner.nextLine();
        while(!newLine.equals("exit")){
            List<Integer> array=Arrays.stream(newLine.split(",")).map(str-> Integer.parseInt(str)).collect(Collectors.toList());

            Integer iArray[]=array.toArray(new Integer[array.size()]);

            System.out.println("First recurring "+recurringElement.findFirstRecurringElement(iArray));

             newLine= scanner.nextLine();
        }




    }
}
