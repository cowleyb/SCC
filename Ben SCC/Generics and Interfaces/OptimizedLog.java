import java.util.Collection;
import java.util.Iterator;
import java.nio.channels.UnsupportedAddressTypeException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.*;

public class OptimizedLog<E> implements Collection<E>
{
    private static int defaultSize = 10;
    private static final int MAX_ARRAY_SIZE = 5000;

    private int size = 0;
    private Object[] data;
    private Date[] dateTime;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final Date[] EMPTY_DATE = {};
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");


    public OptimizedLog()
    {
        this.data = EMPTY_ELEMENTDATA;
        this.dateTime = EMPTY_DATE;
    }
    
   public int size() {
      return size;
   }
   public boolean isEmpty() {
    return size() == 0;
    }

   public boolean add(E e) {
    
    int oldCapacity = data.length;
    int newCapacity = oldCapacity +  1;
    data = Arrays.copyOf(data, newCapacity);
    data[size++] = e;
    return true;
    }

   public  boolean remove(Object o){
       throw new UnsupportedOperationException();
   }

   public boolean contains(Object o){
    for (Object h : data) {
        if (o == h) {
            return true;
        } 
    }
    return false;
   }

   public boolean containsAll(Collection<?> c) {
    for (Object h : c)
    if (!contains(h))
        return false;
    return true;
   }

   public boolean addAll(Collection<? extends E> c) {
    boolean modified = false;
    for (E e : c)
        if (add(e))
            modified = true;
    return modified;
   }

   public void clear() {
    data = EMPTY_ELEMENTDATA; 
}

   public boolean equals(Object o) {
    if (o == this)
        return true;
    if (!(o.getClass() != data.getClass()))
        return false;
    return true; 
    }

   public int hashCode() {
    int hashCode = 1;
    //Found in documentation for collection
    for (E e : this)
        hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
    return hashCode;
   }

    public  boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }


    public  boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray() {
        return data;
    }

    public <T> T[] toArray(T[] a) {
        //T[] h = a;
        return a;
    }

    public String toString() {
        return "";
    }

    public Iterator<E> iterator() {
        return (new Iteratorr());
    }

    public class Iteratorr<E> implements Iterator<E> {
        private int cursor = 0;
    
            public boolean hasNext() {
                return cursor != size();
            }
    
            public E next() {
                if (!hasNext()) {
                    //throw new NoSuchElementException();
                }
                return (E)data[cursor++];
            }
    }

          
}