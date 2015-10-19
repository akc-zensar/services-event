package org.akc.transformer;

import java.util.HashSet;
import java.util.Set;

import org.akc.exception.EmsGenericException;
import org.akc.util.LoggerHelper;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

/*
  @author Ashok Doddi
  DtoTransformerImpl is Generic class responsible to transform FormBean to ModelBean and vice versa.
 */
@Component
public class DtoTransformerImpl<T extends DtoTransformer> {
	private static final  Logger LOGGER = LoggerFactory.getLogger(DtoTransformerImpl.class);
	
	private DozerBeanMapper mapper = new DozerBeanMapper();

	/*
	  method copyObjectDestination2Source is Generic method 
	  @param generic Bean's which implements DtoTransformer Interface.
	 
	  @param generic Bean which implements DtoTransformer Interface.
	  @return generic Bean which implements DtoTransformer Interface.
	 */
	
	public T copyObjectDestination2Source(Class<T> destinationClass, T fromBean)throws EmsGenericException {
		LoggerHelper.debug(LOGGER, " Enter :copyObjectSource2Destination" );
		LoggerHelper.debug(LOGGER, " Source object ",fromBean.toString());
		
		LOGGER.info("enterd eventFormToEvent of EventTransformer");
		T transformedData;
		try {
			
			transformedData = mapper.map(fromBean, destinationClass);
			
		} catch (Exception e) {
			throw new EmsGenericException(e.getMessage());
			
		}
		LoggerHelper.debug(LOGGER, " Destination object :",transformedData.toString() );
		LoggerHelper.debug(LOGGER, " Exit copyObjectDestination2Source ");
		return transformedData;
	}

	/*
	 This method  is Generic method to List out NULL columns from Bean.
	 
	  @param generic Bean which implements DtoTransformer Interface.
	  @return Set of Strings Bean Object.
	 */
	
	public Set<String> getNullPropertyNames(T sourceBean) {
		LOGGER.info("enterd getNullPropertyNames ");
		final BeanWrapper src = new BeanWrapperImpl(sourceBean);
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

		Set<String> emptyNames = new HashSet<String>();
		for (java.beans.PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null){
				emptyNames.add(pd.getName());
			}
		}

		return emptyNames;
	}

	/*
	  method myCopyProperties is Generic method copies all NOTNULL values 
	  from source bean to destination bean.
	 
	  @param generic Bean's which implements DtoTransformer Interface.
	  @return generic Bean which implements DtoTransformer Interface.
	 */
	
	public T myCopyProperties(T sourceBean, T destinationBean) {
		LOGGER.info("enterd myCopyProperties");
		Set<String> newset = getNullPropertyNames(sourceBean);
		BeanUtils.copyProperties(sourceBean, destinationBean, (String[]) newset.toArray(new String[newset.size()]));
		return destinationBean;
	}
	
}
