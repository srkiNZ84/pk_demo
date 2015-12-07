import java.math.BigInteger;

public class PubKeyDemo {

  public static void main(String[] args){
    int p = 11;
    int q = 13;
    int exponent = 7;
    int function = (p - 1) * (q - 1);
    System.out.println("P & Q: " + p + ", " + q);
    System.out.println("Modulus: " + (p * q));
    System.out.println("Exponent: " + exponent);
    System.out.println("Public key (encryption exponent, modulus) is: (" + exponent + ", " + (p * q) + ")");

    // Calculate the decryption (private) key
    int privateDecryptKey = 0;
    for(int i = 0; i < 1000; i++){
      if((i * exponent) % function == 1){
        privateDecryptKey = i;
        break;
      }
    }
    System.out.println("Private key is: " + privateDecryptKey);

    // Intialize all of the things
    String secretMessage = "Hello World!";
    char[] secretMessageChar = secretMessage.toCharArray();
    int[] secretMessageAscii = new int[secretMessageChar.length];
    BigInteger[] secretMessageBigInt = new BigInteger[secretMessageChar.length];
    for(int i = 0; i < secretMessageChar.length; i++){
      secretMessageAscii[i] = (int)secretMessageChar[i];
    }
    System.out.println("Secret message is: " + secretMessage);

    // Encrypt the message using our public key
    BigInteger cypherText, plainText;
    for(int i = 0; i < secretMessageAscii.length; i++){
      plainText = new BigInteger("" + secretMessageAscii[i]);
      cypherText = plainText.pow(exponent).mod(new BigInteger("" + (p * q)));
      System.out.println("Cyphertext is: " + cypherText);
      secretMessageBigInt[i] = cypherText;
    }

    // Decrypt the message with the private key
    String decryptedMessage = "";
    for(int i = 0; i < secretMessageBigInt.length; i++){
      plainText = secretMessageBigInt[i].pow(privateDecryptKey).mod(new BigInteger("" + (p * q)));
      System.out.println("Decrypted plaintext is: " + plainText);
      decryptedMessage += (char)plainText.intValue();
    }
    System.out.println(decryptedMessage);
  }
}
