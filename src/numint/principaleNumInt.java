package numint;

public class principaleNumInt {

	public static void main(String[] args) {
     
		   numeroIntero ottantasette = new numeroIntero (87);
		   numeroIntero settantotto = new numeroIntero (78);
		   
		   sommaNumInt smi = new sommaNumInt ();
		   
		   int smm = smi.somma(ottantasette.getNumber(), settantotto.getNumber());
		
		   System.out.println(smm);
		        
		
	}

}
