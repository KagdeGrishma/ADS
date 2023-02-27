// IMPLEMENTATION

import java.util.LinkedList;


public class PriorityQueueUsingList<T extends Comparable<T>> {
    private LinkedList<T> items;

        public PriorityQueueUsingList() {
            items = new LinkedList<>();
        }

        public void enqueue(T item) {
            if (items.isEmpty()) {
                items.add(item);
            } else {
                boolean added = false;
                for (int i = 0; i < items.size(); i++) {
                    if (item.compareTo(items.get(i)) > 0) {
                        items.add(i, item);
                        added = true;
                        break;
                    }
                }
                if (!added) {
                    items.addLast(item);
                }
            }
        }

        public T remove() {
            if (items.isEmpty()) {
                throw new IllegalStateException("Priority queue is empty.");
            }
            return items.removeFirst();
        }

        public int size() {
            return items.size();
        }

        public boolean isEmpty() {
            return items.isEmpty();
        }

    @Override
    public String toString() {
        return "PriorityQueueUsingList{" +
                "items=" + items +
                '}';
    }
}


