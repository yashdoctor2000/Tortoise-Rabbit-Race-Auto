class Track
{
	synchronized void tunnel(String rna,long sl)
	{
		System.out.println("\n"+rna+" Has entered into tunnel");
		try{Thread.sleep(sl);}
		catch(Exception e){}
		System.out.println("\n"+rna+" HAS CROSSED TUNNEL");
	}
	synchronized void sulado()
	{
		System.out.println("\n RABBIT HAS STARTED SLEEPING");
		try{wait();}
		catch(Exception e){}
		System.out.println("\n RABBIT WOKE UP & RUN");
	}
	synchronized void jagado()
	{
		notify();
	}
}
class Racer implements Runnable
{
	Thread th;
	String rna;
	long sl;
	Track tr;
	int miles;
	Racer(String rna,Track tr,long sl)
	{
		th=new Thread(this);
		this.rna=rna;
		this.tr=tr;
		this.sl=sl;
		th.start();
	}
	public void run()
	{
		while(miles<=10)
		{
			try{Thread.sleep(sl);}
			catch(Exception e){}
			miles++;
			if(miles==10)
			{
				System.out.println("\n"+rna+" HAVE WON THE RACE");
				System.exit(0);
			}
			else if(miles==3)
			{
				tr.tunnel(rna, sl);
			}
			else if(rna.equals("RABBIT") && miles==5)
			{
				tr.sulado();
			}
			else if(rna.equals("TORTOISE") && miles==7)
			{
				tr.jagado();
			}
			System.out.println("\n\n"+rna+" HAVE FINISHED "+miles+" MILES");
		}
	}
}
public class TortoriseRabbit 
{
	public static void main(String[] args) 
	{	
		Track tr=new Track();
		Racer r1=new Racer("RABBIT",tr,3000);
		Racer r2=new Racer("TORTOISE",tr,4500);
	}

}
