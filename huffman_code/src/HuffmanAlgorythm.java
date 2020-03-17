import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanAlgorythm {

	public Tree<Character> run(PriorityQueue <Tree<Character>> queue){
		
		while(queue.size()>1) {
			
			Tree<Character> first = queue.poll();
			
		//	System.out.println(first);
			
			Tree<Character> second = queue.poll();
			
		//	System.out.println(second);
			
			queue.add(new Tree<Character>(new Node<Character> ('!',(first.getRoot().getWeight() + second.getRoot().getWeight())),first.getRoot(),second.getRoot()));
			
			
		}
		
		return queue.poll();
		
	}
	
	public void runFromFile() {
	
	File file = new File ("plik.txt");
	
	FileReader fr = null;
	
	Scanner skaner = null;
	
	StringBuilder wholeFile = new StringBuilder();
	
	StringBuilder sb = new StringBuilder();
	
	try {
		
		fr = new FileReader(file);
	
		skaner = new Scanner (fr);
		
		String line;
		
		while(skaner.hasNextLine()) {
			
			line=skaner.nextLine();
			
			sb.append(line);
			
			wholeFile.append(line + "\n");
		}
		
	}
	
	catch(IOException e) {
		e.printStackTrace();
	}
	
	//teraz ustalanie ze StringBuildera ile jakich znakow jest
	
	char [] array = sb.toString().toCharArray();
	
	LinkedList <Node<Character>> list = new LinkedList<Node<Character>>();
	
	for(int i=0;i<array.length;i++) {
		
		char a = array[i];
		
		boolean isInList = false;
		
		int iter = 0;
		
		while( iter < list.size() && !isInList ) {
			
			if(list.get(iter).getValue().equals(a)) {isInList = true;
			list.get(iter).setWeight(list.get(iter).getWeight()+1);
			}
			iter++;
			
		}
		
		if(!isInList) list.add(new Node<Character>(a,1));
		
	}
	
	PriorityQueue <Tree<Character>> pq = new PriorityQueue <Tree<Character>>();
	
	for(int i=0;i<list.size();i++) {
		pq.add(new Tree<Character>(list.get(i)));
	}
	
	Tree<Character> tree = run(pq);
	
	tree.setCodesToCharacters();
	
	for(int i=0;i<list.size();i++) {
		System.out.println(list.get(i));
	}
	
	String wholeFileString = wholeFile.toString();
	
	for(int i=0;i<list.size();i++) {
		
//		String val = "\\" + list.get(i).getValue();
		wholeFileString = wholeFileString.replaceAll("[" + list.get(i).getValue().toString() + "]", list.get(i).getCode());
//		System.out.println(list.get(i).getCode());
//		System.out.println(wholeFileString);
	}
	
	System.out.println("Text coded: " + wholeFileString);
	
	saveInFile(wholeFileString,"code.txt");
	
	decode(tree,wholeFileString);
	
	}
	
	public void decode(Tree<Character> tree,String code) {
		
		LinkedList <Node> list = tree.returnListOfLeafs();
		
//		for(int i=0;i<list.size();i++) {
//			System.out.println(list.get(i));
//		}
		
		String decoded = code;
		
		StringBuilder str= new StringBuilder();
		
		int strLength=0;
		
		for(int i=0;i<code.length();i++) {
			
			str.append(code.charAt(i));
			
			strLength++;
			
			boolean isSentence = false;
			Character toReplace=null;
			
			for(int j=0;j<list.size();j++) {
		//		System.out.println(str.toString());
				if(list.get(j).getCode().equals(str.toString())) {
					isSentence=true;
					toReplace = (Character) list.get(j).getValue();
				}
			}
			
			if(isSentence) {
				
				
				
				decoded = decoded.replaceFirst(str.toString(), toReplace.toString());
				
				str = new StringBuilder();
				
				strLength=0;
			}
			
		}
		
		System.out.println("Decoded text: " + decoded);
	}
	
	public void saveInFile(String code,String file) {
		File fil = new File(file);
		
		try {
		FileWriter fw = new FileWriter(fil);
		fw.write(code);
		fw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
