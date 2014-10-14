
public class QueueArray
{
	int[] queueArray;
	// Tracker for dequeue operations
	int headIdxRnr;
	// Tracker for enqueue operations
	int tailIdxRnr;
	int capacity;
	
	public QueueArray(int size)
	{
		queueArray = new int[size];
		headIdxRnr = 0;
		tailIdxRnr = 0;
		capacity = 0;
	}
	
	public int deQueue() throws Exception
	{
		if(capacity <= 0)
		{
			throw new Exception("No elements in queue");
		}
		int deQueue = queueArray[headIdxRnr];
		queueArray[headIdxRnr++] = 0;
		capacity--;
		return deQueue;
	}
	
	public void enQueue(int data) throws Exception
	{
		// Keep in mind neither of these are 0 based. Length return # of items in list
		if(capacity >= queueArray.length)
		{
			throw new Exception("Full queue");
		}
		if(tailIdxRnr >= queueArray.length)
		{
			tailIdxRnr = 0;
		}
		queueArray[tailIdxRnr++] = data;
		capacity++;
	}
	
	public void exch(int[] list, int fromIdx, int toIdx)
	{
		int temp = list[fromIdx];
		list[fromIdx] = list[toIdx];
		list[toIdx] = temp;
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
		QueueArray qArray = new QueueArray(5);
		try
		{
			qArray.enQueue(1);
			qArray.enQueue(2);
			qArray.enQueue(3);
			qArray.enQueue(4);
			qArray.enQueue(5);
			//qArray.enQueue(6);
			qArray.deQueue();
			qArray.enQueue(6);
			//qArray.deQueue();
			qArray.print();	
		}
		catch(Exception e)
		{
			System.out.println(e);
			qArray.print();
		}
	}
}

