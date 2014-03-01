import localhost._12306.hello_world_soap_http.Greeter;
import localhost._12306.hello_world_soap_http.SOAPService;
import org.junit.Test;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

//how to reproduce the issue:
//start moco, using the main_config.json
//then run this test, the second request will get no response.

//interesting fact:
//if we keep the cxf-rt-frontend-jaxws and cxf-rt-transports-http as our dependencies
//we can make netty stop responding
//if we remove those two dependencies, then we can get responses very quickly

public class StopNettyTest {
    private static final QName SERVICE_NAME =
            new QName("http://localhost:12306/hello_world_soap_http",
                    "SOAPService");

    @Test
    public void shouldMakeNettyStopResponding() throws MalformedURLException, InterruptedException {
        URL wsdlURL = this.getClass().getResource("hello_world.wsdl");
        SOAPService service = new SOAPService(wsdlURL, SERVICE_NAME);
        Greeter port = service.getSoapPort();
        for (int i = 1; i < 10; i++) {
            System.out.println(i + " start");
            port.sayHi();
            System.out.println(i + " end");
            //java.lang.Thread.sleep(5000); //adding this sleep can get response
        }
    }
}
