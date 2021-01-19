package org.boudet.spring.integration.sample.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "METRICS")
public class Metric implements Serializable {
    
	@Column(name = "DATETIME")
	public Timestamp datetime;
    
    @Column(name = "VALUE")
    public int value;
    
    @Column(name = "TYPE")
    public String type;
    
    @Id
	@Column(name = "METRIC_OFFSET", nullable = false)
    public int metric_offset;
           
     

	public Metric() {
		super();
	}


	public Metric(Timestamp datetime, int value, String type, int metric_offset) {		
		super();
		this.datetime = datetime;
		this.value = value;
		this.type = type;
		this.metric_offset = metric_offset;
	}



	

	public int getMetric_offset() {
		return metric_offset;
	}



	public void setMetric_offset(int metric_offset) {
		this.metric_offset = metric_offset;
	}



	public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Metric{" +
                "datetime=" + datetime +
                ", value=" + value +
                ", type='" + type + '\'' +
                '}';
    }
}
