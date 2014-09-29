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

package com.prelert.rs.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Anomaly Record POJO.
 * Uses the object wrappers Boolean and Double so <code>null</code> values
 * can be returned if the members have not been set.
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties({"parent", "id", "detectorName"})
public class AnomalyRecord
{
	/**
	 * Serialisation fields
	 */
	static final public String TYPE = "record";

	/**
	 * Data store ID field
	 */
	static final public String ID = "id";

	/**
	 * Result fields (all detector types)
	 */
	static final public String PROBABILITY = "probability";
	static final public String BY_FIELD_NAME = "byFieldName";
	static final public String BY_FIELD_VALUE = "byFieldValue";
	static final public String PARTITION_FIELD_NAME = "partitionFieldName";
	static final public String PARTITION_FIELD_VALUE = "partitionFieldValue";
	static final public String FUNCTION = "function";
	static final public String TYPICAL = "typical";
	static final public String ACTUAL = "actual";
	
	/**
	 * Metric Results (including population metrics)
	 */
	static final public String FIELD_NAME = "fieldName";

	/**
	 * Population results
	 */
	static final public String OVER_FIELD_NAME = "overFieldName";
	static final public String OVER_FIELD_VALUE = "overFieldValue";
	static final public String CAUSES = "causes";

	/**
	 * Normalisation
	 */
	static final public String ANOMALY_SCORE = "anomalyScore";
	static final public String NORMALIZED_PROBABILITY = "normalizedProbability";
	
	
	private String m_Id;
	private double m_Probability;
	private String m_ByFieldName;
	private String m_ByFieldValue;
	private String m_PartitionFieldName;
	private String m_PartitionFieldValue;
	private String m_Function;
	private Double m_Typical;
	private Double m_Actual;

	private String m_FieldName;

	private String m_OverFieldName;
	private String m_OverFieldValue;
	private List<AnomalyCause> m_Causes;

	private double m_AnomalyScore;
	private double m_NormalizedProbability;
	private Date   m_Timestamp;

	private String m_Parent;

	/**
	 * Data store ID of this record.  May be null for records that have not been
	 * read from the data store.
	 */
	public String getId()
	{
		return m_Id;
	}

	/**
	 * This should only be called by code that's reading records from the data
	 * store.  The ID must be set to the data stores's unique key to this
	 * anomaly record.
	 */
	public void setId(String id)
	{
		m_Id = id;
	}


	public double getAnomalyScore()
	{
		return m_AnomalyScore;
	}
	
	public void setAnomalyScore(double anomalyScore)
	{
		m_AnomalyScore = anomalyScore;
	}
	
	public double getNormalizedProbability()
	{
		return m_NormalizedProbability;
	}
	
	public void setNormalizedProbability(double normalizedProbability)
	{
		m_NormalizedProbability = normalizedProbability;
	}
	
	
	public Date getTimestamp() 
	{
		return m_Timestamp;
	}
	
	public void setTimestamp(Date timestamp) 
	{
		m_Timestamp = timestamp;
	}
	
	public double getProbability()
	{
		return m_Probability;
	}

	public void setProbability(double value)
	{
		m_Probability = value;
	}


	public String getByFieldName()
	{
		return m_ByFieldName;
	}

	public void setByFieldName(String value)
	{
		m_ByFieldName = value;
	}

	public String getByFieldValue()
	{
		return m_ByFieldValue;
	}

	public void setByFieldValue(String value)
	{
		m_ByFieldValue = value;
	}

	public String getPartitionFieldName()
	{
		return m_PartitionFieldName;
	}

	public void setPartitionFieldName(String field)
	{
		m_PartitionFieldName = field;
	}

	public String getPartitionFieldValue()
	{
		return m_PartitionFieldValue;
	}

	public void setPartitionFieldValue(String value)
	{
		m_PartitionFieldValue = value;
	}

	public String getFunction()
	{
		return m_Function;
	}

	public void setFunction(String name)
	{
		m_Function = name;
	}

	public Double getTypical()
	{
		return m_Typical;
	}

	public void setTypical(Double typical)
	{
		m_Typical = typical;
	}

	public Double getActual()
	{
		return m_Actual;
	}

	public void setActual(Double actual)
	{
		m_Actual = actual;
	}

	public String getFieldName()
	{
		return m_FieldName;
	}

	public void setFieldName(String field)
	{
		m_FieldName = field;
	}

	public String getOverFieldName()
	{
		return m_OverFieldName;
	}

	public void setOverFieldName(String name)
	{
		m_OverFieldName = name;
	}

	public String getOverFieldValue()
	{
		return m_OverFieldValue;
	}

