import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.Scanner;

//doesnt work for huge integers
public class Labelmaker2
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner inputFile = new Scanner(new FileReader("labelmaker_example_input.txt"));
		
		int cases = Integer.valueOf(inputFile.nextLine());
		for (int c = 0; c < cases; c++)
		{
			String line = inputFile.nextLine();
			String[] ltrs = line.split(" ")[0].split("");
			int stop = 0;
			stop = Integer.valueOf(line.split(" ")[1]);
			
			int lower = 0;
			int upper = 0;
			int range = 1;
			int len;
			for (len = 1; len <= ltrs.length; len++)
			{
				range *= ltrs.length-1;
				upper += range;
				if (upper > stop) break;
			}
			lower = upper - range + 1;
			
			
			int lower1 = lower;
			int upper1 = 0;
			String f = "";
			for (int l = len-1; l >= 0; l--)
			{
				upper1 = lower1 + (int)Math.pow(((double)(ltrs.length-1)), ((double)l)) - 1;
				//if (l != 0) upper1--;
				for (int i = 1; i < ltrs.length; i++)
				{
					if (upper1 >= stop)
					{
						f += ltrs[i];
						break;
					}
					lower1 = upper1+1;
					if (l != 0) upper1 += (int)Math.pow(((double)(ltrs.length-1)), ((double)l));
					else upper1++;
				}
				if (f.length() == len) break;
			}
			System.out.println(f);
		}
	}

}
