/*
 *  Copyright (c) 2019  Stefan Spiska (Vitasystems GmbH) and Hannover Medical School
 *  This file is part of Project EHRbase
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.ehrbase.client.introspect.config;

import org.ehrbase.client.terminology.ValueSet;

import java.util.Collections;
import java.util.Set;

/**
 * Common interface for config sub-classes, each for one type of openEHR RM 'container' class.
 */
public interface RmIntrospectConfig {

    /**
     * Gets class.
     * @return Archie RM class matching the type
     */
    Class getRMClass();

    /**
     * Gets a list of all non-template fields.
     * @return Set of fields as Strings.
     */
    Set<String> getNonTemplateFields();

    /**
     * Finds and returns a matching value in the class' terminology.
     * @param fieldName Given field name
     * @return Matching terminology value set
     */
    default ValueSet findExternalValueSet(String fieldName) {
        return new ValueSet(ValueSet.LOCAL, Collections.emptySet());
    }
}
