how to reproduce:

1. start moco by using the bat file (we can only reproduce on Windows machines)
2. run the shouldMakeNettyStopResponding test

then you should be able to see the second request fail


interesting fact:

the error only happens when we have those two things in pom:
        <dependency>
            <groupId>org.apache.cxf</groupId>
            <artifactId>cxf-rt-frontend-jaxws</artifactId>
            <version>2.5.2</version>
        </dependency>
        <dependency>
            <groupId>org.apache.cxf</groupId>
            <artifactId>cxf-rt-transports-http</artifactId>
            <version>2.5.2</version>
        </dependency>
        
if we remove them, we can not reproduce the error anymore.
