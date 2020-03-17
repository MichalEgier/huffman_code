import java.util.PriorityQueue;


public class Main {

	public static void main(String[] args) {
		
		PriorityQueue <Tree<Character>> queue = new PriorityQueue<Tree<Character>>();
		
		queue.add(new Tree(new Node('a',3)));
		queue.add(new Tree(new Node('l',2)));
		queue.add(new Tree(new Node(' ',2)));
		queue.add(new Tree(new Node('i',1)));
		queue.add(new Tree(new Node('o',1)));		
		queue.add(new Tree(new Node('.',1)));
		
		
		HuffmanAlgorythm hf = new HuffmanAlgorythm();
		
//		Tree <Character> tree = hf.run(queue);
		
//		tree.setCodesToCharacters();
		
//		tree.przejscieWszerz();;
		
//		StringBuilder sb = new StringBuilder () ;
		
		System.out.println("\n");
		
		hf.runFromFile();
		
	//	Character ch = new Character('.');
		
	//	String str = "131";
		
	//	System.out.println(ch.toString());
		
	//	System.out.println(str.replaceAll(ch.toString(), "new "));
	}

}
