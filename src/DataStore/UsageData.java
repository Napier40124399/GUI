package DataStore;

public class UsageData
{
	private String manager;
	private int connected;
	private double msgPerSec;
	
	public UsageData(String manager, int connected, double msgPerSec)
	{
		this.manager	= manager;
		this.connected	= connected;
		this.msgPerSec	= msgPerSec;
	}

	public String getManager()
	{
		return manager;
	}

	public int getConnected()
	{
		return connected;
	}

	public double getMsgPerSec()
	{
		return msgPerSec;
	}
}
