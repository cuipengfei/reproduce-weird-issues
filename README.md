how to reproduce:

1. start moco by using the bat file (we can only reproduce on Windows machines)
2. run the shouldMakeNettyStopResponding test

then you should be able to see the second request fail


interesting fact:

the error only happens when we have those two things in pom:

    cxf-rt-frontend-jaxws
    
    cxf-rt-transports-http
    
    
if we remove them, we can not reproduce the error anymore.
