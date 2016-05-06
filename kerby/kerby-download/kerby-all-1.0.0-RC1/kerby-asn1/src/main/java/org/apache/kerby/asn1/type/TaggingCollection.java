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

import org.apache.kerby.asn1.EncodingOption;
import org.apache.kerby.asn1.LimitedByteBuffer;
import org.apache.kerby.asn1.TagClass;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * For tagging a collection type with tagNo, either application specific or context specific class
 */
public abstract class TaggingCollection extends AbstractAsn1Type<Asn1CollectionType> {
    private Asn1Tagging<Asn1CollectionType> tagging;
    private Asn1CollectionType tagged;

    public TaggingCollection(int taggingTagNo, Asn1FieldInfo[] tags, boolean isAppSpecific) {
        super(isAppSpecific ? TagClass.APPLICATION : TagClass.CONTEXT_SPECIFIC, taggingTagNo);
        this.tagged = createTaggedCollection(tags);
        setValue(tagged);
        this.tagging = new Asn1Tagging<Asn1CollectionType>(taggingTagNo, tagged, isAppSpecific);
        getEncodingOption().useExplicit();
    }

    protected abstract Asn1CollectionType createTaggedCollection(Asn1FieldInfo[] tags);

    @Override
    public void setEncodingOption(EncodingOption encodingOption) {
        tagging.setEncodingOption(encodingOption);
    }

    @Override
    public EncodingOption getEncodingOption() {
        return tagging.getEncodingOption();
    }

    @Override
    public boolean isConstructed() {
        return tagging.isConstructed();
    }

    @Override
    protected int encodingBodyLength() {
        return tagging.encodingBodyLength();
    }

    @Override
    protected void encodeBody(ByteBuffer buffer) {
        tagging.encodeBody(buffer);
    }

    @Override
    protected void decodeBody(LimitedByteBuffer content) throws IOException {
        tagging.decodeBody(content);
    }

    protected <T extends Asn1Type> T getFieldAs(int index, Class<T> t) {
        return tagged.getFieldAs(index, t);
    }

    protected void setFieldAs(int index, Asn1Type value) {
        tagged.setFieldAs(index, value);
    }

    protected String getFieldAsString(int index) {
        return tagged.getFieldAsString(index);
    }

    protected byte[] getFieldAsOctets(int index) {
        return tagged.getFieldAsOctets(index);
    }

    protected void setFieldAsOctets(int index, byte[] bytes) {
        tagged.setFieldAsOctets(index, bytes);
    }

    protected Integer getFieldAsInteger(int index) {
        return tagged.getFieldAsInteger(index);
    }

    protected void setFieldAsInt(int index, int value) {
        tagged.setFieldAsInt(index, value);
    }

    protected byte[] getFieldAsOctetBytes(int index) {
        return tagged.getFieldAsOctets(index);
    }

    protected void setFieldAsOctetBytes(int index, byte[] value) {
        tagged.setFieldAsOctets(index, value);
    }
}
