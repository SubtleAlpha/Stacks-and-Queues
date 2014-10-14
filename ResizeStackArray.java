
public class ResizeStackArray
{
	int[] stackArray;
	int tailIdxRnr;
	
	public ResizeStackArray()
	{
		this(1);
	}
	public ResizeStackArray(int size)
	{
		stackArray = new int[size];
		tailIdxRnr = 0;
	}
	public void push(int data)
	{
		if(tailIdxRnr >= stackArray.length)
		{
			resize(stackArray.length * 2);
		}
		stackArray[tailIdxRnr++] = data;
	}
	public int pop()
	{
		int pop = stackArray[--tailIdxRnr];
		stackArray[tailIdxRnr] = 0;
		return pop;
	}
	public void resize(int size)
	{
		int[] newStackArray = new int[size];
		for(int i = 0; i < stackArray.length; i++)
		{
			newStackArray[i] = stackArray[i];
		}
		stackArray = newStackArray;
	}
	public void print()
	{
		for(int i = tailIdxRnr - 1; i >= 0; i--)
		{
			System.out.print(stackArray[i]);
		}
		System.out.println();
	}
	public static void main(String[] args)
	{
		ResizeStackArray stackArray = new ResizeStackArray();
		for(int i = 0; i <= 20; i++)
		{
			stackArray.push(i);
		}
		for(int i = 0; i < 5; i++)
		{
			stackArray.pop();
		}
		stackArray.print();
	}
}

