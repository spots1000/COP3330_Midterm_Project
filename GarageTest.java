import java.util.*;
import java.io.*;

public class GarageTest 
{

	
	public static void main(String args[]) throws IOException
	{
		BufferedReader fInpt = null;
		
		Scanner inpt = new Scanner(System.in);
		
		System.out.println("Please enter the number of floors in the garage: ");
		int floors = inpt.nextInt();
		
		System.out.println("Please enter the area of each floor: ");
		double area = inpt.nextDouble();
		
		System.out.println("Please enter the name of the input file (including extension): ");
		inpt.nextLine();
		String filename = inpt.nextLine();
		
		inpt.close();
		
		try 
		{
			 fInpt = new BufferedReader(new FileReader(filename));
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Error, file not openned. Exiting!");
			System.exit(1);
		}
		
		GarageC pk = new GarageC("Garage C", floors, area);
		
		double areaUsed = 0;
		int small = 0;
		int med = 0;
		int large = 0;
		
		fInpt.readLine();
		
		while (true)
		{
			String[] inptLine = null;
			String line;
			String vehicle;
			double len;
			double width;
			
			line = fInpt.readLine();
			
			if (line == null)
			{
				break;
			}
			
			inptLine = line.split("\\s+");
	
			vehicle = inptLine[0];
			len = Double.parseDouble(inptLine[1]);
			width = Double.parseDouble(inptLine[2]);
			
			double carArea = len*width;
			areaUsed += carArea;
			
			System.out.println("Vehicle " + vehicle + ", Type: " + pk.spaceType(len, width) + ", Required Area: " + carArea + ", Total area occupied in Garage: " + areaUsed + ", Total vacant area: " + (pk.getMaxArea()-areaUsed));
			
			if (pk.spaceType(len, width) == "Small")
			{
				small++;
			}
			else if (pk.spaceType(len, width) == "Medium")
			{
				med++;
			}
			else
			{
				large++;
			}
			
			if( areaUsed > pk.getMaxArea())
			{
				System.out.println("Garage " + pk.getName() + " is now full.");
				
				BufferedWriter out = new BufferedWriter( new FileWriter("out.txt"));
				
				out.write("Small: " + small + " Medium: " + med + " Large: " + large);
				
				out.close();
				
				break;
			}
		
		}
		
		fInpt.close();
	}
}
