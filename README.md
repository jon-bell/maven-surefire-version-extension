# surefire-version-changer

Configuration:

To install:
Copy to your maven `lib/ext/` directory and it will always run (to find the lib dir, do `mvn -version`, make sure to put in the `lib/ext` directory within that)

Example:

```
$ mvn -version
OpenJDK 64-Bit Server VM warning: ignoring option MaxPermSize=512m; support was removed in 8.0
Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
Maven home: /usr/local/Cellar/maven/3.6.3/libexec
Java version: 1.8.0_222, vendor: AdoptOpenJDK, runtime: /Library/Java/JavaVirtualMachines/jdk1.8.0_222-openjdk/Contents/Home/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.15.2", arch: "x86_64", family: "mac"
$ cp surefire-version-changer-0.0.1-SNAPSHOT.jar /usr/local/Cellar/maven/3.6.3/libexec/lib/ext/
```

Usage:
When running maven, add `-DsurefireVersion=<string>`, and the extension will change all versions of surefire and failsafe to the specified version.