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
package org.apache.kerby.config;

public abstract class ConfigLoader {
    private Resource resource;
    private ConfigImpl config;

    protected void setResource(Resource resource) {
        this.resource = resource;
    }

    protected void setConfig(ConfigImpl config) {
        this.config = config;
    }

    public Config load() {
        if (config == null) {
            config = new ConfigImpl(resource.getName());
        }
        config.reset();

        try {
            loadConfig(config, resource);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load " + ConfigLoader.class.getPackage().getName(), e);
        }

        return this.config;
    }

    protected abstract void loadConfig(ConfigImpl config, Resource resource) throws Exception;
}
