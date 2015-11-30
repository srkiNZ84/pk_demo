import java.math.BigInteger;

public class PubKeyDemo {

  public static void main(String[] args){
    int result = 161 % 40;
    int p = 5;
    int q = 11;
    int exponent = 7;
    int function = (p - 1) * (q - 1);
    System.out.println("P & Q: " + p + ", " + q);
    System.out.println("Modulus: " + (p * q));
    System.out.println("Exponent: " + exponent);
    System.out.println("Public key (encryption exponent, modulus) is: (" + exponent + ", " + (p * q) + ")");
    int privateDecryptKey = 0;
    for(int i = 0; i < 1000; i++){
      if((i * exponent) % function == 1){
        privateDecryptKey = i;
        break;
      }
    }
    System.out.println("Private key is: " + privateDecryptKey);

    int secretMessage = 2;

    System.out.println("Secret message is: " + secretMessage);
    int temp = (int)(Math.pow(secretMessage, exponent)) % (p * q);
    BigInteger cypherText = new BigInteger("" + temp);
    System.out.println("Cyphertext is: " + cypherText);

    int temp2 = p * q;
    BigInteger plainText = cypherText.pow(privateDecryptKey).mod(new BigInteger("" + temp2));
    System.out.println("Decrypted plaintext is: " + plainText);
  }
}
