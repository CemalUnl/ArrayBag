package Array;
import java.util.*;
/**
 * An implementation of the Bag ADT using an array.
 */
public class ArrayBag implements Bag {
    /**
     * The array used to store the items in the bag.
     */
     private Object[] items; // tanımla düzeltidi

    /**
     * The number of items in the bag.
     */
    private int numItems;

    public static final int DEFAULT_MAX_SIZE = 50; // büyük harflerle yazılmalı

    /**
     * Constructor with no parameters - creates a new, empty ArrayBag with
     * the default maximum size.
     */
    public ArrayBag() {
        this.items = new Object[DEFAULT_MAX_SIZE]; // Constructora item eklendi
        this.numItems = 0;
    }

    /**
     * A constructor that creates a new, empty ArrayBag with the specified
     * maximum size.
     */
    public ArrayBag(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize must be > 0");
        }
        this.items = new Object[maxSize];
        this.numItems = 0;
    }

    /**
     * numItems - accessor method that returns the number of items
     * in this ArrayBag.
     */
    public int num_items() {
        return this.numItems;
    }

    /**
     * add - adds the specified item to this ArrayBag. Returns true if there
     * is room to add it, and false otherwise.
     * Throws an IllegalArgumentException if the item is null.
     */
    public boolean add(Object item) {
       if (item == null)
            throw new IllegalArgumentException("item must be non-null");
        if (numItems == items.length)  // else if kaldırıldı ve thisler silindi.
            return false;              // no more room!
        else {
            items[numItems] = item;
            numItems++;
            return true;
}
    }

    /**
     * remove - removes one occurrence of the specified item (if any)
     * from this ArrayBag.  Returns true on success and false if the
     * specified item (i.e., an object equal to item) is not in this ArrayBag.
     */
    public boolean remove(Object item) {  // thisler silindi
        for (int i = 0; i < numItems; i++) {
            if (items[i].equals(item)) {
                // Shift the remaining items left by one.
                for (int j = i; j < numItems - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[numItems - 1] = null;

                numItems--;
                return true;
            }
        }

        return false;  // item not found
    }

    /**
     * contains - returns true if the specified item is in the Bag, and
     * false otherwise.
     */
    public boolean contains(Object item) {
         for (int i = 0; i < numItems; i++) {
            if (items[i] != null && items[i].equals(item)) // if sorgusu düzeltidi
                return true;
        }
        
        return false;
    }

    /**
     * containsAll - does this ArrayBag contain all of the items in
     * otherBag?  Returns false if otherBag is null or empty.
     */
    public boolean containsAll(Bag otherBag) {
        if (otherBag == null || otherBag.num_items() == 0) {
            return false;
        }

          
        Object[] otherItems = otherBag.toArray();
        for (int i = 0; i < otherItems.length; i++) {
            if (! this.contains(otherItems[i])) {
                return false;
            }
        }
        
        return true;
    }

    /**
     * grab - returns a reference to a randomly chosen item in this ArrayBag.
     */
    public Object grab() {
        if (this.numItems == 0) {
            throw new IllegalStateException("the bag is empty");
        }

        int whichOne = (int)(Math.random() * this.numItems);
        return this.items[whichOne];
    }

    /**
     * toArray - return an array containing the current contents of the bag
     */
    public Object[] toArray() {
        Object[] copy = new Object[this.numItems];

        for (int i = 0; i < this.numItems; i++) {
            copy[i] = this.items[i];
        }

        return copy;
    }

    /**
     * toString - converts this ArrayBag into a string that can be printed.
     * Overrides the version of this method inherited from the Object class.
     */
    public String toString() {  // to string methodu güncellendi
        String str = "{";
        
        for (int i = 0; i < numItems; i++)
            str = str + " " + items[i];
        str = str + " }";
        
    return str;
    }


}