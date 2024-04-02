/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.logging.log4j.kit.env.internal;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class DefaultPropertyMapperParserTest {

    private static final String RESOURCE = "META-INF/log4j/propertyMapping.json";

    @Test
    void should_parse_property_mapping_from_resource() throws Exception {
        final PropertyMapping mapping = DefaultPropertyMappingParser.parse(RESOURCE);
        assertThat(mapping.getLegacyKeys("two.legacy.keys")).isEqualTo(List.of("foo", "bar"));
        assertThat(mapping.getLegacyKeys("no.legacy.keys")).isEmpty();
        // this one does not exist in the file
        assertThat(mapping.getLegacyKeys("non.existent.key")).isEmpty();
    }
}
