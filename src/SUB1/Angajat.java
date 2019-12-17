package SUB1;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Angajat {
	private String nume;
	private Calendar data_angajarii;
	
	public Angajat(String n, Calendar data)
	{
		this.nume = n;
		this.data_angajarii = data;
	}
	
	public int Vechime()
	{
		Calendar date = Calendar.getInstance();
		int ani = date.get(Calendar.YEAR) - data_angajarii.get(Calendar.YEAR);
		return ani;	
	}
	public String numeGet()
	{
		return this.nume;
	}
	public String dataGet()
	{
		return this.data_angajarii.get(Calendar.DATE) + "-" + this.data_angajarii.get(Calendar.MONTH) + "-" + this.data_angajarii.get(Calendar.YEAR);
	}
	public String toString()
	{
		return this.nume + " " +this.dataGet() + " " + this.Vechime() +"\n";
	}
}
