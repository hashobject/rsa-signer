(ns rsa-signer.core
  "Library for signing strings with private RSA keys.")

(java.security.Security/addProvider
 (org.bouncycastle.jce.provider.BouncyCastleProvider.))

(defn- read-key [f]
  (-> f
      java.io.FileReader.
      org.bouncycastle.openssl.PEMReader.
      .readObject))


(defn- sign-bytes-with-private-key [data private-key algorithm]
  (let [sig (doto (java.security.Signature/getInstance algorithm "BC")
              (.initSign private-key (java.security.SecureRandom.))
              (.update data))]
    (.sign sig)))


(defn- rsa-key [filepath]
  (read-key (java.io.File. filepath)))


(defn sign [s private-key-file-path algorithm]
  "Sign input string `s` with private RSA key
   located at path `private-key-file-path`
   according to the algorithm.
   Algorithm can be one of the following:
    - RSA - that means that input string will be signed directly with RSA private key.
    - SHA1withRSA - that means than input string will be hashed using SHA-1 and than signed with RSA private key.
    - SHA256withRSA - that means than input string will be hashed using SHA-1 and than signed with RSA private key.
   Method returns signed string in form on byte array.
  "
  (sign-bytes-with-private-key
     (.getBytes s)
     (.getPrivate (rsa-key private-key-file-path))
     algorithm))



