package src;
import java.math.*;
import java.security.SecureRandom;

public class Random {
    SecureRandom random = new SecureRandom();

    public byte[] getKey(){
        byte bytes[] = new byte[16];
        random.nextBytes(bytes);
        return bytes;
    }

    public int getStep(int len){
        while (true){
        int i =  random.nextInt(len);
        if(i != 0 ){
            return i;
        }
    }}
}
