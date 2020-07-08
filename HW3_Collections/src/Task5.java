import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        List<Integer> list = new BackWardList<>();
        //list.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        list.add(1);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    public static class BackwardIterator<T> implements Iterator<T>{

        private List<T> list;
        private int current;
        private boolean isNextCalled;

        public BackwardIterator(List<T> list){
            this.list = list;
            current = list.size();
            isNextCalled = false;
        }

        @Override
        public boolean hasNext() {
            return (0 < current && current <= list.size());
        }

        @Override
        public T next() {
            isNextCalled = true;
            current--;
            return list.get(current);
        }

        @Override
        public void remove() {
            if(current == list.size() || current == -1 || !isNextCalled)
                throw new IllegalStateException();
            list.remove(current);
            isNextCalled = false;
        }
    }

    static class BackWardList<T> extends AbstractList<T> implements Iterable<T>{
        List<T> list;

        public BackWardList() {
            this.list = new ArrayList<>();
        }

        @Override
        public T get(int i) {
            return list.get(i);
        }

        @Override
        public Iterator<T> iterator() {
            return new BackwardIterator<>(list);
        }

        @Override
        public int size() {
            return list.size();
        }
    }
}
