package com.zhiyou100.io.poc;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Record implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7461928889082594527L;
	
	/**
	 * 操作时间
	 */
	private long operateTime;
	
	/**
	 * 源文件名
	 */
	private String srcName;
	
	/**
	 * 目标文件名
	 */
	private String destName;
	
	
	private transient String ip;

	/**
	 * 
	 */
	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(long operateTime) {
		this.operateTime = operateTime;
	}

	public String getSrcName() {
		return srcName;
	}

	public void setSrcName(String srcName) {
		this.srcName = srcName;
	}

	public String getDestName() {
		return destName;
	}

	public void setDestName(String destName) {
		this.destName = destName;
	}

	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "Record [operateTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS").format(new Date(operateTime)) + ", srcName=" + srcName +", ip=" + ip + ", destName=" + destName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destName == null) ? 0 : destName.hashCode());
		result = prime * result + (int) (operateTime ^ (operateTime >>> 32));
		result = prime * result + ((srcName == null) ? 0 : srcName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Record other = (Record) obj;
		if (destName == null) {
			if (other.destName != null)
				return false;
		} else if (!destName.equals(other.destName))
			return false;
		if (operateTime != other.operateTime)
			return false;
		if (srcName == null) {
			if (other.srcName != null)
				return false;
		} else if (!srcName.equals(other.srcName))
			return false;
		return true;
	}
}
