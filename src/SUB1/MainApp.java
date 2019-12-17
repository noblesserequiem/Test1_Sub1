package SUB1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

public class MainApp {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		Collection<Angajat> lista = new Vector<Angajat>();
		BufferedReader flux_in = new BufferedReader(new InputStreamReader(new FileInputStream("in.txt")));
		String line = flux_in.readLine();
		while(line != null)
		{
			String[] v_line = line.split(";");
			
			try {
				Calendar data = Calendar.getInstance();
				Date date;
				SimpleDateFormat myformat1 = new SimpleDateFormat("dd-MM-yyyy");
				
				String[] v_data = v_line[1].split("-");
				if(Integer.parseInt(v_data[0]) > 31)
					throw new DataExceptie("ziua > 31");
				if(Integer.parseInt(v_data[1]) > 12)
					throw new DataExceptie("luna > 12");
				
				date = myformat1.parse(v_line[1]);	
				data.setTime(date);
				Angajat obj = new Angajat(v_line[0], data);
				lista.add(obj);
			}
			catch(DataExceptie e)
			{
				BufferedReader cons_in = new BufferedReader(new InputStreamReader(System.in));
				System.out.println(e);
				System.out.println("Introduceti data noua: ");
				boolean ok = false;
				Calendar data = Calendar.getInstance();
				Date date;
				SimpleDateFormat myformat1 = new SimpleDateFormat("dd-MM-yyyy");
				String[] v_data;
				String new_data = "";
				while(ok == false)
				{
					ok = true;	
					new_data = cons_in.readLine();
					v_data = new_data.split("-");
					if(Integer.parseInt(v_data[0]) > 31)
						ok = false;
					if(Integer.parseInt(v_data[1]) > 12)
						ok = false;
					if(ok == false)
						System.out.println("Data noua:");
				}
				date = myformat1.parse(new_data);
				data.setTime(date);
				Angajat obj = new Angajat(v_line[0], data);
				lista.add(obj);
				
			}
			
			line = flux_in.readLine();
		}
		flux_in.close();
		BufferedWriter flux_out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt")));
		for(Angajat obj : lista)
		{
			flux_out.write(obj.toString());
		}
		flux_out.close();
		
	}

}
