import java.util.TreeMap;
import java.util.NoSuchElementException;
/**
 * 
 */

/**
 * @author Mansi
 *
 */

/**
 This class is defined to implement Priority Queue functionalities using Heap data structure
 Following have been implemented to demonstrate the functionalities:
 1) init(): This is used to initialize the queue
 2) enqueue(): This function will be used to insert a new element
 3) dequeue(): This function will be used to remove an element
 4) update(): This function will be used to update priority of a given element
 5) check_size(): This function will be used to check the size of the queue
 6) is_empty(): This function will check if the queue is empty or not
 7) peek(): This function will be used to display the element at whatever priority we specify
 **/
public class PriorityQueueUsingHeap<T extends Comparable<T>>{

	TreeMap<Integer,T> heapPQ;
	int index;
	PriorityQueueUsingHeap(){
		heapPQ = new TreeMap<>();
		index = 0;
	}
	public void enqueue(T entry) {
		heapPQ.put(index,entry);
		heapUp(index);
		index++;
	}
	public void heapUp(int i) {
		int p = (i-1)/2;
		while(i>0 && heapPQ.get(i).compareTo(heapPQ.get(p))>0) {
			swap(i,p);
			i = p;
			p = (i-1)/2;
		}
	}
	public T remove() {
		if(index == 0) {
			throw new NoSuchElementException("Priority Queue is empty!");
		}
		T element = heapPQ.get(0);
		int last_index = index - 1;
		T last_element = heapPQ.remove(last_index);
		if(last_index != 0) {
			heapPQ.put(0,last_element);
			heapDown(0);
		}
		index--;
		return element;
	}
	public void heapDown(int i) {
		int left = 2*i + 1;
		int right = 2*i + 2;
		int max = i;
		if(left<index && heapPQ.get(left).compareTo(heapPQ.get(max))>0) {
			max = left;
		}
		if(right<index && heapPQ.get(right).compareTo(heapPQ.get(max))>0) {
			max = right;
		}
		if(max!=i) {
			swap(i,max);
			heapDown(max);
		}
	}
	public void swap(int i,int j) {
		T tmp_obj = heapPQ.get(i);
		heapPQ.put(i,heapPQ.get(j));
		heapPQ.put(j,tmp_obj);
	}
	public int check_size() {
		return heapPQ.size();
	}
	public boolean is_empty() {
		return heapPQ.size()==0;
	}
	public T peek(int priority) {
		return heapPQ.get(priority);
	}

	public static void main(String[] args) {
		PriorityQueueUsingHeap<Integer> pq = new PriorityQueueUsingHeap<>();
		pq.enqueue(100);
		pq.enqueue(200);
		System.out.println(pq.check_size());
		pq.remove();
//		pq.toString();
	}
}
