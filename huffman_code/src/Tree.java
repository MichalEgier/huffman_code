
public class Tree <T> implements Comparable<Tree<T>>{
	//klasa w ktorej beda uzyteczke metody do wlasnosci drzewa

	

		
		
		private Node <T> root=null;	

		public Tree(){
			
		}
		
		public Tree(Node<T> a) {
			
			this.root=a;
			
		}
		
		public Tree(Node<T> root,Node<T> left,Node<T> right) {
		
			this.root=root;
			
			this.root.setLeft(left);
			
			this.root.setRight(right);
			
		}
		
		
		public Node<T> getRoot(){
			return root;
		}
		
		public T getValue() {
			return root.getValue();
		}
		
		public Node<T> getRight() {
		//	Node ret = root;
			
			return root.getRight();
			}
		
		public Node<T> getLeft() {
			
			return root.getLeft();
		}
		
		public T getParent() {
			root=root.getParent();
			return root.getValue();
		}
		
		public int getNumberOfNodes() {
			
			return numberOfNodes(root);
			
		}
		
		private int numberOfNodes(Node a) {
			
			if(a!=null) {
			
			return 1+numberOfNodes(a.getLeft())+numberOfNodes(a.getRight());
			}
			
			return 0;
		}
		
		public int getNumberOfLeafs() {
			
			return numberOfLeafs(root);
			
		}
		
		private int numberOfLeafs(Node a) {
			if(a == null) return 0;
			if(a.getLeft()==null&&a.getRight()==null) {
				return 1;
			}
			return numberOfLeafs(a.getLeft()) + numberOfLeafs(a.getRight());
		}
		
		public int getHeight() {
			
			return height(root)-1;
			
		}
		
		private int height(Node a) {
			if(a==null) return 0;
			return 1+max(height(a.getLeft()),height(a.getRight()));
			
		}
		
		private int max(int a,int b) {
			if(a>b) return a;
			return b;
		}
		
		public void searchingLeftRightUp() {
			searchLeftRightUp(root);
		}
		
		private void searchLeftRightUp(Node a) {
			if(a==null) return;
			searchLeftRightUp(a.getLeft());
			searchLeftRightUp(a.getRight());
			System.out.print(a.getValue() + " ");
		}
		
		public String searchingLeftUpRight() {
		//	StringBuilder str = new StringBuilder();
			return searchLeftUpRight(root);
		}
		
		private String searchLeftUpRight(Node a) {    //StringBuilder a) {
			if(a==null) return "";
			if(!(a.getValue().toString().trim().equals("+")||a.getValue().toString().trim().equals("-")||a.getValue().toString().trim().equals("%")||a.getValue().toString().trim().equals("/")||a.getValue().toString().trim().equals("*"))) 
			return "(" + a.getValue().toString() + ")";	
			return "(" + searchLeftUpRight(a.getLeft()) + a.getValue() + searchLeftUpRight(a.getRight()) + ")";
			
			
		}
		
		public void przejscieWszerz() {
			
			//po polsku pisane bo szybciej 
			//1.korzen do kolejki
			//2.while !empty(kolejka)
			// - pobierz element z kolejki
			// - dodaj do kolejki dzieci tego elementi
			
			LinkedQueue<Node> kolejka = new<Node> LinkedQueue();
			
			try {
			kolejka.enqueue(root);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			while(!(kolejka.isEmpty())) {
				
				Node a=null;
				
				try {
				
				a = kolejka.dequeue();
				
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println(a.toString());		
				
				try {
				
				if(a.getLeft()!=null) kolejka.enqueue(a.getLeft());		
				
				if(a.getRight()!=null) kolejka.enqueue(a.getRight());
				
				}
				
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			
		}

		public LinkedList<Node> returnListOfLeafs() {
			
			//po polsku pisane bo szybciej 
			//1.korzen do kolejki
			//2.while !empty(kolejka)
			// - pobierz element z kolejki
			// - dodaj do kolejki dzieci tego elementi
			
			LinkedList <Node> list = new LinkedList <Node> ();
			
			retListInsideMethod(list,root);
			
			return list;
			
			
		}
		
		private void retListInsideMethod(LinkedList<Node> list,Node a) {
			
			if(a==null) return;
			if(!a.getValue().equals('!')) {
				list.add(a);
			}
			else {
				retListInsideMethod(list,a.getLeft());
				retListInsideMethod(list,a.getRight());
			}
			
		}
		
		@Override
		public int compareTo(Tree<T> arg0) {
			// TODO Auto-generated method stub
			if(this.getRoot().getWeight() == arg0.getRoot().getWeight()) return -1;
			return (this.getRoot().getWeight()) - (arg0.getRoot().getWeight());
		}
	
		public String toString() {
			return "Value: \'" + this.getRoot().getValue() + "\' Weight:" + this.getRoot().getWeight() + " Code:" + this.getRoot().getCode();
		}
		
		
		//na potrzeby zadania specjalnie metoda
		public void setCodesToCharacters() {
			
			Node a = this.getRoot();
			
			//przypadek jednego elementu
			if(!a.getValue().equals('!')) {
				a.setCode("0");
			}
			
			else {
				
				StringBuilder sb = new StringBuilder();
				
				goLeft(sb,root.getLeft());
				sb= new StringBuilder();
				goRight(sb,root.getRight());
				
				
			}
			
		}
		
		private void goLeft(StringBuilder sb,Node a) {
		if(a!=null) {
			sb.append("0");
			StringBuilder sb2 = new StringBuilder();
			StringBuilder sb3 = new StringBuilder();
			sb3.append(sb.toString());
			sb2.append(sb.toString());
			a.setCode(sb.toString());
			goLeft(sb,a.getLeft());
			sb=sb2;
			goRight(sb,a.getRight());
			sb=sb3;
			
			
		}
		}
		
		private void goRight(StringBuilder sb,Node a) {
			if(a!=null) {
				sb.append("1");
				StringBuilder sb2 = new StringBuilder();
				StringBuilder sb3 = new StringBuilder();
				sb2.append(sb.toString());
				sb3.append(sb.toString());
				a.setCode(sb.toString());
				goLeft(sb,a.getLeft());
				sb=sb2;
				goRight(sb,a.getRight());
				sb=sb3;
			}
		}

}
