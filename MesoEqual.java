import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MesoEqual
{
	/*
	 * Global String variable to hold the STID value from the constructor
	 */
	private String StiD;
	private HashMap<String, Integer> equalAsciiVals;
	private ArrayList<String> keyValues= new ArrayList<String>();
	
	public MesoEqual(String Stid) throws IOException
	{
		readInfo();
		StiD=Stid;
		equalAsciiVals= new HashMap<String, Integer>();
	}
	
	public void readInfo() throws IOException
	{
			/*
			 * holds the number of the STID value being read in 
			 */
			int loc=0;
			/*
			 * holds the current STID value
			 */
			String temp="";
			/*
			 * Constructing the Buffered reader
			 */
			BufferedReader STIDVals= new BufferedReader(new FileReader("Mesonet.txt"));
			/*
			 * Priming reads to skip the first 3 lines of Mesonet.txt
			 */
			STIDVals.readLine();
			STIDVals.readLine();
			STIDVals.readLine();
			
			/*
			 * loop through lines of the Mesonet.txt file
			 */
			while(loc<120)
			{
				/*
				 * setting temp to the entire line at that location
				 */
				temp=STIDVals.readLine();
				/*
				 * changing the value from the entire line to just the STID value
				 */
				temp=temp.substring(2, 6);
				/*
				 * adding the STID value to the ArrayList
				 */
				keyValues.add(temp);
				/*
				 * Incrementing the location being read in
				 */
				loc++;
			}
		/*
		 * Closing the BufferReader 
		 */
		STIDVals.close();
	}
	
	
	public MesoAscii convert(String string) 
	{
		MesoStation placeHold =new MesoStation(string);
		MesoAscii calAvgStid= new MesoAscii(placeHold);
		return calAvgStid;
	}
	

	public HashMap<String, Integer> calAsciiEqual()
	{
		int comparisonAvg= convert(StiD).calAverage();
		for(int i=0; i<keyValues.size(); i++)
		{
			if(comparisonAvg==(convert(keyValues.get(i)).calAverage()))
			{
				Integer avg=new Integer(convert(keyValues.get(i)).calAverage());
				equalAsciiVals.put(keyValues.get(i), avg);
				
			}
		}
		return equalAsciiVals;
	}
	
}