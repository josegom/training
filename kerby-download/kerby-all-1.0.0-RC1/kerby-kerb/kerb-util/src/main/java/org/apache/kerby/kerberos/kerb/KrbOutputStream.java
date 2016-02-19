/**
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License. 
 *  
 */
package org.apache.kerby.kerberos.kerb;

import org.apache.kerby.kerberos.kerb.spec.KerberosTime;
import org.apache.kerby.kerberos.kerb.spec.base.EncryptionKey;
import org.apache.kerby.kerberos.kerb.spec.base.PrincipalName;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public abstract class KrbOutputStream extends DataOutputStream {
    public KrbOutputStream(OutputStream out) {
        super(out);
    }

    public abstract void writePrincipal(PrincipalName principal, int version) throws IOException;

    public void writeRealm(String realm) throws IOException {
        writeCountedString(realm);
    }

    public abstract void writeKey(EncryptionKey key, int version) throws IOException;

    public void writeTime(KerberosTime ktime) throws IOException {
        int time = 0;
        if (ktime != null) {
            time = (int) (ktime.getValue().getTime() / 1000);
        }
        writeInt(time);
    }

    public void writeCountedString(String string) throws IOException {
        byte[] data = string != null ? string.getBytes(Charset.forName("UTF-8")) : null; // ASCII

        writeCountedOctets(data);
    }

    public void writeCountedOctets(byte[] data) throws IOException {
        if (data != null) {
            writeInt(data.length);
            write(data);
        } else {
            writeInt(0);
        }
    }
}
