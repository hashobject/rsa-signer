# rsa-signer

Clojure library which has only one method that signs string with RSA private key.

Library is heavily inspired by this blog [post](http://nakkaya.com/2012/10/28/public-key-cryptography/)
on public key cryptography.

## Install

```
[rsa-signer "0.1.0"]
```


## Usage

```
user=> (use 'rsa-signer.core)
null
user=> (sign "some-string-to-sign" "/Users/podviaznikov/.ssh/id_rsa" "SHA1withRSA")
#<byte[] [B@40914272>
```

There are 3 options that you can pass as last parameter(algorithm) to this function:

  * RSA - that means that input string will be signed directly with RSA private key.
  * SHA1withRSA - that means than input string will be hashed using SHA-1 and than signed with RSA private key.
  * SHA256withRSA - that means than input string will be hashed using SHA-1 and than signed with RSA private key.


## Contributions

We love contributions. Please submit your pull requests.



## License

Copyright © 2013 Hashobject Ltd (team@hashobject.com).

Distributed under the [Eclipse Public License](http://opensource.org/licenses/eclipse-1.0).