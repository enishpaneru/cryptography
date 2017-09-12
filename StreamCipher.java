
public class StreamCipher implements Cipher{
	@Override
	public String encrypt(String plaintext,String seedkey){
		String ciphertext=new String();
		//Initialization
		int[] keystream=initialization(seedkey);

		//generation
		ciphertext=generation(plaintext,keystream);
		System.out.println("Ciphertext: "+ciphertext);
		return ciphertext;
		
		
	}
	@Override
	public String decrypt(String ciphertext,String seedkey){
		String plaintext=new String();
		//Initialization
		int[] keystream=initialization(seedkey);

		//generation
		plaintext=generation(ciphertext,keystream);
		return plaintext;
		
		
	}

	public int[] initialization(String seedkey){
		int temp;
		int[] keystream=new int[256];
		for(int i=0;i<256;i++)
			{keystream[i]=i;}
	
		int j=0;
		for(int i=0;i<256;i++){
			j=(j+keystream[i]+(int)seedkey.charAt(i%seedkey.length()))%256;
			temp=keystream[i];
			keystream[i]=keystream[j];
			keystream[j]=temp;
		}	

		return keystream;
	}
	public String generation(String message,int[] keystream){
		int temp;
		String ciphertext=new String();
		int i=0;
		int j=0;
		for(int k=0;k<256;k++){
			i=(i+1)%256;
			j=(j+keystream[i])%256;
			temp=keystream[i];
			keystream[i]=keystream[j];
			keystream[j]=temp;
			ciphertext+=(char)(message.charAt(k) ^ keystream[(keystream[i]+keystream[j])%256]);
		
		}
	
		return ciphertext;
	}
}
