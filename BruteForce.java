import java.util.Arrays;

public class Bruteforce
{
    
	private final static String ALPHA_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final static String ALPHA_LOWER = "abcdefghijklmnopqrstuvwxyz";
	private final static String ALPHA_NUMERIC = "0123456789";
	private final static String ALPHA_SPECIAL = " !\"#$%&\'()*+,-./:;<=>?@[\\]^_`{|}~";
	
	private final static String WORD = "aa";
	private final static int MAX_LENGTH = 2;
	
	private final char[] charset;
	private int[] idz = new int[1];
	private char[] result = new char[1];
	
	
	public Bruteforce() {
		this.charset = (ALPHA_LOWER + ALPHA_UPPER + ALPHA_NUMERIC + ALPHA_SPECIAL).toCharArray();
		this.idz[0] = -1;
	}

	public char[] brute(){
		for(int i = 0; i < this.idz.length; i++){
			if(this.idz[i] < this.charset.length - 1){
				this.idz[i]++;
				this.result[i] = this.charset[this.idz[i]];
			}else{
				if(i + 1 == this.idz.length){
					this.idz = new int[this.idz.length + 1];
					this.result = new char[this.result.length + 1];
					Arrays.fill(this.idz, 0);
					Arrays.fill(this.result, charset[0]);
				}else{
					this.idz[i] = 0;
					this.result[i] = this.charset[this.idz[i]];
					continue;
				}
			}
			break;
		}
		return this.result;
	}
	
	public static void main(String[] args) {
		Bruteforce bf = new Bruteforce();
		String find = "";
		do{
			find = new String(bf.brute());			
			if(find.length() > MAX_LENGTH)
				break;
		}while(!WORD.equals(find));
		
		if(WORD.equals(find))
		    System.out.println("Password: " + find);
		else
		    System.out.println("Password not found!");

	}
}