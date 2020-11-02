public interface SortableList <T extends Comparable> {
    void add(T o);
    void remove(T o);
    void sort();
    void print();
}
