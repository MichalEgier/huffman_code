
public class LinkedList<E>{

	private class Element{
		private E element;
		private Element next;
		
		public Element(E a) {
			this.element=a;
		}
		
		public void setNext(Element a) {
			this.next=a;
		}
		
		public Element getNext() {
			return this.next;
			
		}
		
		public E getValue() {
			return this.element;
		}
		
		public void setValue(E a) {
			this.element=a;
		}
		
	}
	
	Element head;

	public LinkedList() {
		
	}
	
	
	public boolean isEmpty() {
		if(head==null) return true;
		return false;
	}

	
	public void clear() {
		head=null;
	}


	public int size() {
		int size=1;
		if(head==null) return 0;
		Element aktualny = head;
		while(aktualny.getNext()!=null) {
			size++;
			aktualny=aktualny.getNext();
		}
		return size;
	}

	
	public boolean add(E value) {
		if(head==null) {head= new Element(value); return true;}
		Element aktualny=head;
		while(aktualny.getNext()!=null) {
			aktualny=aktualny.getNext();
		}
		
		aktualny.setNext(new Element(value));
		return true;
		
	}

	public boolean add(int index, E value) {
		int pos=0;
		if(index>this.size()) return false;
		if(index==0) {
			if(head.getNext()==null) {Element a=new Element(value);a.setNext(head);head=a;return true;}
			else {
				Element aktualny= new Element(value);
				aktualny.setNext(head);
				head=aktualny;
			}
		}
		
		if(head==null) {
			if(index==0) {this.add(value);return true;}
			else return false;
		}
		
		Element aktualny=head;
		
		boolean added=false;
		
		while(!added&&aktualny.getNext()!=null) {
			
			
			pos++;
			
			if(pos==index) {
				Element a = new Element(value);
				a.setNext(aktualny.getNext());
				aktualny.setNext(a);
				return true;
			}
		   aktualny=aktualny.getNext();
		}
		
		return false;
	}

	
	public boolean contains(E value) {
		//boolean bool=false;
		
		Element aktualny=head;
		if(aktualny==null) return false;
		if(value==head.getValue()) return true;
		while(aktualny.getNext()!=null) {
			if(aktualny.getNext().getValue()==value) return true;
			aktualny=aktualny.getNext();
		}
		return false;
	}


	public E get(int index) {
		
		int pos=0;
		
		if(this.size()==0) return null;
		
		if(index==0) return head.getValue();
		
		Element aktualny=head;
		
		while(aktualny.getNext()!=null) {
			pos++;
			aktualny=aktualny.getNext();
			if(pos==index) return aktualny.getValue();
		}
		
		return null;
	}

	
	public E set(int index, E value) {
		// TODO Auto-generated method stub
	
		int pos=0;
		
		if(index==0) {
			if(this.size()==1||this.size()==0)
			{head=new Element(value); return value;}
			else head.setValue(value);
			return value;
		}
		
		Element aktualny=head;
		
		if(index>this.size()) return null;
		
		while(aktualny.getNext()!=null) {
			aktualny=aktualny.getNext();
			pos++;
			if(pos==index) {aktualny.setValue(value); return value;}
		}
		//if()	
			
	//	Element aktualny=head;
		
		return null;
	}

	
	public int indexOf(E value) {
		int pos=0;
		
		if(this.size()==0) return -1;
		
		Element aktualny=head;
		
		if(aktualny.getValue()==value) return 0;
		
		while(aktualny.getNext()!=null) {
			if(aktualny.getNext().getValue()==value) return (1+pos);
			aktualny=aktualny.getNext();
			pos++;
		}
		
		return -1;
	}

	
	public E remove(int index){
		if(this.size()==0) return null;
		int pos=0;
		
		if(this.size()==1) {Element a=head;this.clear();return a.getValue();} 
		
		Element aktualny=head;
		Element poprzedni=null;
		
		while(pos!=index) {
			poprzedni=aktualny;
			aktualny=aktualny.getNext();
			pos++;
			
		}
		
	if(poprzedni!=null)	poprzedni.setNext(aktualny.getNext());
	else head=head.getNext();
	return aktualny.getValue();
			
	//	return null;
	}

	
	public boolean remove(E value) {
		
		//int pos=0;
		if(this.size()==0) return false;
		
		Element aktualny=head;
		if(aktualny.getValue()==value) {
			
			if(aktualny.getNext()!=null) head=aktualny.getNext();
			else this.clear();
			return true;
		}
		boolean deleted=false;
		
		while(!deleted&&aktualny.getNext()!=null) {
			if(aktualny.getNext().getValue()==value) {
				deleted=true;
				aktualny.setNext(aktualny.getNext().getNext());
				return true;
			}
		}
		
		
		return deleted;
	}

	/*
	public Iterator iterator() {
	
		return new ListIterator(this);
		
	}
*/
	/*
	
	
	
}

class ListIterator implements Iterator<Card> {
	
	int pos=0;
	OneWayLinkedListWithHead lista;
	
	public ListIterator(OneWayLinkedListWithHead list) {
		this.lista=list;
	}
	
	@Override
	public boolean hasNext() {
		if(pos<lista.size()) return true;
		else return false;
		
	}

	@Override
	public Card next() {
		
		if(!this.hasNext()) return null;
		else {pos++;return lista.get(pos-1);}
		
	}
	*/
}