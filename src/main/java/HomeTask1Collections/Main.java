package HomeTask1Collections;

public class Main {
    public static void main(String[] args) {
        GenericMyArrayList<Integer> a = new GenericMyArrayList<>();
//        GenericMyArrayList<Integer> a2 = new GenericMyArrayList<>(1, 3, 4, 5, 6, 2);
//        a2.printList();
//        GenericMyArrayList<String> b = new GenericMyArrayList<>();
//        GenericMyArrayList<Date> c = new GenericMyArrayList<>();
//        GenericMyArrayList<MyArrayList> d = new GenericMyArrayList<>();

        testA(a);
//        testSortA(a);
//        testSortB(b);
//        testB(b);
//        testSortStatic();

    }

    private static void testSortStatic() {
        GenericMyArrayList<Integer> a = new GenericMyArrayList<>();
        a.add(1);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(2);
        System.out.println("До сортировки");
        a.printList();

        GenericMyArrayList.sort(a);
        System.out.println("После сортировки");
        a.printList();
    }

    private static void testSortB(GenericMyArrayList<String> b) {
        b.add("a");
        b.add("c");
        b.add("b");
        b.add("f");
        b.add("d");
        b.add("g");

        b.sort();
        b.printList();
        b.sort();
    }

    private static void testSortA(GenericMyArrayList<Integer> a) {
        a.add(1);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(2);
        System.out.println("До сортировки");
        a.printList();

        a.sort();
        System.out.println("После сортировки");
        a.printList();
    }

    private static void testB(GenericMyArrayList<String> b) {
        b.add("abc1");
        b.add("abc2");
        b.add("abc3");
        b.add("abc4");
        b.add("abc5");
        b.add("abc6");
        b.add("abc7");
        b.add("abc8");
        b.add("abc9");
        b.add("abc10");
        b.add("abc11");
        b.add("abc12");
        b.add("abc13");
        b.add("abc14");
        b.add("abc15");


        b.printList();

        b.remove(0);
        b.printList();

        b.remove(5);
        b.printList();

        b.remove(0, 3);
        b.printList();

        b.remove(5, 3);
        b.printList();

        b.removeLast();
        b.printList();

        b.reverse();
        b.printList();

        b.swap(1, 4);
        b.printList();

        System.out.println(b.getCurrentSize());
        System.out.println(b.get(2));

        System.out.println(b.findIndex("abc6"));
        System.out.println(b.findIndex("eqweqweqweqweqwe"));

        System.out.println(b.find("abc6"));
        System.out.println(b.find("rwepoipoigd"));

        b.clear();
        b.printList();

        b.add("abc5");
        b.add("abc6");
        b.add("abc7");
        b.add("abc8");
        b.add("abc9");
        b.add("abc10");
        b.add("abc11");
        b.add("abc12");
        b.add("abc13");
        b.add("abc14");
        b.printList();
    }

    private static void testA(GenericMyArrayList<Integer> a) {
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        a.add(9);
        a.add(10);
        a.add(11);
        a.add(12);
        a.add(13);
        a.add(14);
        a.add(15);
        a.add(16);
        a.add(17);

        a.printList();

        a.remove(0);
        a.printList();

        a.remove(15);
        a.printList();

        a.remove(0, 3);
        a.printList();

        a.remove(5, 5);
        a.printList();

        a.removeLast();
        a.printList();

        a.reverse();
        a.printList();

        a.swap(1, 4);
        a.printList();

        System.out.println(a.getCurrentSize());
        System.out.println(a.get(2));

        System.out.println(a.findIndex(8));
        System.out.println(a.findIndex(354));

        System.out.println(a.find(123123));
        System.out.println(a.find(5));

        a.clear();
        a.printList();

        a.addAll(1, 2, 45, 6, 8, 0, 111, 3, 9, 10);
        System.out.println("До сортировки");
        a.printList();
        System.out.println("После сортировки");
        a.sort();
        a.printList();
    }
}