	public void setOverFieldValue(String value)
	{
		m_OverFieldValue = value;
	}

	public List<AnomalyCause> getCauses()
	{
		return m_Causes;
	}

	public void setCauses(List<AnomalyCause> causes)
	{
		m_Causes = causes;
	}

	public void addCause(AnomalyCause cause)
	{
		if (m_Causes == null)
		{
			m_Causes = new ArrayList<>();
		}
		m_Causes.add(cause);
	}

	public String getParent()
	{
		return m_Parent;
	}
	
	public void setParent(String parent)
	{
		m_Parent = parent;
	}	

	
	private boolean bothNullOrEqual(Object o1, Object o2)
	{
		if (o1 == null && o2 == null)
		{
			return true;
		}
		
		if (o1 == null || o2 == null)
		{
			return false;
		}
		
		return o1.equals(o2);	
	}

	@Override
	public int hashCode()
	{
		// ID is NOT included in the hash, so that a record from the data store
		// will hash the same as a record representing the same anomaly that did
		// not come from the data store

		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(m_Probability);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(m_AnomalyScore);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(m_NormalizedProbability);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((m_Actual == null) ? 0 : m_Actual.hashCode());
		result = prime * result
				+ ((m_ByFieldName == null) ? 0 : m_ByFieldName.hashCode());
		result = prime * result
				+ ((m_ByFieldValue == null) ? 0 : m_ByFieldValue.hashCode());
		result = prime * result
				+ ((m_FieldName == null) ? 0 : m_FieldName.hashCode());
		result = prime * result
				+ ((m_Function == null) ? 0 : m_Function.hashCode());
		result = prime * result
				+ ((m_OverFieldName == null) ? 0 : m_OverFieldName.hashCode());
		result = prime
				* result
				+ ((m_OverFieldValue == null) ? 0 : m_OverFieldValue.hashCode());
		result = prime * result
				+ ((m_Causes == null) ? 0 : m_Causes.hashCode());
		result = prime * result
				+ ((m_Parent == null) ? 0 : m_Parent.hashCode());
		result = prime
				* result
				+ ((m_PartitionFieldName == null) ? 0 : m_PartitionFieldName
						.hashCode());
		result = prime
				* result
				+ ((m_PartitionFieldValue == null) ? 0 : m_PartitionFieldValue
						.hashCode());
		result = prime * result
				+ ((m_Timestamp == null) ? 0 : m_Timestamp.hashCode());
		result = prime * result
				+ ((m_Typical == null) ? 0 : m_Typical.hashCode());

		return result;
	}

	
	@Override 
	public boolean equals(Object other)
	{
		if (this == other)
		{
			return true;
		}
		
		if (other instanceof AnomalyRecord == false)
		{
			return false;
		}
		
		AnomalyRecord that = (AnomalyRecord)other;

		// ID is NOT compared, so that a record from the data store will compare
		// equal to a record representing the same anomaly that did not come
		// from the data store

		boolean equal = this.m_Probability == that.m_Probability &&
				this.m_AnomalyScore == that.m_AnomalyScore &&
				this.m_NormalizedProbability == that.m_NormalizedProbability &&
				bothNullOrEqual(this.m_Typical, that.m_Typical) &&
				bothNullOrEqual(this.m_Actual, that.m_Actual) &&
				bothNullOrEqual(this.m_Function, that.m_Function) &&
				bothNullOrEqual(this.m_FieldName, that.m_FieldName) &&
				bothNullOrEqual(this.m_ByFieldName, that.m_ByFieldName) &&
				bothNullOrEqual(this.m_ByFieldValue, that.m_ByFieldValue) &&
				bothNullOrEqual(this.m_PartitionFieldName, that.m_PartitionFieldName) &&
				bothNullOrEqual(this.m_PartitionFieldValue, that.m_PartitionFieldValue) &&
				bothNullOrEqual(this.m_OverFieldName, that.m_OverFieldName) &&
				bothNullOrEqual(this.m_OverFieldValue, that.m_OverFieldValue) &&
				bothNullOrEqual(this.m_Timestamp, that.m_Timestamp) &&
				bothNullOrEqual(this.m_Parent, that.m_Parent);

		if (this.m_Causes == null && that.m_Causes == null)
		{
			equal &= true;
		}
		else if (this.m_Causes != null && that.m_Causes != null)
		{
			equal &= this.m_Causes.size() == that.m_Causes.size();
			if (equal)
			{
				for (int i=0; i<this.m_Causes.size(); i++)
				{
					equal &= this.m_Causes.get(i).equals(that.m_Causes.get(i));
				}
			}
		}
		else
		{
			// one null the other not
			equal = false;
		}

		return equal;
	}

}
