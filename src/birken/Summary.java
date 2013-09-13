package birken;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Summary {
	
	private StringBuilder text;
	private String startnr, name, club, clas;
	private int place;
	private Date timeFinished, maxTime, skramstad, bringbu, kvarstad, storasen;
	
	private DateFormat sdf;
	
	
	public String getStartnr() {
		return startnr;
	}

	public String getName() {
		return name;
	}

	public String getClub() {
		return club;
	}

	public String getClas() {
		return clas;
	}

	public int getPlace() {
		return place;
	}

	public Date getTimeFinished() {
		return timeFinished;
	}

	public Date getMaxTime() {
		return maxTime;
	}

	public Date getSkramstad() {
		return skramstad;
	}

	public Date getBringbu() {
		return bringbu;
	}

	public Date getKvarstad() {
		return kvarstad;
	}

	public Date getStorasen() {
		return storasen;
	}
	
	public Summary(int nr){
		sdf = new SimpleDateFormat("HH:mm:ss");
		sdf.format(new Date());
		HTMLReader reader = new HTMLReader(nr);
		text = reader.getWebpage();
		getSummary();
	}
	
	public void getSummary(){
		String stringplace, stringTimeFinished, stringMaxTime, 
				stringSkramstad, stringBringbu, stringKvarstad, stringStorasen;
		
		int intstartnr = text.indexOf("Startnr");
		int intname = text.indexOf("Navn");
		int intclub = text.indexOf("Klubb");
		int intclass = text.indexOf("Klasse");
		int intplace = text.indexOf("Plassering");
		int intTimeFinished = text.indexOf("Tid i m");
		int intMaxTime = text.indexOf("Makstid");
		int intMellomtider = text.indexOf("Mellomtider");
		
		startnr = text.substring(intstartnr+56, intstartnr+100);
		startnr = startnr.substring(0, startnr.indexOf("<"));
		name = text.substring(intname+53, intname+100);
		name = name.substring(0, name.indexOf("<"));
		club = text.substring(intclub+54, intclub+100);
		club = club.substring(0, club.indexOf("<"));
		clas = text.substring(intclass+73, intclass+200);
		clas = clas.substring(0, clas.indexOf("<"));
		stringplace = text.substring(intplace+59, intplace+100);
		place = Integer.parseInt(stringplace.substring(0, stringplace.indexOf("<")));
		stringTimeFinished = text.substring(intTimeFinished+64, intTimeFinished+100);
		stringMaxTime = text.substring(intMaxTime+56, intMaxTime+100);
		stringSkramstad = text.substring(intMellomtider+479, intMellomtider+700);
		stringBringbu = text.substring(intMellomtider+529, intMellomtider+700);
		stringKvarstad = text.substring(intMellomtider+579, intMellomtider+700);
		stringStorasen = text.substring(intMellomtider+629, intMellomtider+700);
		
		try {
			timeFinished = sdf.parse(stringTimeFinished.substring(0, stringTimeFinished.indexOf("<")));
			maxTime = sdf.parse(stringMaxTime.substring(0, stringMaxTime.indexOf("<")));
			skramstad = sdf.parse(stringSkramstad.substring(0,stringSkramstad.indexOf("<")));
			bringbu = sdf.parse(stringBringbu.substring(0, stringBringbu.indexOf("<")));
			kvarstad = sdf.parse(stringKvarstad.substring(0, stringKvarstad.indexOf("<")));
			storasen = sdf.parse(stringStorasen.substring(0, stringStorasen.indexOf("<")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public String checkMadeTargetGoal(){
		long temp = timeFinished.getTime();
		long temp2 = maxTime.getTime();
		String out;
		if(temp>temp2){
			long tempe = temp-temp2;
			Date tempdate = new Date(tempe-(60*60*1000));
			out = "You didn't make it... "+sdf.format(tempdate)+" behinde.";
		}else{
			long temper = temp2-temp;
			Date tempdate2 = new Date(temper-(60*60*1000));
			out = "You made it! "+sdf.format(tempdate2)+" to spare.";
		}
		return out;
	}
	
	@Override
	public String toString(){
		String out = "Name: "+name+"\n"
				+"Startnumber: "+startnr+"\n"
				+"Club: "+club+"\n"
				+"Class: "+clas+"\n\n"
				+"Finish place: "+place+"\n"
				+"Finished in: "+sdf.format(timeFinished)+"\n"
				+"Goal time: "+sdf.format(maxTime)+"\n"
				+checkMadeTargetGoal()
//				+"\n\nMellomtider\n"
//				+"Skramstad: "+sdf.format(skramstad)+"\n"
//				+"Bringbu: "+sdf.format(bringbu)+"\n"
//				+"Kvarstad: "+sdf.format(kvarstad)+"\n"
//				+"Storåsen: "+sdf.format(storasen)
				;
		return out;
	}
}
