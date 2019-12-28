import java.io.*;
import java.util.Scanner;

public class DjikstraAlgorithm 
{
    
    public static void main(String[] args) throws Exception
    {
    	BufferedReader fpIn = new BufferedReader(new FileReader("Dataset_2.txt"));
    	Scanner sc = new Scanner(fpIn.readLine());
    	int n = sc.nextInt();
    	boolean d = sc.nextInt() == 1;
    	int [][] data = new int [n][n];
    	int [] distances = new int[n];
    	int [] spt = new int[n];
    	int [] parents = new int[n];
    	String str = fpIn.readLine();
    	Tree tree = new Tree(n);
    	tree.insert(0, 0, 0);
    	
    	while(str != null)
    	{
    		sc = new Scanner(str);
    		int x = sc.nextInt();
    		int y = sc.nextInt();
    		int z = sc.nextInt();
    		
    		data[x][y] = z;
    		if(!d)
    		{
    			data[y][x] = z;
    		}
    		str = fpIn.readLine();
    	}
    	
    	for(int i = 1; i < n; i++)
    	{
    		distances[i] = -1;
    	}
    	
    	for(int i = 0; i < n; i++)
    	{
    		for(int col = 0; col < n; col++)
    		{
    			if(data[spt[i]][col] != 0 && (distances[col] == -1 || data[spt[i]][col] + distances[spt[i]] < distances[col]))
    			{
    				if(distances[col] != -1)
    				{
    					tree.delete(spt[i], parents[spt[i]]);
    				}  				
					distances[col] = data[spt[i]][col] + distances[spt[i]];	
					parents[col] = spt[i];
					tree.insert(distances[col], spt[i], col);
    			}
    		}
    		if(i < n-1)
    		{
    			spt[i+1] = smallest(distances, spt, i);		
    		}
    	}
    	
   		for(int i = 0; i < n; i++)
    	{
    		System.out.print(distances[i] + " ");
    	}
    	System.out.println();
    	for(int i = 0; i < n; i++)
    	{
    		System.out.print(spt[i]+" ");
    	}
    	System.out.println();
    	tree.print(); 
    }
    
    static int smallest(int[] distances, int[] spt, int length)
    {
    	int smallest = Integer.MAX_VALUE;
    	int sI = 0;
    	int i;
    	int j;

    	for(i = 1; i < distances.length; i++)
    	{
    		for(j = 1; j < spt.length && spt[j] != 0 && spt[j] != i; j++);
    		if(distances[i] < smallest && distances[i] != -1 && spt[j] == 0)
    		{
    			smallest = distances[i];
    			sI = i;
    		}
    	}
    	
    	return sI;
    }
    
}