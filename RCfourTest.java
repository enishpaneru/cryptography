import static org.junit.Assert.*;

import org.junit.Test;

public class RCfourTest {

	@Test
	public void testcase() {
		Cipher testcase=new StreamCipher();
		String seedkey="37157103";
		String testmsg=new String();
		for (int i=0;i<256;i++){
			testmsg+='1';
		}
		String ciphertextvalue=testcase.encrypt(testmsg,seedkey);
		assertEquals(testmsg,testcase.decrypt(ciphertextvalue,seedkey));

	}

}
