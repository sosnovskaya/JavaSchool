import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        MyStructure<Integer> myStructure = new MyStructure<>(list);
        myStructure.printBackward();
    }

    public static class MyStructure<T>{

        private final List<T> elements = new ArrayList<>();

        public MyStructure(Collection<? extends T> els) {
            elements.addAll(els);
        }

        public void printBackward(){
            Iterator iterator = this.new BackwardIterator<T>();
            while (iterator.hasNext())
                System.out.println(iterator.next() + " ");
        }

        public class BackwardIterator<T> implements Iterator<T>{

            private int current;
            private boolean isNextCalled;

            public BackwardIterator(){
                current = elements.size();
                isNextCalled = false;
            }

            @Override
            public boolean hasNext() {
                return (0 < current && current <= elements.size());
            }

            @Override
            public T next() {
                isNextCalled = true;
                current--;
                return (T) elements.get(current);
            }

            @Override
            public void remove() {
                if(current == elements.size() || current == -1 || !isNextCalled)
                    throw new IllegalStateException();
                elements.remove(current);
                isNextCalled = false;
            }
        }
    }

}
