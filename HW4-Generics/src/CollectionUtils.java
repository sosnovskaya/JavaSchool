import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {

public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
    destination.addAll(source); }

public static <T> List<T> newArrayList() {
    return new ArrayList<>();
}

public static <T> int indexOf(List<T> source, T t) {
    return source.indexOf(t);
}

public static <T> List<T> limit(List<? extends T> source, int size) {
    return new ArrayList<>(source.subList(0,size));
}

public static <T> void add(List<? super T> source, T t) {
    source.add(t);
}

public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
    removeFrom.removeAll(c2);
}

public static <T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
    return c1.containsAll(c2);
}

public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
    for(T t: c2){
        if(c1.contains(t))
            return true;
    }
    return false;
}

public static <T extends Comparable<? super T>> List range(List<? extends T> list, T min, T max) {
    Comparator<T> comparator = new Comparator<T>() {
        @Override
        public int compare(T t, T t1) {
            return t.compareTo(t1);
        }
    };
    Collections.sort(list,comparator);
    return list.subList(list.indexOf(min),list.indexOf(max));
}

public static <T> List range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
    Collections.sort(list,comparator);
    return list.subList(list.indexOf(min),list.indexOf(max));
}

}