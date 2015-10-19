package org.akc.assembler.impl;

import org.akc.assembler.SuperintendentAssembler;
import org.akc.dao.SuperintendentDao;
import org.akc.dao.model.Superintendent;
import org.akc.exception.InvalidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Author: Chander
 * Date: 09/08/15
 * SuperintendentAssemblerImpl Class for save the Superintendent related data and finding the data 
 * by passing Id value.
 */


@Service("superintendentAssembler")
public class SuperintendentAssemblerImpl implements SuperintendentAssembler {

	/** The Constant logger. */
	final static Logger logger = LoggerFactory
			.getLogger(SuperintendentAssemblerImpl.class);

	/** The superintendent dao. */
	@Autowired   //@Qualifier
	SuperintendentDao superintendentDao;

	/**
	 * getSuperintendent method will get the Superintendent based on
	 * SuperintendentId, SuperintendentName properties
	 *
	 * @param Superintendent
	 * @return Superintendent
	 * @exception InvalidException
	 */
	
	
	public Superintendent findByIdAndName(long superintendentId, String superintendentName)
			throws InvalidException {

		if (logger.isDebugEnabled()) {

			/*logger.info("entered findByIdAndName of SuperintendentAssemblerImpl"
					+ superintendent);*/
		}

		Superintendent superintendentinfo = superintendentDao.findByIdAndName(superintendentId,superintendentName);
		return superintendentinfo;
	}

	/**
	 * save Superintendent details by passing the  save method
	 *
	 * @param Superintendent
	 * @return Superintendent
	 * @exception InvalidException
	 */
	
	@Override
	public Superintendent save(Superintendent superintendent)
			throws InvalidException {

		logger.info("save the Superintendent details" + superintendent);

		return superintendentDao.save(superintendent);
	}

}
