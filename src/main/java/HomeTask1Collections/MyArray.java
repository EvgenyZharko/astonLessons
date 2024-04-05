package HomeTask1Collections;

public interface MyArray<E> {

  void add(E value);
  void addAll(E ... arr);
  void printList ();
  void remove(int index);
  void remove(int index, int count);
  void removeLast();
  void clear();
  void reverse();
  int findIndex(E value);
  boolean find(E value);
  void sort();
  void swap (int indexA, int indexB);
  int getCurrentSize();
  E get(int index);

}
