// Copyright 2020 Goldman Sachs
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.finos.legend.pure.runtime.java.compiled.generation.processors.natives.core.meta;

import org.eclipse.collections.api.list.ListIterable;
import org.finos.legend.pure.m4.coreinstance.CoreInstance;
import org.finos.legend.pure.runtime.java.compiled.generation.ProcessorContext;
import org.finos.legend.pure.runtime.java.compiled.generation.processors.natives.AbstractNative;
import org.finos.legend.pure.runtime.java.compiled.generation.processors.type.FullJavaPaths;

public class EnumName extends AbstractNative
{
    public EnumName()
    {
        super("enumName_Enumeration_1__String_1_");
    }

    @Override
    public String build(CoreInstance topLevelElement, CoreInstance functionExpression, ListIterable<String> transformedParams, ProcessorContext processorContext)
    {
        return "((" + FullJavaPaths.Enumeration + ")" + transformedParams.get(0) + ")._name()";
    }

    @Override
    public String buildBody()
    {
        return "new PureFunction1<" + FullJavaPaths.Enumeration + ", String>()\n" +
                "        {\n" +
                "            @Override\n" +
                "            public String value(" + FullJavaPaths.Enumeration + " input, ExecutionSupport es)\n" +
                "            {\n" +
                "                return input._name();\n" +
                "            }\n" +
                "        }";
    }
}
