package com.zhiyou100.thread.procon2;

public class Apple {
	private int id;

	/**
	 * @param id
	 */
	public Apple(int id) {
		this.id = id;
	}

	/**
	 * 
	 */
	public Apple() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Apple [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Apple other = (Apple) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
