/*
 * Copyright © 2012 - 2018 camunda services GmbH and various authors (info@camunda.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.engine.impl.variable.serializer;

import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.impl.value.UntypedValueImpl;
import org.camunda.bpm.engine.variable.type.ValueType;
import org.camunda.bpm.engine.variable.value.DoubleValue;

/**
 *
 * @author Daniel Meyer
 */
public class DoubleValueSerializer extends PrimitiveValueSerializer<DoubleValue> {

  public DoubleValueSerializer() {
    super(ValueType.DOUBLE);
  }

  public DoubleValue convertToTypedValue(UntypedValueImpl untypedValue) {
    return Variables.doubleValue((Double) untypedValue.getValue(), untypedValue.isTransient());
  }

  public void writeValue(DoubleValue value, ValueFields valueFields) {
    valueFields.setDoubleValue(value.getValue());
  }

  public DoubleValue readValue(ValueFields valueFields) {
    return Variables.doubleValue(valueFields.getDoubleValue());
  }

}
