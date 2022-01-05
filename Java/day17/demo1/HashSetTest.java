package Java.day17.demo1;

import java.util.HashSet;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<Person> hashSet = new HashSet<Person>();
        hashSet.add(new Person("洛天依", 15));
        hashSet.add(new Person("言和", 17));
        hashSet.add(new Person("阿绫", 16));
        hashSet.add(new Person("乐正龙牙", 20));
        hashSet.add(new Person("阿绫", 16));
        hashSet.add(new Person("乐正龙牙", 20));

        for(Person p : hashSet){
            System.out.println(p);
        }
    }
}
