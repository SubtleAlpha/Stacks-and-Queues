public class StackArray
{
	int[] stackArray;
	int headIdxRnr;
	int capacity;
	
	public StackArray(int size)
	{
		stackArray = new int[size];
		headIdxRnr = 0;
		capacity = 0;
	}
	
	public void push(int data) throws Exception
	{
		// Keep in mind neither of these are 0 based. Length return # of items in list
		if(capacity >= stackArray.length)
		{
			throw new Exception("Full stack");
		}
		stackArray[headIdxRnr++] = data;
		capacity++;
	}
	
	public int pop() throws Exception
	{
		if(capacity <= 0)
		{
			throw new Exception("No elements in stack");
		}
		// Need to -1 because we incremented during push
		int pop = stackArray[headIdxRnr - 1];
		stackArray[headIdxRnr - 1] = 0;
		headIdxRnr--;
		capacity--;
		return pop;
	}
	
	public void exch(int fromIdx, int toIdx)
	{
		int temp = stackArray[fromIdx];
		stackArray[fromIdx] = stackArray[toIdx];
		stackArray[toIdx] = temp;
	}
	
	public void print()
	{
		// When iterating backwards, make sure to make it i >= 0
		for(int i = headIdxRnr-1; i >= 0; i--)
		{
			System.out.println(stackArray[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		StackArray sArray = new StackArray(5);
		try
		{
			sArray.push(1);
			sArray.push(2);
			sArray.push(3);
			sArray.push(4);
			sArray.push(5);
			sArray.pop();
			sArray.push(6);
			sArray.print();
		}
		catch(Exception e)
		{
			System.out.println(e);
			sArray.print();
		}
	}
}

