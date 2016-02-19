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
package org.apache.kerby.asn1.type;

/**
 * For tagging a sequence type with tagNo, either application specific or context specific class
 */
public class TaggingSet extends TaggingCollection {

    public TaggingSet(int taggingTagNo, Asn1FieldInfo[] tags, boolean isAppSpecific) {
        super(taggingTagNo, tags, isAppSpecific);
    }

    @Override
    protected Asn1CollectionType createTaggedCollection(Asn1FieldInfo[] tags) {
        return new Asn1SetType(tags);
    }
}
