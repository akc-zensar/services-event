package org.akc.dao;


import org.akc.dao.model.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Author: Chander
 * Date: 09/08/15
 * AddressDao interface for querying CRUD operations on Address table.
 */

public interface AddressDao extends CrudRepository<Address,Long> {
	
	
	/** The Constant FIND_BY_ID_AND_NAME_QUERY is used to get address details */
	
	public final static String FIND_BY_ID_QUERY = "SELECT a " + 
            "FROM Address a " +
            "WHERE a.addressId = :addressId";
	 
	/**
	 * method findByAddressId will get Address
	 * details based on addressId
	 *
	 * @param addressId
	 *
	 * @return address object
	 */
 	@Query(FIND_BY_ID_QUERY)
	 Address findByAddressId(@Param("addressId") int addressId);
	
	
	
}
