package com.stratio.train.kerby.client;

import org.apache.kerby.kerberos.kerb.KrbException;
import org.apache.kerby.kerberos.kerb.client.KrbClient;
import org.apache.kerby.kerberos.kerb.client.KrbConfig;

import java.io.File;

public class Client {


    public static void main(String args[])
    {
        try {
            KrbConfig config = new KrbConfig();
            config.setString("kdc_host","localhost");
            config.setString("kdc_realm","EXAMPLE.COM");
            config.setInt("kdc_tcp_port",8015);
            config.setInt("kdc_udp_port",8016);




            //KrbClient krbClient = new KrbClient(new File("/home/jmgomez/tmp/kerby/client/conf"));
            KrbClient krbClient = new KrbClient(config);
            System.out.println(krbClient.getKrbConfig());
            krbClient.init();
            System.out.println(krbClient.requestTgtWithPassword("jmgomez@EXAMPLE.COM","1234"));
        } catch (KrbException e) {
            e.printStackTrace();
        }
    }
}
