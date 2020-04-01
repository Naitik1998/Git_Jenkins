package com.mindtree.watchstoreproject.client;

import java.util.Scanner;

import com.mindtree.watchstoreproject.entity.Type;
import com.mindtree.watchstoreproject.entity.Watch;
import com.mindtree.watchstoreproject.exception.service.WatchStoreProjectServiceException;
import com.mindtree.watchstoreproject.service.StoreProjectService;
import com.mindtree.watchstoreproject.service.serviceimplementation.StoreProjectServiceImplementation;


public class DriverClass {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		StoreProjectService service = new StoreProjectServiceImplementation();

		boolean flag = true;
		do {
			System.out.println();
			System.out.println("1:	Add Type");
			System.out.println("2:	Add Watch");
			System.out.println("3:	Sort All Watches Based on price.");
			System.out.println("4:	Delete Particular Type and Their Watches");
			System.out.println("5:	Exit");
			System.out.println("Enter the Choice:");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				Type type = new Type();
				System.out.println("Enter the Type ID:");
				int typeid = sc.nextInt();
				System.out.println("Enter the Type Name:");
				sc.nextLine();
				String typename = sc.nextLine();

				type.setTypeId(typeid);
				type.setTypeName(typename);
				type.setWatchList(null);

				String mesaage = null;
				try {
					mesaage = service.addType(type);
					System.out.println(mesaage);
				} catch (WatchStoreProjectServiceException e) {
					System.out.println(e.getMessage());
				}
				

				break;
			case 2:
				System.out.println("Enter Type ID where you want Add Watch");
				int typeid1 = sc.nextInt();

				Watch watch = new Watch();
				System.out.println("Enter the Watch id:");
				int watchid = sc.nextInt();
				System.out.println("Enter the Model Number:");
				long modelNo = sc.nextLong();
				System.out.println("Enter the Watch Price:");
				double priceWatch = sc.nextDouble();

				watch.setWatchId(watchid);
				watch.setModelNumber(modelNo);
				watch.setPrice(priceWatch);

				try {
					System.out.println(service.addWatch(typeid1, watch));
				} catch (WatchStoreProjectServiceException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 3:
				System.out.println("Sorted All Watches in type is: ");
				for (Type types : service.sortAllWatches()) {
					System.out.println(types);
				}

				break;
			case 4:
				System.out.println("Enter the Type id you want to delete:");
				int typeIdDelete = sc.nextInt();
				try {
					System.out.println(service.deleteType(typeIdDelete));
				} catch (WatchStoreProjectServiceException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 5:
				System.out.println("Thank You !!!");
				flag = false;

				break;

			default:
				System.out.println("Invalid Choice Entered !!!");
				break;
			}

		} while (flag);
	}

}
