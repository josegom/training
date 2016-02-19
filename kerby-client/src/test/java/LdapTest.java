import org.apache.directory.server.annotations.CreateLdapServer;
import org.apache.directory.server.annotations.CreateTransport;
import org.apache.directory.server.core.annotations.ApplyLdifs;
import org.apache.directory.server.core.annotations.CreateDS;
import org.apache.directory.server.core.annotations.CreatePartition;
import org.apache.directory.server.core.api.DirectoryService;
import org.apache.directory.server.core.integ.AbstractLdapTestUnit;
import org.apache.directory.server.core.integ.FrameworkRunner;
import org.apache.directory.server.ldap.LdapServer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ldaptive.*;


/**
 * Created by jmgomez on 19/02/16.
 */
@RunWith(FrameworkRunner.class)
@CreateDS(name = "localhost",
        partitions =
                {
                        @CreatePartition(
                                name = "example",
                                suffix = "dc=stratio,dc=com")
                })
@CreateLdapServer(
        transports =
                {
                        @CreateTransport(protocol = "LDAP")
                }
)
@ApplyLdifs(
        {
       "dn: dc=stratio,dc=com",
               "objectClass: dcObject",
               "objectClass: organization",
               "dc: stratio",
               "o: Stratio Platform",
               
               "dn: ou=People,dc=stratio,dc=com",
               "objectClass: organizationalUnit",
               "objectClass: top",
               "ou: People",
               
               "dn: ou=Roles,dc=stratio,dc=com",
               "objectClass: top",
               "objectClass: organizationalUnit",
               "ou: Roles",
               
               "dn: uid=jgomez,ou=People,dc=stratio,dc=com",
               "objectClass: top",
               "objectClass: person",
               "objectClass: organizationalPerson",
               "objectClass: inetOrgPerson",
               "cn: Jose",
               "sn: Gomez",
               "uid: jgomez",
               "userPassword:: e21kNX1nZHliMjFMUVRjSUFOdHZZTVQ3UVZRPT0=",
               
               "dn: ou=manager,ou=Roles,dc=stratio,dc=com",
               "objectClass: top",
               "objectClass: organizationalUnit" ,
               "ou: manager" ,
               "" ,
               "dn: cn=manager_admin,ou=manager,ou=Roles,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: groupOfUniqueNames" ,
               "cn: manager_admin" ,
               "uniqueMember: uid=jgomez,ou=People,dc=stratio,dc=com" ,
               "uniqueMember: uid=manager1,ou=People,dc=stratio,dc=com" ,
               "uniqueMember: uid=manager3,ou=People,dc=stratio,dc=com" ,
               "" ,
               "dn: uid=viewer1,ou=People,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: person" ,
               "objectClass: organizationalPerson" ,
               "objectClass: inetOrgPerson" ,
               "cn: viewer_1" ,
               "sn: test" ,
               "uid: viewer1" ,
               "userPassword:: e21kNX1nZHliMjFMUVRjSUFOdHZZTVQ3UVZRPT0=" ,
               "" ,
               "dn: uid=viewer2,ou=People,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: person" ,
               "objectClass: organizationalPerson" ,
               "objectClass: inetOrgPerson" ,
               "cn: viewer_2" ,
               "sn: test" ,
               "uid: viewer2" ,
               "userPassword:: e21kNX1nZHliMjFMUVRjSUFOdHZZTVQ3UVZRPT0=" ,
               "" ,
               "dn: uid=manager1,ou=People,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: person" ,
               "objectClass: organizationalPerson" ,
               "objectClass: inetOrgPerson" ,
               "cn: manager_1" ,
               "sn: test" ,
               "uid: manager1" ,
               "userPassword:: e21kNX1nZHliMjFMUVRjSUFOdHZZTVQ3UVZRPT0=" ,
               "" ,
               "dn: uid=manager2,ou=People,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: person" ,
               "objectClass: organizationalPerson" ,
               "objectClass: inetOrgPerson" ,
               "cn: manager_2" ,
               "sn: test" ,
               "uid: manager2" ,
               "userPassword:: e21kNX1nZHliMjFMUVRjSUFOdHZZTVQ3UVZRPT0=" ,
               "" ,
               "dn: cn=manager_visualizer,ou=manager,ou=Roles,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: groupOfUniqueNames" ,
               "cn: manager_visualizer" ,
               "uniqueMember: uid=jgomez,ou=People,dc=stratio,dc=com" ,
               "uniqueMember: uid=manager2,ou=People,dc=stratio,dc=com" ,
               "uniqueMember: uid=manager3,ou=People,dc=stratio,dc=com" ,
               "" ,
               "dn: ou=viewer,ou=Roles,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: organizationalUnit" ,
               "ou: viewer" ,
               "" ,
               "dn: cn=viewer_admin,ou=viewer,ou=Roles,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: groupOfUniqueNames" ,
               "cn: viewer_admin" ,
               "uniqueMember: uid=jgomez,ou=People,dc=stratio,dc=com" ,
               "uniqueMember: uid=viewer2,ou=People,dc=stratio,dc=com" ,
               "uniqueMember: uid=viewer3,ou=People,dc=stratio,dc=com" ,
               "" ,
               "dn: cn=viewer_visualizer,ou=viewer,ou=Roles,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: groupOfUniqueNames" ,
               "cn: viewer_visualizer" ,
               "uniqueMember: uid=jgomez,ou=People,dc=stratio,dc=com" ,
               "uniqueMember: uid=viewer1,ou=People,dc=stratio,dc=com" ,
               "uniqueMember: uid=viewer3,ou=People,dc=stratio,dc=com" ,
               "" ,
               "dn: uid=viewer3,ou=People,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: person" ,
               "objectClass: organizationalPerson" ,
               "objectClass: inetOrgPerson" ,
               "cn: viewer_3" ,
               "sn: test" ,
               "uid: viewer3" ,
               "userPassword:: e21kNX1nZHliMjFMUVRjSUFOdHZZTVQ3UVZRPT0=" ,
               "" ,
               "dn: uid=manager3,ou=People,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: person" ,
               "objectClass: organizationalPerson" ,
               "objectClass: inetOrgPerson" ,
               "cn: manager_3" ,
               "sn: test" ,
               "uid: manager3" ,
               "userPassword:: e21kNX1nZHliMjFMUVRjSUFOdHZZTVQ3UVZRPT0=" ,
               "" ,
               "dn: ou=workflow,ou=Roles,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: organizationalUnit" ,
               "ou: workflow" ,
               "" ,
               "dn: uid=workflow1,ou=People,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: person" ,
               "objectClass: organizationalPerson" ,
               "objectClass: inetOrgPerson" ,
               "cn: manager_1" ,
               "sn: test" ,
               "uid: workflow1" ,
               "userPassword:: e21kNX1nZHliMjFMUVRjSUFOdHZZTVQ3UVZRPT0=" ,
               "" ,
               "dn: uid=workflow2,ou=People,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: person" ,
               "objectClass: organizationalPerson" ,
               "objectClass: inetOrgPerson" ,
               "cn: manager_1" ,
               "sn: test" ,
               "uid: workflow2" ,
               "userPassword:: e21kNX1nZHliMjFMUVRjSUFOdHZZTVQ3UVZRPT0=" ,
               "" ,
               "dn: uid=workflow3,ou=People,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: person" ,
               "objectClass: organizationalPerson" ,
               "objectClass: inetOrgPerson" ,
               "cn: manager_1" ,
               "sn: test" ,
               "uid: workflow3" ,
               "userPassword:: e21kNX1nZHliMjFMUVRjSUFOdHZZTVQ3UVZRPT0=" ,
               "" ,
               "dn: cn=workflow_designer,ou=workflow,ou=Roles,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: groupOfUniqueNames" ,
               "cn: workflow_designer" ,
               "uniqueMember: uid=workflow1,ou=People,dc=stratio,dc=com" ,
               "uniqueMember: uid=workflow3,ou=People,dc=stratio,dc=com" ,
               "" ,
               "dn: cn=workflow_executor,ou=workflow,ou=Roles,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: groupOfUniqueNames" ,
               "cn: workflow_executor" ,
               "uniqueMember: uid=workflow2,ou=People,dc=stratio,dc=com" ,
               "uniqueMember: uid=workflow3,ou=People,dc=stratio,dc=com" ,
               "" ,
               "dn: ou=sparkta,ou=Roles,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: organizationalUnit" ,
               "ou: sparkta" ,
               "" ,
               "dn: cn=sparkta_manager,ou=sparkta,ou=Roles,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: groupOfUniqueNames" ,
               "cn: sparkta_manager" ,
               "uniqueMember: uid=sparkta1,ou=People,dc=stratio,dc=com" ,
               "uniqueMember: uid=sparkta3,ou=People,dc=stratio,dc=com" ,
               "" ,
               "dn: uid=sparkta1,ou=People,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: person" ,
               "objectClass: organizationalPerson" ,
               "objectClass: inetOrgPerson" ,
               "cn: manager_2" ,
               "sn: test" ,
               "uid: sparkta1" ,
               "userPassword:: e21kNX1nZHliMjFMUVRjSUFOdHZZTVQ3UVZRPT0=" ,
               "" ,
               "dn: uid=sparkta2,ou=People,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: person" ,
               "objectClass: organizationalPerson" ,
               "objectClass: inetOrgPerson" ,
               "cn: manager_2" ,
               "sn: test" ,
               "uid: sparkta2" ,
               "userPassword:: e21kNX1nZHliMjFMUVRjSUFOdHZZTVQ3UVZRPT0=" ,
               "" ,
               "dn: uid=sparkta3,ou=People,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: person" ,
               "objectClass: organizationalPerson" ,
               "objectClass: inetOrgPerson" ,
               "cn: manager_2" ,
               "sn: test" ,
               "uid: sparkta3" ,
               "userPassword:: e21kNX1nZHliMjFMUVRjSUFOdHZZTVQ3UVZRPT0=" ,
               "" ,
               "dn: uid=sparkta4,ou=People,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: person" ,
               "objectClass: organizationalPerson" ,
               "objectClass: inetOrgPerson" ,
               "cn: manager_2" ,
               "sn: test" ,
               "uid: sparkta4" ,
               "userPassword:: e21kNX1nZHliMjFMUVRjSUFOdHZZTVQ3UVZRPT0=" ,
               "" ,
               "dn: cn=sparkta_executor,ou=sparkta,ou=Roles,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: groupOfUniqueNames" ,
               "cn: sparkta_executor" ,
               "uniqueMember: uid=sparkta1,ou=People,dc=stratio,dc=com" ,
               "uniqueMember: uid=sparkta2,ou=People,dc=stratio,dc=com" ,
               "" ,
               "dn: cn=sparkta_designer,ou=sparkta,ou=Roles,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: groupOfUniqueNames" ,
               "cn: sparkta_designer" ,
               "uniqueMember: uid=sparkta1,ou=People,dc=stratio,dc=com" ,
               "uniqueMember: uid=sparkta4,ou=People,dc=stratio,dc=com" ,
               "" ,
               "dn: ou=intelligence,ou=Roles,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: organizationalUnit" ,
               "ou: intelligence" ,
               "" ,
               "dn: uid=intelligence1,ou=People,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: person" ,
               "objectClass: organizationalPerson" ,
               "objectClass: inetOrgPerson" ,
               "cn: manager_1" ,
               "sn: test" ,
               "uid: intelligence1" ,
               "userPassword:: e21kNX1nZHliMjFMUVRjSUFOdHZZTVQ3UVZRPT0=" ,
               "" ,
               "dn: cn=intelligence_admin,ou=intelligence,ou=Roles,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: groupOfUniqueNames" ,
               "cn: intelligence_admin" ,
               "uniqueMember: uid=intelligence1,ou=People,dc=stratio,dc=com" ,
               "uniqueMember: uid=intelligence2,ou=People,dc=stratio,dc=com" ,
               "" ,
               "dn: cn=intelligence_executor,ou=intelligence,ou=Roles,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: groupOfUniqueNames" ,
               "cn: intelligence_executor" ,
               "uniqueMember: uid=intelligence1,ou=People,dc=stratio,dc=com" ,
               "uniqueMember: uid=intelligence3,ou=People,dc=stratio,dc=com" ,
               "" ,
               "dn: uid=intelligence2,ou=People,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: person" ,
               "objectClass: organizationalPerson" ,
               "objectClass: inetOrgPerson" ,
               "cn: manager_1" ,
               "sn: test" ,
               "uid: intelligence2" ,
               "userPassword:: e21kNX1nZHliMjFMUVRjSUFOdHZZTVQ3UVZRPT0=" ,
               "" ,
               "dn: uid=intelligence3,ou=People,dc=stratio,dc=com" ,
               "objectClass: top" ,
               "objectClass: person" ,
               "objectClass: organizationalPerson" ,
               "objectClass: inetOrgPerson" ,
               "cn: manager_1" ,
               "sn: test" ,
               "uid: intelligence3" ,
               "userPassword:: e21kNX1nZHliMjFMUVRjSUFOdHZZTVQ3UVZRPT0="
        }
)
public class LdapTest extends AbstractLdapTestUnit {


