public class ArrayDeque<Item>  {
    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    public ArrayDeque() {
        items  =  (Item[]) new Object[8];
        nextFirst = 4;
        nextLast = 5;
        size = 0;
    }
    private void resize(int newlength) {
        Item[] newarray = (Item[]) new Object[newlength];
        if (nextFirst < nextLast) {
            System.arraycopy(items, nextFirst + 1, newarray, 0, size);
            nextFirst = newlength - 1;
            nextLast = size;
            items = newarray;
        } else {
            if (nextLast != 0) {
                System.arraycopy(items, 0, newarray, 0, nextLast);
            }
            if (nextFirst != (items.length - 1)) {
                System.arraycopy(items, nextFirst + 1,
                    newarray, newlength + nextLast - size, size - nextLast);
            }
            nextFirst = nextFirst + newlength - items.length;
            items = newarray;
        }
    }
    public void addFirst(Item x) {
        if (nextFirst == nextLast) {
            resize(2 * items.length);
        }
        if (nextFirst == 0) {
            items[nextFirst] = x;
            nextFirst = items.length - 1;
            size = size + 1;
            return;
        } else {
            items[nextFirst] = x;
            nextFirst = nextFirst - 1;
            size = size + 1;
        }
    }
    public void addLast(Item x) {
        if (nextFirst == nextLast) {
            resize(2 * items.length);
        }
        if (nextLast == items.length - 1) {
            items[nextLast] = x;
            nextLast = 0;
            size = size + 1;
            return;
        } else {
            items[nextLast] = x;
            nextLast = nextLast + 1;
            size = size + 1;
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        int counter  =  0;
        while (counter < size) {
            System.out.print(get(counter));
            System.out.print(" ");
            counter = counter + 1;
        }
    }
    public Item removeFirst() {
        if (size == 0) {
            return null;
        }
        if (items.length >= 16 && (size < 0.30 * items.length)) {
            resize(size * 2);
        }
        if (nextFirst == items.length - 1) {
            nextFirst = 0;
            size = size - 1;
            return items[nextFirst];
        } else {
            nextFirst = nextFirst + 1;
            size = size - 1;
            return items[nextFirst];
        }
    }
    public Item removeLast() {
        if (size == 0) {
            return null;
        }
        if (items.length >= 16 && (size < 0.30 * items.length)) {
            resize(size * 2);
        }
        if (nextLast == 0) {
            nextLast = items.length - 1;
            size = size - 1;
            return items[nextLast];
        } else {
            nextLast = nextLast - 1;
            size = size - 1;
            return items[nextLast];
        }
    }
    public Item get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        int number  =  nextFirst + index + 1;
        if (number >= items.length) {
            return items[number - items.length];
        } else {
            return items[number];
        }
    }
}
