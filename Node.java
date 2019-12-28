public class Node 
{
	protected Node [] branches;
	protected int data;
	protected int name;
	
    public Node() 
    {
    	
    }
    public Node(int num, int num2)
    {
    	data = num;
    	name = num2;
    }
    public Node(int num, int num2, int num3)
    {
    	data = num;
    	name = num2;
    	branches = new Node[num3];
    }
    
    protected void setSize(int size)
    {
    	branches = new Node[size];
    }
    protected void setData(int value)
    {
    	this.data = value;
    }
    protected int getData()
    {
    	return data;
    }
    protected void setName(int value)
    {
    	name = value;
    }
    protected int getName()
    {
    	return name;
    }
    protected void setNode(Node node)
    {
    	int i;
    	for(i = 0; branches[i] != null; i++);
    	branches[i] = node;
    }
    protected void setNode(Node node, int i)
    {
    	branches[i] = node;
    }
    protected Node getNode(int i)
    {
    	return branches[i];
    }    
}