package HomeTask1Collections;

public class GenericMyArrayList<E extends Comparable<E>> implements MyArray<E> {
    private E[] data; // массив
    private static final int DEFAULT_SIZE = 10; // кол-во записей по умолчанию
    private int currentSize; // кол-во значений в массиве
    private boolean sortFlg; // флаг отсортированности массива

    public GenericMyArrayList() { // пустой конструктор, создает массив с размерностью по умолчанию.
        this.data = (E[]) new Comparable[DEFAULT_SIZE];
        this.currentSize = 0; // счетчик количества элементов на 0
        this.sortFlg = false; // Флаг сортировки false,
    }
    public GenericMyArrayList(E ... arr) { //Конструктор, принимающий какую-то коллекцию в качестве аргумента
        if (arr.length >= DEFAULT_SIZE) { // если входной массив по размеру больше или равен дефолтному, то содаем сразу с бОльшей размерностью
            this.data = (E[]) new Comparable[arr.length];
        } else {
            this.data = (E[]) new Comparable[DEFAULT_SIZE];
        }
        this.addAll(arr); //вызываем метод для добавления множества значений.
        this.sortFlg = false;
    }

    public void addAll(E ... arr) { // Добавляет несколько значений
        for (int i = 0; i < arr.length; i++) {
            this.add(arr[i]); // Вызывает метод добавления по одному элементу. Счетчик меняется там
        }
        this.sortFlg = false;
    }

    public void add (E value) { //Добавление одного элемента
        if (currentSize == data.length) { // если кол-во значений уже равно размеру массива, то создаем новый, бОльший по размеру
            E[] newData = (E[]) new Comparable[data.length + (data.length/2 + 1)];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        data[currentSize] = value;
        this.currentSize++;
        this.sortFlg = false;

    }

    /*public void add (E value, int index) { //Добавление одного элемента по индексу
        E[] newData;
        if (currentSize == data.length) { // если кол-во значений уже равно размеру массива, то создаем новый, бОльший по размеру
            newData = (E[]) new Comparable[data.length + (data.length/2 + 1)];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
        } else {
            newData = (E[]) new Comparable[data.length];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
        }

        if (index == 0) {
            for (int i = currentSize - 1; i > 0 ; i--) {

            }
        } else if (index == currentSize - 1) {

        } else {
            for (int i = currentSize - 1; i > index ; i--) {
                E temp = newData[i];
                newData[i + 1] = temp;
                newData[i] = newData[i - 1];
            }
            newData[index] = value;
        }
        data = newData;
        currentSize++;
    }*/

    public void printList () { //пробегается по массиву, выводит на экран
        System.out.print("[");
        for (int i = 0; i < currentSize; i++) {
            if (i != currentSize - 1) {
                System.out.print(data[i] + ", " );
            } else {
                System.out.print(data[i]);
            }

        }
        System.out.print("]");
        System.out.println();
    }

    public void remove(int index) { // Удаление одного элемента
        E[] newData = (E[]) new Comparable[data.length]; //Создание нового массива

        for (int i = 0; i < index; i++) { //Копирование в новый массив все до индекса
            newData[i] = data[i];
        }
        for (int i = index + 1; i < currentSize; i++) { // Копирование в новый массив все после индекса
            newData[i-1] = data[i];
        }

        data = newData;
        currentSize--; // Уменьшаем счетчик записей
    }

    public void remove(int index, int count) { // Удаление нескольких элементов начиная с индекса
        E[] newData = (E[]) new Comparable[data.length]; // создание нового массива
        if (index == 0) { // отдельный случай для удаления с первого эл-та
            for (int i = count; i < currentSize; i++) {
                newData[i-count] = data[i];
            }
        } else if (count > (currentSize - index)) { // Если человек указал индекс и кол-во элементов больше, чем осталось, то копируем в новый массив только до индекса
            for (int i = 0; i < index; i++) {
                newData[i] = data[i];
            }
        } else {
            for (int i = 0; i < index; i++) {
                newData[i] = data[i];
            }
            for (int i = index + count; i < currentSize; i++) {
                newData[i-count] = data[i];
            }
        }

        data = newData;
        currentSize = currentSize - count; // уменьшаем счетчик записей
    }

    public void removeLast() { //удаление последнего элемента
        this.remove(currentSize - 1); //вызов метода Remove, удаляющего по индексу
    }

    public void clear() { //метод очистки массива. По сути создает новый пустой с дефолтным размером, зануляет счетчик
        data = (E[]) new Comparable[DEFAULT_SIZE];
        currentSize = 0;
    }

    public void reverse() { //Перевернуть массив
        E[] newData = (E[]) new Comparable[data.length]; // создание нового массива
        int y = currentSize - 1;
        for (int i = 0; i < currentSize; i++) {
            newData[y] = data[i];
            y--;
        }
        data = newData;
        this.sortFlg = false;
    }

    public int findIndex(E value) { // ищет элемент по значению. Если находит, возвращает индекс первого вхождения. Если нет, возвращает -1
        for (int i = 0; i < data.length; i++) {
            if (value.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean find(E value){ //ищет элемент во значению. Возвращает тру или фолс без индекса
        for (E datum : data) {
            if (value.equals(datum)) {
                return true;
            }
        }
        return false;
    }

    static void sort(GenericMyArrayList inArr) { // СТАТИЧЕСКИЙ метод сортировки. Получает на вход массив.
        for (int i = 0; i < inArr.getCurrentSize(); i++) {
            for (int j = 0; j < inArr.getCurrentSize() - i - 1; j++) {
                Comparable a = inArr.getData()[j +1];
                Comparable b = inArr.getData()[j];
                if (a.compareTo(b) < 0) {
                    Comparable temp = inArr.get(j);
                    inArr.set(j, inArr.getData()[j + 1]);
                    inArr.set(j + 1, temp);
                }
            }
        }
        inArr.setSortFlg(true);
    }

    public void sort() { //Метод сортировки пузырьком. В конце меняет флаг сортировки
        if (!this.sortFlg) {
            for (int i = 0; i < currentSize; i++) {
                for (int j = 0; j < currentSize - i - 1; j++) {
                    if (data[j + 1].compareTo(data[j]) < 0) {
                        swap(j, j + 1);
                    }
                }
            }
            this.sortFlg = true;
        }
    }

    public void swap (int indexA, int indexB) { //меняет местами 2 элемента в коллекции
        E temp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = temp;
    }

    public int getCurrentSize() { //геттер для текущего размера
        return currentSize;
    }

    public E get(int index) { //Получение элемента по индексу
        return data[index];
    }

    public E[] getData() { //получение массива
        return data;
    }

    public void set(int index, E value) { //установка значения по индексу
        this.data[index] = value;
    }

    public void setSortFlg(boolean flg) { //принудительная смена флага
        this.sortFlg = flg;
    }
}
