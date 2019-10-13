public class LinkedListDeque<Item> {
    private LinkNode sentinel;
    private int size;

    public class LinkNode {
        private Item value;
        private LinkNode prev, after;
        public LinkNode(Item x) {
            value = x;
        }
        public Item getRecursive(int index) {
            if (index > 0) {
                return after.getRecursive(index - 1);
            } else {
                return value;
            }
        }
    }

    public LinkedListDeque() {
        sentinel = new LinkNode(null);
        sentinel.prev = sentinel;
        sentinel.after = sentinel;
        size = 0;
    }

    public void addFirst(Item x) {
        LinkNode newNode = new LinkNode(x);
        if (this.isEmpty()) {
            sentinel.after = newNode;
            sentinel.prev = newNode;
            newNode.after = sentinel;
            newNode.prev = sentinel;
            size = 1;
            return;
        }
        newNode.after = sentinel.after;
        newNode.prev = sentinel;
        newNode.after.prev = newNode;
        newNode.prev.after = newNode;
        size = size + 1;
    }
    public void addLast(Item x) {
        LinkNode newNode = new LinkNode(x);
        if (this.isEmpty()) {
            sentinel.after = newNode;
            sentinel.prev = newNode;
            newNode.after = sentinel;
            newNode.prev = sentinel;
            size = 1;
            return;
        }
        newNode.after = sentinel;
        newNode.prev = sentinel.prev;
        newNode.after.prev = newNode;
        newNode.prev.after = newNode;
        size = size + 1;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return this.size;
    }
    public void printDeque() {
        LinkNode pointer = sentinel.after;
        while (pointer.after != sentinel) {
            System.out.print(pointer.value);
            System.out.print(" ");
            pointer = pointer.after;
        }
        System.out.print(pointer.value);
        System.out.print(" ");
    }
    public Item removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        LinkNode returnLinkNode;
        if (size == 1) {
            returnLinkNode = sentinel.after;
            sentinel.after = sentinel;
            sentinel.prev = sentinel;
            size = size - 1;
            return returnLinkNode.value;
        }
        LinkNode begone = sentinel.after;
        returnLinkNode = begone;
        sentinel.after = begone.after;
        begone.after.prev = sentinel;
        size = size - 1;
        return returnLinkNode.value;
    }
    public Item removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        LinkNode returnLinkNode;
        if (size == 1) {
            returnLinkNode = sentinel.after;
            sentinel.after = sentinel;
            sentinel.prev = sentinel;
            size = size - 1;
            return returnLinkNode.value;
        }
        LinkNode begone = sentinel.prev;
        returnLinkNode = begone;
        sentinel.prev = begone.prev;
        begone.prev.after = sentinel;
        size = size - 1;
        return returnLinkNode.value;
    }
    public Item get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        LinkNode p = sentinel.after;
        while (index != 0) {
            p = p.after;
            index = index - 1;
        }
        return p.value;
    }
    public Item getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Item targetvalue = sentinel.after.getRecursive(index);
        return targetvalue;
    }
}
