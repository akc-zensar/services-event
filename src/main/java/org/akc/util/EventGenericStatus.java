/**
 * Author: chandra
 * Date: 29/09/15
 * EventGenericStatus defined for maintaining the generic statuses
 */
package org.akc.util;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class EventGenericStatus {
   /*eventStatusMap defined for maintaining the event statuses */
	private Map<Object, Object> eventStatusMap;
   /*eventStatusMap defined for maintaining the Judge Panel statuses */	
	private Map<Object, Object> judgePanelStatusMap;

	public Map<Object, Object> getEventStatusMap() {
		return eventStatusMap;
	}

	public void setEventStatusMap(Map<Object, Object> eventStatusMap) {
		this.eventStatusMap = eventStatusMap;
	}

	public Map<Object, Object> getJudgePanelStatusMap() {
		return judgePanelStatusMap;
	}

	public void setJudgePanelStatusMap(Map<Object, Object> judgePanelStatusMap) {
		this.judgePanelStatusMap = judgePanelStatusMap;
	}

}
