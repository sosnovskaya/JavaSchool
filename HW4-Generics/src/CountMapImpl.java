import java.util.*;

public class CountMapImpl<E> implements CountMap<E> {

    Map<E,Integer> elements;

    public CountMapImpl() {
        this.elements = new HashMap<>();
    }

    @Override
    public void add(E o) {
        if(elements.containsKey(o))
            elements.put(o,elements.get(o) + 1);
        else
            elements.put(o,1);
    }

    @Override
    public int getCount(E o) {
        return elements.get(o) != null ? elements.get(o) : 0;
    }

    @Override
    public int remove(E o) {
        int count = elements.get(o);
        elements.remove(o);
        return count;
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public void addAll(CountMap<E> source) {
        for(E el : source){
            int count = source.getCount(el);
            for (int i = 0; i < count; i++) {
                this.add(el);
            }
        }
    }

    @Override
    public Map<E, Integer> toMap() {
        Map<E,Integer> map = new HashMap<>();
        for (E el : elements.keySet())
            map.put(el,elements.get(el));
        return map;
    }

    @Override
    public void toMap(Map<E, Integer> destination) {
        for (E el : elements.keySet())
            destination.put(el,elements.get(el));
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;
            Object[] list = elements.keySet().toArray();

            @Override
            public boolean hasNext() {
                return index < elements.size() - 1;
            }

            @Override
            public E next() {
                E el = (E) list[index];
                index++;
                return el;
            }
        };
    }
}
