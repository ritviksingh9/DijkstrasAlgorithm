public class Tree 
{
	Node root;
	int size;
	
    public Tree() 
    {
    	
    }
    public Tree(int n)
    {
    	size = n;	
    }
    
    protected void insert(int num, int parent, int name)
    {
    	Node node = new Node(num, name, size);
    	if(root == null)
    	{
    		root = node;
    	}
    	else
    	{
	    	find(parent, root).setNode(node, name);	
    	}
    }

    protected void delete(int parent, int name)
    {
    	Node node = find(parent, root);
    	int i;
    	
    	for(i = 0; node.getNode(i) != null && node.getNode(i).getData() != name; i++);
    	
    	node.setNode(null, i);
   	}
	
    protected Node find(int name, Node current)
    {
    		for(int i = 0; current.getNode(i) != null && current.getName() != name; i++)
    		{
    			current = find(name, current.getNode(i));
    		}
    	return current;
    }
    public void print()
    {
    	print(root);
    }
    protected void print(Node node)
    {
		if(node != null)
		{
			System.out.println(node.getName() + " " + node.getData());
			for(int i = 0; i < size; i++)
			{
				print(node.getNode(i));
			}
		}
    }    
}