package day1;

import java.util.stream.IntStream;

public class LRUCacheTester {

    public static void main(String[] args) {
        IntStream.rangeClosed(0,7).forEach(itr->
        LRUCache.add(new Asset(itr,"day1.Asset"+itr)
        ));
        LRUCache.get(new Asset(3,"day1.Asset"+3));
        LRUCache.get(new Asset(7,"day1.Asset"+7));
        LRUCache.get(new Asset(6,"day1.Asset"+6));
        LRUCache.get(new Asset(5,"day1.Asset"+5));
        IntStream.rangeClosed(8,15).forEach(itr->
                LRUCache.add(new Asset(itr,"day1.Asset"+itr)
                ));
    }

}

