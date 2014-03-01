if we start it in grizzly, we can get a correct result:

1. gradle run

2. run this in terminal: curl http://localhost:12345/hello?name=中文

3. we will get "hello 中文" as a result.


but if we start it in tomcat, the encoding will mess the result up:

1. gradle tomcatRun

2. run this in terminal: curl http://localhost:12345/hello?name=中文

3. we will get a messed up string as a result.