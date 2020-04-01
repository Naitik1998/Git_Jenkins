package com.mindtree.watchstoreproject.entity;

import java.util.List;

public class Type {
	private int typeId;
	private String typeName;
	private List<Watch> watchList;

	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Type(int typeId, String typeName, List<Watch> watchList) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.watchList = watchList;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<Watch> getWatchList() {
		return watchList;
	}

	public void setWatchList(List<Watch> watchList) {
		this.watchList = watchList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + typeId;
		result = prime * result + ((typeName == null) ? 0 : typeName.hashCode());
		result = prime * result + ((watchList == null) ? 0 : watchList.hashCode());
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
		Type other = (Type) obj;
		if (typeId != other.typeId)
			return false;
		if (typeName == null) {
			if (other.typeName != null)
				return false;
		} else if (!typeName.equals(other.typeName))
			return false;
		if (watchList == null) {
			if (other.watchList != null)
				return false;
		} else if (!watchList.equals(other.watchList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", typeName=" + typeName + ", watchList=" + watchList + "]";
	}

}
