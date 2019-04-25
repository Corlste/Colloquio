package programmaColloquio.model;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Model {
	
	public LinkedList<Risultato> risultati = new LinkedList<Risultato>();
	public LinkedList<Temperatura> temperature = new LinkedList<Temperatura>();
	private String risultato = null;

	
	public String getResult(String filec) {
		if (filec.equals("weather")){
			int day=0;
			Float escursione=999f;
			Float tesc = null;
			for (Temperatura a:temperature) {
				tesc=a.getTmax()-a.getTmin();
				if (tesc<escursione) {
					escursione = tesc;
					day=a.getDay();
				}
				
			}
			risultato = "Il giorno " + day + " c'è stata l'escursione termica più piccola pari a: " + escursione + ".";
		}
		
		if (filec.equals("football")){
			String squadra = null;
			int differenza=1000;
			int tdiff=0;
			for (Risultato r: risultati) {
				tdiff=Math.abs(r.getSegnati()-r.getSubiti());
				if (tdiff<differenza) {
					differenza=tdiff;
					squadra = r.getTeam();
				}
			}
			risultato = "La squadra " + squadra + " ha la minor differenza tra goal segnati e subiti pari a: "+ differenza + ".";
		}
		
		
		return risultato;
	}

	
	public void loadFile(String filec) {
		if (filec.equals("weather")){
			
			try {
				FileReader fr = new FileReader("rsc/weather.dat");
				BufferedReader br = new BufferedReader(fr);
				String riga;
				br.readLine();
				
				while((riga= br.readLine())!=null) {
				
					StringTokenizer st = new StringTokenizer(riga, " ");
					if (st.hasMoreTokens()) {
						String input = st.nextToken();
						if (input.contentEquals("Dy")) {
							riga=br.readLine();
						}
						int giorno = 0;
						Float tempmax = null;
						Float tempmin =null;
						String temporary= null;
						
						if (!input.contentEquals("Dy")) {
							if (input.matches("[0-9]")) {
								giorno = Integer.parseInt(input);
							}else {
								temporary=input.replaceAll("\\D", "");
								if (!temporary.contentEquals("")) {
									giorno=Integer.parseInt(temporary);
								}				
							}
							temporary=st.nextToken();
							if (temporary.matches("[0-9]")){
								tempmax = Float.parseFloat(temporary);
							}else {
								tempmax=Float.parseFloat(temporary.replaceAll("\\*", ""));
							}
							temporary=st.nextToken();
							if (temporary.matches("[0-9]")){
								tempmin = Float.parseFloat(temporary);
							}else {
								tempmin=Float.parseFloat(temporary.replace("*", ""));
							}
							Temperatura temp = new Temperatura(giorno, tempmax, tempmin);
						temperature.add(temp);
						
						}
					}
				}
				br.close();
			} catch (IOException e) {
				System.out.println("Errore nella lettura del file");
				
			}
		}

	
	
	
	
	if (filec.equals("football")){
		
		try {
			FileReader fr = new FileReader("rsc/football.dat");
			BufferedReader br = new BufferedReader(fr);
			String riga;
			br.readLine();
			
			while((riga= br.readLine())!=null) {
			
				StringTokenizer st = new StringTokenizer(riga, "\t");
				if (st.hasMoreTokens()) {
					st.nextToken();
					String input = st.nextToken();
					
					String squadra = null;
					int f ;
					int a ;
					String temporary= null;

					
					if(input.matches(".*[a-zA-Z0-9].*")) {
					squadra = input;
					
					
					st.nextToken();
					st.nextToken();
					st.nextToken();
					st.nextToken();
					temporary=st.nextToken();
					if (temporary.matches("[0-9]")){
						f = Integer.parseInt(temporary);
					}else {
						f=Integer.parseInt(temporary.replaceAll("\\D", ""));
					}
					st.nextToken();
					temporary=st.nextToken();
					if (temporary.matches("[0-9]")){
						a = Integer.parseInt(temporary);
					}else {
						a=Integer.parseInt(temporary.replace("\\D", ""));
					}
					Risultato temp = new Risultato(squadra, f, a);
					risultati.add(temp);
					}
				
				}
				
			}
			br.close();
			
		} catch (IOException e) {
			System.out.println("Errore nella lettura del file");
			
		}
	}
}
}
