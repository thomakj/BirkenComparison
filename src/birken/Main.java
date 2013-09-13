package birken;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	private Person one;
	private Person two;

	Date skramstad, bringbu, kvarstad, storasen, finish;	
	DateFormat sdf;
	
	boolean bskram, bbring, bkvar, bstor, bfin;
	
	public Person getPerson(int n){
		switch (n) {
		case 1:
			return one;
		case 2:
			return two;
		default:
			return null;
		}
	}

	public Main(int startnrOne, int startnrTwo){
		one = new Person(startnrOne);
		two = new Person(startnrTwo);
		bskram = false;
		bbring = false;
		bkvar = false;
		bstor = false;
		bfin = false;
		
		sdf = new SimpleDateFormat("HH:mm:ss");
		sdf.format(new Date());
		
		compairTime();
	}

	public void compairTime(){
		long tmpskramstad, tmpbringbu, tmpkvarstad, tmpstorasen, tmpfinish;
		if(one.getSum().getSkramstad().compareTo(two.getSum().getSkramstad())>0){			
			tmpskramstad = (one.getSum().getSkramstad().getTime()-two.getSum().getSkramstad().getTime())-(60*60*1000);
		}else{			
			tmpskramstad = (two.getSum().getSkramstad().getTime()-one.getSum().getSkramstad().getTime())-(60*60*1000);
			bskram = true;
		}
		if(one.getSum().getBringbu().compareTo(two.getSum().getBringbu())>0){			
			tmpbringbu = (one.getSum().getBringbu().getTime()-two.getSum().getBringbu().getTime())-(60*60*1000);
		}else{			
			tmpbringbu = (two.getSum().getBringbu().getTime()-one.getSum().getBringbu().getTime())-(60*60*1000);
			bbring = true;
		}
		if(one.getSum().getKvarstad().compareTo(two.getSum().getKvarstad())>0){
			tmpkvarstad = (one.getSum().getKvarstad().getTime()-two.getSum().getKvarstad().getTime())-(60*60*1000);
		}else{
			tmpkvarstad = (two.getSum().getKvarstad().getTime()-one.getSum().getKvarstad().getTime())-(60*60*1000);
			bkvar = true;
		}
		if(one.getSum().getStorasen().compareTo(two.getSum().getStorasen())>0){
			tmpstorasen = (one.getSum().getStorasen().getTime()-two.getSum().getStorasen().getTime())-(60*60*1000);			
		}else{
			tmpstorasen = (two.getSum().getStorasen().getTime()-one.getSum().getStorasen().getTime())-(60*60*1000);
			bstor = true;
		}
		if (one.getSum().getTimeFinished().compareTo(two.getSum().getTimeFinished())>0) {
			tmpfinish = (one.getSum().getTimeFinished().getTime()-two.getSum().getTimeFinished().getTime())-(60*60*1000);			
		}else{			
			tmpfinish = (two.getSum().getTimeFinished().getTime()-one.getSum().getTimeFinished().getTime())-(60*60*1000);
			bfin = true;
		}
		skramstad = new Date(tmpskramstad);
		bringbu = new Date(tmpbringbu);
		kvarstad = new Date(tmpkvarstad);
		storasen = new Date(tmpstorasen);
		finish = new Date(tmpfinish);
	}

	@Override
	public String toString(){
		String out = "";
		if(bskram){
			out += "Skramstad:		"+sdf.format(one.getSum().getKvarstad())+"	 "+sdf.format(skramstad)+"	"+sdf.format(two.getSum().getKvarstad())+"\n";
		}else{
			out += "Skramstad:		"+sdf.format(one.getSum().getKvarstad())+"	-"+sdf.format(skramstad)+"	"+sdf.format(two.getSum().getKvarstad())+"\n";
		}
		if(bbring){
			out += "Bringbu:			"+sdf.format(one.getSum().getBringbu())+"	 "+sdf.format(bringbu)+"	"+sdf.format(two.getSum().getBringbu())+"\n";
		}else{
			out += "Bringbu:			"+sdf.format(one.getSum().getBringbu())+"	-"+sdf.format(bringbu)+"	"+sdf.format(two.getSum().getBringbu())+"\n";
		}
		if(bkvar){
			out += "Kvarstad:		"+sdf.format(one.getSum().getKvarstad())+"	 "+sdf.format(kvarstad)+"	"+sdf.format(two.getSum().getKvarstad())+"\n";
		}else{
			out += "Kvarstad:		"+sdf.format(one.getSum().getKvarstad())+"	-"+sdf.format(kvarstad)+"	"+sdf.format(two.getSum().getKvarstad())+"\n";
		}
		if(bstor){			
			out += "Storåsen:		"+sdf.format(one.getSum().getStorasen())+"	 "+sdf.format(storasen)+"	"+sdf.format(two.getSum().getStorasen())+"\n";
		}else{
			out += "Storåsen:		"+sdf.format(one.getSum().getStorasen())+"	-"+sdf.format(storasen)+"	"+sdf.format(two.getSum().getStorasen())+"\n";
		}
		if(bfin){
			out += "Finish:			"+sdf.format(one.getSum().getTimeFinished())+"	 "+sdf.format(finish)+"	"+sdf.format(two.getSum().getTimeFinished());
		}else{
			out += "Finish:			"+sdf.format(one.getSum().getTimeFinished())+"	-"+sdf.format(finish)+"	"+sdf.format(two.getSum().getTimeFinished());
		}
		return out;
	}
}