    /** The used DirectoryService instance */
    private static DirectoryService service;

    /** The used LdapServer instance */
    private static LdapServer ldapServer;

    public static DirectoryService getService() {
        return service;
    }


    public static void setService(DirectoryService service_) {

        service = service_;
    }


    public static LdapServer getLdapServer() {
        return ldapServer;
    }


    public static void setLdapServer(LdapServer ldapServer_) {

        ldapServer = ldapServer_;
    }


   /* @Before
    public void startUp() throws Exception {

        getLdapServer().start();

    }*/


    @Test
    public void testSearchAllAttrs() throws Exception
    {
        System.out.println(getLdapServer().getName());

        ConnectionConfig connConfig = new ConnectionConfig("ldap://127.0.1.1:"+getLdapServer().getPort());
        connConfig.setConnectionInitializer(
                new BindConnectionInitializer("uid=admin,ou=system", new Credential("secret")));

        ConnectionFactory connFactory = new DefaultConnectionFactory(connConfig);
        Connection conn = connFactory.getConnection();

        try {
            // open the connection to the ldap
            conn.open();

            SearchOperation search = new SearchOperation(conn);



            SearchResult result = search.execute(
                    new SearchRequest(          "","(ObjectClass=organizationalUnit)","uid")).getResult();
            LdapEntry entry = result.getEntry();

            for (LdapAttribute ldapAtt:entry.getAttributes()){
                System.out.println(ldapAtt.getName()+" <--> "+       ldapAtt.getStringValue());
            }
        } finally {
            // close the connection to the ldap
            conn.close();
        }
    }



}
