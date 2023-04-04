import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        // JSON to POJO

        IpInfo ipInfo;

        try {
            ipInfo = mapper.readValue(new URL("https://ipinfo.io/8.8.8.8/json"), IpInfo.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("IP INFO");
        System.out.println("ip: " + ipInfo.getIp());
        System.out.println("city: " + ipInfo.getCity());

        // POJO to JSON

        IpInfo ipInfo1 = new IpInfo();

        ipInfo1.setIp("8.8.8.8");
        ipInfo1.setHostname("name");
        ipInfo1.setAnycast(true);
        ipInfo1.setCity("balelas");
        ipInfo1.setRegion("blah");
        ipInfo1.setCountry("parvonia");
        ipInfo1.setLoc("loc loc");
        ipInfo1.setOrg("academiadecodigo");
        ipInfo1.setPostal("2615");
        ipInfo1.setTimezone("idk");
        ipInfo1.setReadme("readddd");

        File file = new File("ip.json");

        try {
            mapper.writeValue(file, ipInfo1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // JSON to POJO

        try {
            IpInfo ipInfo2 = mapper.readValue(file, IpInfo.class);

            System.out.println("\nIP INFO 2");
            System.out.println("org: " + ipInfo2.getOrg());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
