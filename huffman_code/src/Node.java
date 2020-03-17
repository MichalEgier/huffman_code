public class Node<T>{
		
		private Node <T> right=null;
		
		private Node <T> left=null;
		
		private Node <T> parent=null;
		
		private T value;
		
		private int weight;
		
		private String code;
		
		public String getCode() {
			return code;
		}
		
		public void setCode(String a) {
			this.code=a;
		}
		
		public int getWeight() {
			return weight;
		}
		
		public void setWeight(int a) {
			weight=a;
		}
		
		public Node(){
			
		}
		
		public Node(T a) {
			value=a;
		}
		
		public Node(T a,int weight) {
			this.value=a;
			this.weight=weight;
		}
		
		public Node(Node<T> a) {
			parent=a;
		}
		
		public Node(Node<T> a,T b) {
			value=b;
			parent=a;
		}
		
		public Node <T> getRight() {
			return right;
		}
		
		public Node <T> getLeft() {
			return left;
		}
		
		public Node <T> getParent(){
			return parent;
		}
		
		public T getValue() {
			return value;
		}
		
		public void setValue(T a) {
			value=a;
		}
		
		public void setRight(Node<T> a) {
			right=a;
		}
		
		public void setLeft(Node <T> a) {
			left=a;
		}
		
		public void setParent(Node <T> a) {
			parent=a;
		}
		
		public String toString() {
			return "Value= '" + value + "' Weight= " + weight + " Code=" + code; 
		}
	}
	
