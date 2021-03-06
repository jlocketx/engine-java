/****************************************************************************
 *                                                                          *
 * Copyright 2014 Prelert Ltd                                               *
 *                                                                          *
 * Licensed under the Apache License, Version 2.0 (the "License");          *
 * you may not use this file except in compliance with the License.         *
 * You may obtain a copy of the License at                                  *
 *                                                                          *
 *    http://www.apache.org/licenses/LICENSE-2.0                            *
 *                                                                          *
 * Unless required by applicable law or agreed to in writing, software      *
 * distributed under the License is distributed on an "AS IS" BASIS,        *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. *
 * See the License for the specific language governing permissions and      *
 * limitations under the License.                                           *
 *                                                                          *
 ***************************************************************************/

package com.prelert.job;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * Defines the fields to be used in the analysis.
 * <code>fieldname</code> must be set and only one of <code>byFieldName</code>
 * and <code>overFieldName</code> should be set.
 */
@JsonInclude(Include.NON_NULL)
public class Detector
{
    public static final String FUNCTION = "function";
    public static final String FIELD_NAME = "fieldName";
    public static final String BY_FIELD_NAME = "byFieldName";
    public static final String OVER_FIELD_NAME = "overFieldName";
    public static final String PARTITION_FIELD_NAME = "partitionFieldName";
    public static final String USE_NULL = "useNull";
    public static final String EXCLUDE_FREQUENT = "excludeFrequent";


    public static final String COUNT = "count";
    public static final String HIGH_COUNT = "high_count";
    public static final String LOW_COUNT = "low_count";
    public static final String NON_ZERO_COUNT = "non_zero_count";
    public static final String LOW_NON_ZERO_COUNT = "low_non_zero_count";
    public static final String HIGH_NON_ZERO_COUNT = "high_non_zero_count";
    public static final String NZC = "nzc";
    public static final String LOW_NZC = "low_nzc";
    public static final String HIGH_NZC = "high_nzc";
    public static final String DISTINCT_COUNT = "distinct_count";
    public static final String DC = "dc";
    public static final String RARE = "rare";
    public static final String FREQ_RARE = "freq_rare";
    public static final String INFO_CONTENT = "info_content";
    public static final String LOW_INFO_CONTENT = "low_info_content";
    public static final String HIGH_INFO_CONTENT = "high_info_content";
    public static final String METRIC = "metric";
    public static final String MEAN = "mean";
    public static final String HIGH_MEAN = "high_mean";
    public static final String LOW_MEAN = "low_mean";
    public static final String AVG = "avg";
    public static final String HIGH_AVG = "high_avg";
    public static final String LOW_AVG = "low_avg";
    public static final String MIN = "min";
    public static final String MAX = "max";
    public static final String SUM = "sum";
    public static final String LOW_SUM = "low_sum";
    public static final String HIGH_SUM = "high_sum";
    public static final String NON_NULL_SUM = "non_null_sum";
    public static final String LOW_NON_NULL_SUM = "low_non_null_sum";
    public static final String HIGH_NON_NULL_SUM = "high_non_null_sum";

    /**
     * The set of valid function names.
     */
    public static final Set<String> ANALYSIS_FUNCTIONS =
            new HashSet<String>(Arrays.<String>asList(new String [] {
                COUNT,
                HIGH_COUNT,
                LOW_COUNT,
                NON_ZERO_COUNT, NZC,
                LOW_NON_ZERO_COUNT, LOW_NZC,
                HIGH_NON_ZERO_COUNT, HIGH_NZC,
                DISTINCT_COUNT, DC,
                RARE,
                FREQ_RARE,
                INFO_CONTENT,
                LOW_INFO_CONTENT,
                HIGH_INFO_CONTENT,
                METRIC,
                MEAN, AVG,
                HIGH_MEAN, HIGH_AVG,
                LOW_MEAN, LOW_AVG,
                MIN,
                MAX,
                SUM,
                LOW_SUM,
                HIGH_SUM,
                NON_NULL_SUM,
                LOW_NON_NULL_SUM,
                HIGH_NON_NULL_SUM
            }));

    /**
     * The set of functions that do not require a field, by field or over field
     */
    public static final Set<String> COUNT_WITHOUT_FIELD_FUNCTIONS =
            new HashSet<String>(Arrays.<String>asList(new String [] {
                COUNT,
                HIGH_COUNT,
                LOW_COUNT,
                NON_ZERO_COUNT, NZC,
                LOW_NON_ZERO_COUNT, LOW_NZC,
                HIGH_NON_ZERO_COUNT, HIGH_NZC
            }));

    /**
     * The set of functions that require a fieldname
     */
    public static final Set<String> FIELD_NAME_FUNCTIONS =
            new HashSet<String>(Arrays.<String>asList(new String [] {
                DISTINCT_COUNT, DC,
                INFO_CONTENT,
                LOW_INFO_CONTENT,
                HIGH_INFO_CONTENT,
                METRIC,
                MEAN, AVG,
                HIGH_MEAN, HIGH_AVG,
                LOW_MEAN, LOW_AVG,
                MIN,
                MAX,
                SUM,
                LOW_SUM,
                HIGH_SUM,
                NON_NULL_SUM,
                LOW_NON_NULL_SUM,
                HIGH_NON_NULL_SUM
            }));

