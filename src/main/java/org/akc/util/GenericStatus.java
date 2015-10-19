/*
  Author: chandra
  Date: 29/09/15
  EventGenericStatus defined for maintaining the generic statuses
 */
package org.akc.util;

import java.util.Map;

/*
  The Class EventGenericStatus.
 */
public class GenericStatus {
   
   /* The event status map. */
   /*eventStatusMap defined for maintaining the event statuses */
	private Map<Object, Object> eventStatusMap;
	private Map<Object, Object> prefixMap;
	private Map<Object, Object> suffixMap;
   /* The judge panel status map. */
   /*eventStatusMap defined for maintaining the Judge Panel statuses */	
	private Map<Object, Object> judgePanelStatusMap;
	
	/* The time zones map. */
	private Map<String, String> timeZonesMap;
	
	/* The event setting map. */
	private Map<String, String> eventSettingMap;
	
    /*
	  Gets the event status map.
	 
	  @return the event status map
	 */
	public Map<Object, Object> getEventStatusMap() {
		return eventStatusMap;
	}

	/*
	  Sets the event status map.
	 
	  @param eventStatusMap the event status map
	 */
	public void setEventStatusMap(Map<Object, Object> eventStatusMap) {
		this.eventStatusMap = eventStatusMap;
	}

	/*
	  Gets the judge panel status map.
	 
	  @return the judge panel status map
	 */
	public Map<Object, Object> getJudgePanelStatusMap() {
		return judgePanelStatusMap;
	}

	/*
	  Sets the judge panel status map.
	 
	  @param judgePanelStatusMap the judge panel status map
	 */
	public void setJudgePanelStatusMap(Map<Object, Object> judgePanelStatusMap) {
		this.judgePanelStatusMap = judgePanelStatusMap;
	}

	/*
	  Gets the time zones map.
	 
	  @return the time zones map
	 */
	public Map<String, String> getTimeZonesMap() {
		return timeZonesMap;
	}

	/*
	 Sets the time zones map.
	 
	 @param timeZonesMap the time zones map
	 */
	public void setTimeZonesMap(Map<String, String> timeZonesMap) {
		this.timeZonesMap = timeZonesMap;
	}

	/*
	  Gets the event setting map.
	 
	  @return the event setting map
	 */
	public Map<String, String> getEventSettingMap() {
		return eventSettingMap;
	}

	/*
	  Sets the event setting map.
	 
	  @param eventSettingMap the event setting map
	 */
	public void setEventSettingMap(Map<String, String> eventSettingMap) {
		this.eventSettingMap = eventSettingMap;
	}

	public Map<Object, Object> getPrefixMap() {
		return prefixMap;
	}

	public void setPrefixMap(Map<Object, Object> prefixMap) {
		this.prefixMap = prefixMap;
	}

	public Map<Object, Object> getSuffixMap() {
		return suffixMap;
	}

	public void setSuffixMap(Map<Object, Object> suffixMap) {
		this.suffixMap = suffixMap;
	}



}
