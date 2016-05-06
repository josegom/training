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
package org.apache.kerby.kerberos.kerb.spec.base;

import org.apache.kerby.asn1.type.Asn1FieldInfo;
import org.apache.kerby.asn1.type.Asn1Integer;
import org.apache.kerby.asn1.type.Asn1OctetString;
import org.apache.kerby.kerberos.kerb.spec.KerberosString;
import org.apache.kerby.kerberos.kerb.spec.KrbSequenceType;

/**
 ETYPE-INFO2-ENTRY       ::= SEQUENCE {
 etype           [0] Int32,
 salt            [1] KerberosString OPTIONAL,
 s2kparams       [2] OCTET STRING OPTIONAL
 }
 */
public class EtypeInfo2Entry extends KrbSequenceType {
    private static final int ETYPE = 0;
    private static final int SALT = 1;
    private static final int S2KPARAMS = 2;

    static Asn1FieldInfo[] fieldInfos = new Asn1FieldInfo[] {
            new Asn1FieldInfo(ETYPE, 0, Asn1Integer.class),
            new Asn1FieldInfo(SALT, 1, KerberosString.class),
            new Asn1FieldInfo(S2KPARAMS, 2, Asn1OctetString.class)
    };

    public EtypeInfo2Entry() {
        super(fieldInfos);
    }

    public EncryptionType getEtype() {
        return EncryptionType.fromValue(getFieldAsInt(ETYPE));
    }

    public void setEtype(EncryptionType etype) {
        setField(ETYPE, etype);
    }

    public String getSalt() {
        return getFieldAsString(SALT);
    }

    public void setSalt(String salt) {
        setFieldAsString(SALT, salt);
    }

    public byte[] getS2kParams() {
        return getFieldAsOctets(S2KPARAMS);
    }

    public void setS2kParams(byte[] s2kParams) {
        setFieldAsOctets(S2KPARAMS, s2kParams);
    }
}
