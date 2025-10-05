package day1;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class LRUCache {

    // size is 10
    static final private Queue<Asset> memory = new LinkedList<>();
    static Integer size = 0;
    // add: add new object in cache, take out the least recently used and then add, on top of the queue
    // remove: remove will always remove from top, which is least recently used
    // get: when you are calling the get function, we have to put on the top of the queue
    // utility method to the fill the list with sample elements

    static public void add(Asset asset) {
        if (size >= 9) {
            //remove least recently used and add
            memory.remove();
            memory.add(asset);
        } else {
            // else add simply
            memory.add(asset);
            size++;
        }
        System.out.println(memory.toString());
    }

    static public Optional<Asset> remove() {
        Optional<Asset> resOptional = Optional.empty();
        if (size > 0) {
            resOptional = Optional.of(memory.poll());
        }
        System.out.println(memory.toString());
        return resOptional;
    }

    // first check: 1 queue not empty,
    // element exists and if found bring to the top of the queue
    static public Optional<Asset> get(Asset asset) {
        Optional<Asset> resOptional = Optional.empty();
        if (size > 0) {
            //1. check if element exists
            boolean elementFound = memory.contains(asset);

            if (elementFound) {
                //2. if exits bring to the top, pushing all elements down the queue
                // and return the same
                memory.remove(asset);
                memory.offer(asset);
                resOptional = Optional.of(asset);
            }
        }
        System.out.println(memory.toString());
        return resOptional;
    }



}

