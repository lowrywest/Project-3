import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StationLexicographical extends MesoSortedAbstract
{
	private TreeMap<String, Integer> sorted;
	private HashMap<String, Integer> input;
	
	public StationLexicographical(HashMap<String, Integer> AsciiVals)
	{
		sorted= new TreeMap<String, Integer>();
		input=AsciiVals;
	}
	
	@Override
	public Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted) 
	{
		sorted.putAll(unsorted);
		
		return null;
	}
	
	
}