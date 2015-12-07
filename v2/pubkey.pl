#!/usr/bin/perl

use bigint;

$p = 13;
$q = 17;
$exponent = 7;
$function = ($p - 1) * ($q - 1);
print "P & Q: " . $p . ", " . $q . "\n";
print "Modulus: " . ($p * $q) . "\n";
print "Exponent: " . $exponent . "\n";
print "Public key (encryption exponent, modulus) is: (" . $exponent . ", " . ($p * $q) . ")\n";

# Calculate the decryption (private) key
$privateDecryptKey = 0;
for($i = 0; $i < 1000; $i++){
  if(($i * $exponent) % $function == 1){
    $privateDecryptKey = $i;
    break;
  }
}
print "Private key is: " . $privateDecryptKey . "\n";

$secretMessage = "Hello World!";
print "Secret message is: " . $secretMessage . "\n";

# Encrypt the message
foreach(split //, $secretMessage){
  print ord($_)**$exponent % ($p * $q) . "\n";
  push @encryptedChars, (ord($_)**$exponent % ($p * $q));
}

# Decrypt the message with the private key
foreach (@encryptedChars){
  print chr(($_**$privateDecryptKey % ($p * $q)));
}
print "\n";
