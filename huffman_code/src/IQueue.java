
public interface IQueue<T>{
 boolean isEmpty();
 boolean isFull();
 T dequeue() throws EmptyQueueException;
 void enqueue(T elem) throws FullQueueException;
 int size(); // zwraca liczbê elementów w kolejce
 T first() throws EmptyQueueException;
 // zwraca element z pocz¹tku kolejki bez usuwania go
 
 	class EmptyQueueException extends Exception{
 		
 	}
 	
 	class FullQueueException extends Exception{
 		
 	}
}