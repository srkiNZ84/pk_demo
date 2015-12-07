#!/usr/bin/perl

$p = 11;
$q = 13;
$exponent = 7;
$function = ($p - 1) * ($q - 1);
print "P & Q: " . $p . ", " . $q . "\n";
print "Modulus: " . ($p * $q) . "\n";
print "Exponent: " . $exponent . "\n";
print "Public key (encryption exponent, modulus) is: (" . $exponent . ", " . ($p * $q) . ")\n";
