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
package org.apache.kerby.kerberos.kerb.crypto.key;

import org.apache.kerby.kerberos.kerb.KrbException;
import org.apache.kerby.kerberos.kerb.crypto.util.Pbkdf;
import org.apache.kerby.kerberos.kerb.crypto.enc.provider.AesProvider;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

public class AesKeyMaker extends DkKeyMaker {

    public AesKeyMaker(AesProvider encProvider) {
        super(encProvider);
    }

    @Override
    public byte[] random2Key(byte[] randomBits) throws KrbException {
        return randomBits;
    }

    @Override
    public byte[] str2key(String string, String salt, byte[] param) throws KrbException {
        int iterCount = getIterCount(param, 4096);

        byte[] saltBytes = null;
        try {
            saltBytes = getSaltBytes(salt, null);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        int keySize = encProvider().keySize();
        byte[] random;
        try {
            random = Pbkdf.pbkdf2(string.toCharArray(), saltBytes, iterCount, keySize);
        } catch (GeneralSecurityException e) {
            throw new KrbException("pbkdf2 failed", e);
        }

        byte[] tmpKey = random2Key(random);
        return dk(tmpKey, KERBEROS_CONSTANT);
    }

}
