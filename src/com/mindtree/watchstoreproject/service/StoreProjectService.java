package com.mindtree.watchstoreproject.service;



import java.util.List;

import com.mindtree.watchstoreproject.entity.Type;
import com.mindtree.watchstoreproject.entity.Watch;
import com.mindtree.watchstoreproject.exception.service.WatchStoreProjectServiceException;


public interface StoreProjectService {

	public String addType(Type type) throws WatchStoreProjectServiceException ;

	public String addWatch(int typeid1, Watch watch) throws WatchStoreProjectServiceException ;

	public String deleteType(int typeIdDelete) throws WatchStoreProjectServiceException;

	public List<Type> sortAllWatches(); 

}
