package bishi;

import java.util.HashMap;

public class TireChTree {
	
	class Node{
		public char element;//单词的当前字
		boolean wordEnd;//单词结束标志
		HashMap<Character, Node> childdren = null;
		
		public Node(){
			this.wordEnd = false;
			childdren = new HashMap<Character, Node>();
		}
		
		public Node(char item){
			this.element = item;
			this.wordEnd = false;
			childdren = new HashMap<Character, Node>();
		}
	}
	
	public Node root;
	
	//构造函数
	public TireChTree(){
		root = new Node();
	}
	
	public void add(String word){
		//查找重复的字符
		int i = 0;
		Node currentNodeOld = root;
		//while里的条件不能顺序不能反着来
		while(i < word.length() && currentNodeOld.childdren.containsKey(word.charAt(i))){
			currentNodeOld = currentNodeOld.childdren.get(word.charAt(i));
			i++;
		}
		
		if(i == word.length()){
			currentNodeOld.wordEnd = true;//有更短的词进入
		}else{
			Node parNode = currentNodeOld;
			for(int j =i; j < word.length(); j++){
				char cha = word.charAt(j);
				Node currentNodeNew = new Node(cha);
				parNode.childdren.put(cha, currentNodeNew);
				parNode = currentNodeNew;
				if(j == word.length()-1){
					currentNodeNew.wordEnd = true;
				}
			}
		}
	}
	
	
	public boolean find(String word){
		Node currentNode = root;//从跟节点开始
		int i =0;
		while(i < word.length() && currentNode.childdren.containsKey(word.charAt(i))){
			currentNode = currentNode.childdren.get(word.charAt(i));
			i++;
		}
		if( i == word.length() && currentNode.wordEnd == true){
			return true;
		}else{
			return false;
		}
	}

	public static void main(String args[]){
		TireChTree tireTree =new TireChTree();
		tireTree.add("a");
		tireTree.add("an");
		tireTree.add("at");
		tireTree.add("and");
		tireTree.add("nowcoder");
		System.out.println(tireTree.find("a"));
		System.out.println(tireTree.find("and"));
		System.out.println(tireTree.find("nowcoder"));
		System.out.println(tireTree.find("nowcoderovo"));
		System.out.println(tireTree.find("what"));
	}
 
}