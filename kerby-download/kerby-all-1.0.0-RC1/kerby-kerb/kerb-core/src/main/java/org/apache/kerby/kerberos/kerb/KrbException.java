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

public class KrbException extends Exception {
    private static final long serialVersionUID = 7305497872367599428L;
    private KrbErrorCode errorCode;

    public KrbException(String message) {
        super(message);
    }

    public KrbException(String message, Throwable cause) {
        super(message, cause);
    }

    public KrbException(KrbErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public KrbException(KrbErrorCode errorCode, Throwable cause) {
        super(errorCode.getMessage(), cause);
        this.errorCode = errorCode;
    }

    public KrbException(KrbErrorCode errorCode, String message) {
        super(message + " with error code: " + errorCode.name());
        this.errorCode = errorCode;
    }

    public KrbErrorCode getErrorCode() {
        return errorCode;
    }
}
