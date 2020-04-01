package com.mindtree.watchstoreproject.service.serviceimplementation;



import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.mindtree.watchstoreproject.dao.StoreProjectDao;
import com.mindtree.watchstoreproject.dao.daoimplementation.StoreProjectDaoImplementation;
import com.mindtree.watchstoreproject.entity.Type;
import com.mindtree.watchstoreproject.entity.Watch;
import com.mindtree.watchstoreproject.exception.service.WatchStoreProjectServiceException;
import com.mindtree.watchstoreproject.exception.service.custom.TypeIdAlreadyExistsException;
import com.mindtree.watchstoreproject.exception.service.custom.TypeNotFoundException;
import com.mindtree.watchstoreproject.exception.service.custom.WatchIsAlreadyExistsException;
import com.mindtree.watchstoreproject.service.StoreProjectService;



public class StoreProjectServiceImplementation implements StoreProjectService {

	StoreProjectDao storeDaoObj= new StoreProjectDaoImplementation(); 
	
	List<Type> typeList = new LinkedList<Type>();

	@Override
	public String addType(Type type) throws WatchStoreProjectServiceException  {
		
		
		

		for (Type type1 : typeList) {
			if (type1.getTypeId() == type.getTypeId()) {
				throw new TypeIdAlreadyExistsException("Type is already Exists !!!");
			}
		}

		typeList.add(type);
		return "Type Added Successfully !!!";

	}

	@Override
	public String addWatch(int typeid1, Watch watch) throws WatchStoreProjectServiceException {

		List<Watch> watchsList = new LinkedList<Watch>();

		for (Type type2 : typeList) {
			if (type2.getTypeId() == typeid1) {

				if (type2.getWatchList() == null) {
					watchsList.add(watch);
				} else {

					watchsList = type2.getWatchList();

					for (Watch watch2 : watchsList) {

						if (watch2.getWatchId() == watch.getWatchId()) {
							throw new WatchIsAlreadyExistsException("Watch Is Already Exits !!!");
						}

					}
					watchsList.add(watch);
				}

				type2.setWatchList(watchsList);
				return "Watch Added to the type Sucessfully !!!";
			}

		}

		throw new TypeNotFoundException("Type Not Found !!!");
	}

	@Override
	public String deleteType(int typeIdDelete) throws WatchStoreProjectServiceException {
		for (Type type3 : typeList) {
			if (type3.getTypeId() == typeIdDelete) {

				typeList.remove(type3);
				return "Type with id " + typeIdDelete + " is Deleted Successfully !!!";
			}

		}

		throw new TypeNotFoundException("Type Not Found !!!");

	}

	@Override
	public List<Type> sortAllWatches() {

		for (Type type : typeList) {
			List<Watch> wList = type.getWatchList();
			Collections.sort(wList, new Comparator<Watch>() {

				@Override
				public int compare(Watch w1, Watch w2) {

					return Double.compare(w1.getPrice(), w2.getPrice());
				}
			});
		}
		return typeList;

	}

	

}
