if we start it in grizzly, we can get a correct result:

1. gradle run

2. run this in terminal: curl http://localhost:12345/hello?name=中文

3. we will get "hello 中文" as a result.

but if we start it in tomcat, the encoding will mess the result up:

1. gradle tomcatRun

2. run this in terminal: curl http://localhost:12345/hello?name=中文

3. we will get a messed up string as a result.



upadte:

there is a workaround to fix this issue.

just do this:

curl -G "http://localhost:12345/hello" --data-urlencode "name=中文"

instead of doing this:

curl http://localhost:12345/hello?name=中文

then tomcat will work.

but still, how come grizzly works fine when we don't explicitly ask curl to encode the url, while for tomcat we have to do so explicitly?