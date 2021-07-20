
public class GarageC extends Garage implements ParkingSpot
{
	int floorNum;
	double floorArea;
	double maxArea;
	
	public GarageC(String name, int numFloors, double area)
	{
		super(name);
		floorNum = numFloors;
		floorArea = area;
		maxArea = floorNum*floorArea;
	}
	
	public int getNumFloors()
	{
		return floorNum;
	}
	
	public double getFloorArea()
	{
		return floorArea;
	}
	
	public double getMaxArea()
	{
		return maxArea;
	}

	public String spaceType(double len, double width) 
	{
		if ( len < 15 )
		{
			return "Small";
		}
		else if ( len > 15 & len <=17 )
		{
			return "Medium";
		}
		else
		{
			return "Large";
		}
	}

	public double spotArea(double len, double width) 
	{
		maxArea = len*width;
		return (len*width);
	}
	
}
