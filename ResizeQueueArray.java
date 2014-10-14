
public class ResizeQueueArray
{
	int[] queueArray;
	int headIdxRnr;
	int tailIdxRnr;
	int capacity;
	
	public ResizeQueueArray()
	{
		this(1);
	}
	
	public ResizeQueueArray(int size)
	{
		queueArray = new int[size];
		capacity = 0;
		headIdxRnr = 0;
		tailIdxRnr = 0;
	}
	
	public void enQueue(int data)
	{
		if(capacity >= queueArray.length)
		{
			resize(capacity * 2);
		}
		if(tailIdxRnr >= queueArray.length)
		{
			tailIdxRnr = 0;
		}
		queueArray[tailIdxRnr++] = data;
		capacity++;
	}
	
	public int deQueue()
	{
		if(capacity < queueArray.length/2)
		{
			resize(queueArray.length/4);
		}
		int deQueue = queueArray[headIdxRnr];
		queueArray[headIdxRnr++] = 0;
		capacity--;
		return deQueue;
	}
	
	public void resize(int size)
	{
		// Allocate new Array
		int[] newQueueArray = new int[size];
		// Copy elements from old to new Array
		for(int i = 0; i < queueArray.length; i++)
		{
			newQueueArray[i] = queueArray[(headIdxRnr + i) % queueArray.length];
		}
		// Set new Array
		queueArray = newQueueArray;
		headIdxRnr = 0;
		tailIdxRnr = capacity;
	}
	
	public void print()
	{
		if(headIdxRnr < tailIdxRnr)
		{
			for(int i = headIdxRnr; i < tailIdxRnr; i++)
			{
				System.out.print(queueArray[i]);
			}
		}
		else
		{
			for(int i = headIdxRnr; i < queueArray.length; i++)
			{
				System.out.print(queueArray[i]);
			}
			for(int i = tailIdxRnr-1; i < headIdxRnr; i++)
			{
				System.out.print(queueArray[i]);
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		ResizeQueueArray qArray = new ResizeQueueArray(5);
		qArray.enQueue(1);
		qArray.enQueue(2);
		qArray.enQueue(3);
		qArray.enQueue(4);
		qArray.enQueue(5);
		//qArray.enQueue(6);
		qArray.deQueue();
		qArray.enQueue(6);
		qArray.enQueue(7);
		//qArray.deQueue();
		qArray.print();	
	}
}

