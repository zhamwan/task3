package src;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Key {
    String random;
    public Key(String random){
        this.random = random;
    }
    public String getHmac(String step, int i) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKey secretKeySpec = new SecretKeySpec((random+step + i).getBytes(), "HmacSHA256");
        mac.init(secretKeySpec);
        byte[] hmac = mac.doFinal(step.getBytes());
        return String.format("HMAC:%032x", new BigInteger(1, hmac));
    }
}
