import java.util.*;
class InverseBst{
	 class Node
    {
        int data;
        Node right,left;
        Node(int data)
        {
            this.data = data;
            right=left=null;
        }
    }
    InverseBst(){
    	root=null;
    }
    void insert(int data){
        root = insertInTree(root,data);
     }
      Node insertInTree(Node root , int data)
    {
        if(root == null)
        {
            root = new Node(data);
            return root;
        }
        if(data < root.data)
        {
           root.left = insertInTree(root.left, data);
        }
        else
        {
            root.right = insertInTree(root.right, data);
        }
        return root;
    }
    int height()
    {
        int a ;
        a = calHeight(root);
        return a;
    }

    int calHeight(Node n)
    {
    	int count=0;
    	if(root==null){
    		return 0;
    	}
    	else{
    		int lh = calHeight(node.left);
    		int rh = calHeight(node.right);
    		if(lh>rh){
    			return(lh+1);
    		}
    		else{
    			return(rh+1);
    		}
    	}
    }
    void printPreOrder(Node root){
    	if(root==null){
    		return;
    	}
    	System.out.print(root.data + " ");
    	printPreOrder(root.left);
    	printPreOrder(root.right);
    }
    void postorder()
    {
        printPostOrder(root);
        System.out.println();
    }
    void printPostOrder(Node root){
    	if(root==null){
    		return;
    	}
    	printPostOrder(root.left);
    	printPostOrder(root.right);
    	System.out.print(root.data + " ");
    } 
    void level()
    {
        int h = height();
        for(int i = 1 ; i<=h ; i++)
        {
            printlevel(root,i);
            System.out.println();
        }
    }
    void printlevel(Node root , int level)
    {
        if(root == null)
        {
            return;
        }
        if(level == 1)
        {
            System.out.print(root.data + " " );
        }
        else if(level>1)
        {
            printlevel(root.right, level-1);
            printlevel(root.left, level-1);
        }
    }
    void display(){
    	level();

    }



    class Assignment1{
     public static void main(String []agrs){
        InverseBst tree = new InverseBst();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes");
        int num = sc.nextInt();
        System.out.println("Enter nodes");
        for(int i=0;i<num;i++){
        	tree.insert(sc.nextInt());
        }
        System.out.println("Post Order");
        postorder();
        System.out.println("Pre Order");
        preorder();
        System.out.println("level order");
        level();
    }