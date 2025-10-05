package day1;

import java.util.Comparator;
import java.util.PriorityQueue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //sorted elements in the Priority que
    //Kth largest element
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        priorityQueue.add(123);
        priorityQueue.add(12);
        priorityQueue.add(6);
        priorityQueue.add(5);
        priorityQueue.add(61);
        priorityQueue.add(51);
        priorityQueue.forEach(element->System.out.print(element+"\t"));
        Integer pos =3;
        Integer nthLargestElement = getNthLargestElement(pos,priorityQueue);
        System.out.println("\n Result is: "+nthLargestElement);

    }

    private static Integer getNthLargestElement(Integer pos, PriorityQueue<Integer> priorityQueue) {
        //return priorityQueue.stream().limit(pos).findFirst().get();
        Integer result=0;
        for(int itr=0;itr<pos;itr++){
            result=priorityQueue.poll();
        }
        return result;
    }
}