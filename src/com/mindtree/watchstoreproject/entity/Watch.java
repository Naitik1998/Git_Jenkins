package com.mindtree.watchstoreproject.entity;

public class Watch {

	private int watchId;
	private long modelNumber;
	private double price;

	public Watch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Watch(int watchId, long modelNumber, double price) {
		super();
		this.watchId = watchId;
		this.modelNumber = modelNumber;
		this.price = price;
	}

	public int getWatchId() {
		return watchId;
	}

	public void setWatchId(int watchId) {
		this.watchId = watchId;
	}

	public long getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(long modelNumber) {
		this.modelNumber = modelNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (modelNumber ^ (modelNumber >>> 32));
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + watchId;
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
		Watch other = (Watch) obj;
		if (modelNumber != other.modelNumber)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (watchId != other.watchId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Watch [watchId=" + watchId + ", modelNumber=" + modelNumber + ", price=" + price + "]";
	}

}
