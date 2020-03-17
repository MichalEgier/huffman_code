
public class LinkedQueue<T> implements IQueue<T>{

	private LinkedList<T> lista;
	int pos;
	
	public LinkedQueue(LinkedList<T> lista1){
		this.lista=lista1;
	}
	
	public LinkedQueue() {
		lista = new LinkedList<T>();
	}
	
	@Override
	public boolean isEmpty() {
		if(lista.get(0)==null)
		return true;
		else return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	public T dequeue() throws EmptyQueueException {
		
		 T value=lista.remove(0);
		 if(value==null) throw new EmptyQueueException();
		 return value;
	}
	@Override
	public void enqueue(T elem) throws FullQueueException {
		lista.add(elem);
	}

	@Override
	public int size() {
		return lista.size();
	}

	@Override
	public T first() throws EmptyQueueException {
		if(lista.get(0)==null)
		throw new EmptyQueueException();
		else return(lista.get(0));
	}
	

}