    /**
     * The set of functions that require a by fieldname
     */
    public static final Set<String> BY_FIELD_NAME_FUNCTIONS =
            new HashSet<String>(Arrays.<String>asList(new String [] {
                RARE,
                FREQ_RARE
            }));

    /**
     * The set of functions that require a over fieldname
     */
    public static final Set<String> OVER_FIELD_NAME_FUNCTIONS =
            new HashSet<String>(Arrays.<String>asList(new String [] {
                DISTINCT_COUNT, DC,
                FREQ_RARE,
                INFO_CONTENT,
                LOW_INFO_CONTENT,
                HIGH_INFO_CONTENT
            }));

    /**
     * The set of functions that cannot have an by fieldname
     */
    public static final Set<String> NO_BY_FIELD_NAME_FUNCTIONS =
            new HashSet<String>(Arrays.<String>asList(new String [] {
                DISTINCT_COUNT, DC,
                INFO_CONTENT,
                LOW_INFO_CONTENT,
                HIGH_INFO_CONTENT
            }));

    /**
     * The set of functions that cannot have an over fieldname
     */
    public static final Set<String> NO_OVER_FIELD_NAME_FUNCTIONS =
            new HashSet<String>(Arrays.<String>asList(new String [] {
                NON_ZERO_COUNT, NZC,
                LOW_NON_ZERO_COUNT, LOW_NZC,
                HIGH_NON_ZERO_COUNT, HIGH_NZC
            }));


    /**
     * field names cannot contain any of these characters
     *     [, ], (, ), =, ", \, -
     */
    public static final String PROHIBITED = "[, ], (, ), =, \", \\, -";
    public static final Character [] PROHIBITED_FIELDNAME_CHARACTERS =
        {'[', ']', '(', ')', '=', '"', '\\', '-'};


    private String m_Function;
    private String m_FieldName;
    private String m_ByFieldName;
    private String m_OverFieldName;
    private String m_PartitionFieldName;
    private Boolean m_UseNull;
    private String m_ExcludeFrequent;

    public Detector()
    {

    }

    /**
     * The analysis function used e.g. count, rare, min etc. There is no
     * validation to check this value is one a predefined set
     * @return The function or <code>null</code> if not set
     */
    public String getFunction()
    {
        return m_Function;
    }

    public void setFunction(String function)
    {
        this.m_Function = function;
    }

    /**
     * The Analysis field
     * @return The field to analyse
     */
    public String getFieldName()
    {
        return m_FieldName;
    }

    public void setFieldName(String fieldName)
    {
        this.m_FieldName = fieldName;
    }

    /**
     * The 'by' field or <code>null</code> if not set.
     * @return The 'by' field
     */
    public String getByFieldName()
    {
        return m_ByFieldName;
    }

    public void setByFieldName(String byFieldName)
    {
        this.m_ByFieldName = byFieldName;
    }

    /**
     * The 'over' field or <code>null</code> if not set.
     * @return The 'over' field
     */
    public String getOverFieldName()
    {
        return m_OverFieldName;
    }

    public void setOverFieldName(String overFieldName)
    {
        this.m_OverFieldName = overFieldName;
    }

    /**
     * Segments the analysis along another field to have completely
     * independent baselines for each instance of partitionfield
     *
     * @return The Partition Field
     */
    public String getPartitionFieldName()
    {
        return m_PartitionFieldName;
    }

    public void setPartitionFieldName(String partitionFieldName)
    {
        this.m_PartitionFieldName = partitionFieldName;
    }


    /**
     * Where there isn't a value for the 'by' or 'over' field should a new
     * series be used as the 'null' series.
     * @return true if the 'null' series should be created
     */
    public Boolean isUseNull()
    {
        return m_UseNull;
    }

    public void setUseNull(Boolean useNull)
    {
        this.m_UseNull = useNull;
    }

    /**
     * Excludes frequently-occuring metrics from the analysis;
     * can apply to 'by' field, 'over' field, or both
     * It will be validated by the C++ process
     *
     * @return the value that the user set
     */
    public String getExcludeFrequent()
    {
        return m_ExcludeFrequent;
    }

    public void setExcludeFrequent(String v)
    {
        m_ExcludeFrequent = v;
    }


    @Override
    public boolean equals(Object other)
    {
        if (this == other)
        {
            return true;
        }

        if (other instanceof Detector == false)
        {
            return false;
        }

        Detector that = (Detector)other;

        return Objects.equals(this.m_Function, that.m_Function) &&
               Objects.equals(this.m_FieldName, that.m_FieldName) &&
               Objects.equals(this.m_ByFieldName, that.m_ByFieldName) &&
               Objects.equals(this.m_OverFieldName, that.m_OverFieldName) &&
               Objects.equals(this.m_PartitionFieldName, that.m_PartitionFieldName) &&
               Objects.equals(this.m_UseNull, that.m_UseNull) &&
               Objects.equals(this.m_ExcludeFrequent, that.m_ExcludeFrequent);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(m_Function, m_FieldName, m_ByFieldName,
                m_OverFieldName, m_PartitionFieldName, m_UseNull, m_ExcludeFrequent);
    }
}
