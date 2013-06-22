(defproject rsa-signer "0.1.0"
  :description "A Clojure library for signing strings with private RSA keys."
  :signing {:gpg-key "HashObject Ltd <team@hashobject.com>"}
  :url "https://github.com/hashobject/rsa-signer"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.bouncycastle/bctsp-jdk16 "1.46"]])
