
public class MesoAscii extends MesoAsciiAbstract
{
	
	/*
	 * Creating a global array to hold all the char values in the Stid String 
	 */
	private char[] vals;
	/*
	 * Creating the 
	 */
	public MesoAscii(String Stid)
	{
		vals=Stid.toCharArray();
	}
	
	@Override
	public int calAverage()
	{
		double sum= vals[0]+vals[1]+vals[2]+vals[3];
		
		return (int) (sum/4);
	}
	
}