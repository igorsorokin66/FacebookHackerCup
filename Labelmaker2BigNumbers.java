import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.Scanner;

//not working because biginteger is a clusterfuck
public class Labelmaker2BigNumbers
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner inputFile = new Scanner(new FileReader("labelmaker_example_input.txt"));
		
		int cases = Integer.valueOf(inputFile.nextLine());
		for (int c = 0; c < cases; c++)
		{
			String line = inputFile.nextLine();
			String[] ltrs = line.split(" ")[0].split("");
			BigInteger bigStop = new BigInteger("0");
			bigStop = new BigInteger(line.split(" ")[1]);
			System.out.println(bigStop.toString());
			
			BigInteger lower = new BigInteger("0");
			BigInteger upper = new BigInteger("0");
			BigInteger range = new BigInteger("1");
			BigInteger len;
			for (len = new BigInteger("1"); true; len = len.add(new BigInteger("1")))
			{
				//System.out.println(upper.toString());
				range = range.multiply(new BigInteger(String.valueOf(ltrs.length-1)));
				upper = upper.add(range);
				if (new BigInteger(String.valueOf(upper)).compareTo(bigStop) == 1) break;
			}
			lower = upper.subtract(range).add(new BigInteger("1"));
			//System.out.println(lower.toString());
			
			BigInteger lower1 = lower;
			BigInteger upper1 = new BigInteger("0");
			String f = "";
			for (BigInteger l = len.subtract(new BigInteger("1")); l.compareTo(new BigInteger("0")) == 0 ||
					l.compareTo(new BigInteger("0")) == 1; l = l.subtract(new BigInteger("1")))
			{
				upper1 = lower1.add(new BigInteger(String.valueOf((int)Math.pow(((double)(ltrs.length-1)), ((double)l.intValue())) - 1)));
			
				for (int i = 1; i < ltrs.length; i++)
				{
					//System.out.println("lower: "+lower1.toString());
					//System.out.println("upper: "+upper1.toString());
					if (new BigInteger(String.valueOf(upper1)).compareTo(bigStop) == 1||new BigInteger(String.valueOf(upper1)).compareTo(bigStop) == 0) {f += ltrs[i];break;}
					lower1 = upper1.add(new BigInteger("1"));
					if (l.compareTo(new BigInteger("0")) != 0) upper1 = upper1.add(new BigInteger(String.valueOf((int)Math.pow(((double)(ltrs.length-1)), ((double)l.intValue())))));
					else upper1 = upper1.add(new BigInteger("1"));
				}
				if (f.length() == len.intValue()) break;
			}
			System.out.println(f);
		}
	}
	


}
