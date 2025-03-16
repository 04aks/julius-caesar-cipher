# encryption used by Julius Caesar (came up with it I think)
Simple text encryption by sliding the entire alphabet over by a set number of places detirmined by a KEY
BEWARE flawed and insecure encyption (u should know this already if you are in this website but still...)

# Implementation
## POM XML
add the dependency (maven)
```xml
  	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

  	<dependency>
	    <groupId>com.github.04aks</groupId>
	    <artifactId>julius-caesar-cipher</artifactId>
	    <version>Tag</version>
	</dependency>
```
## Java
1- Encrypting words:
```java
        Encrypter encrypter = new Encrypter();
        // SEPARATE WORDS WITH A ',' 
        List<String> encryptedWords = encrypter.encryptWords("goat,imitate,syrup,gates,high", "nine");
    
        for(String s : encryptedWords){
            System.out.println(s);
        }
```
2- Decrypting words:
```java
        Encrypter encrypter = new Encrypter();
        // SEPARATE WORDS WITH A ',' 
        List<String> encryptedWords = encrypter.decryptWords("uxoy,wvwyocs,ghfzd,ujhjg,vrum", "nine");
    
        for(String s : encryptedWords){
            System.out.println(s);
        }
```
