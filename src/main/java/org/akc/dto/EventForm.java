package org.akc.dto;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.xml.bind.annotation.XmlRootElement;

import org.akc.dao.model.Committee;
import org.akc.dao.model.Competition;
import org.akc.dao.model.Event;
import org.akc.dao.model.Site;
import org.akc.dao.model.State;
import org.akc.transformer.DtoTransformer;
import org.akc.validation.ValidatorInf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Author: chandra
 * Date: 09/08/15 Event DTO defined for event service
 */
@XmlRootElement(name = "EventCompetitionForm")
public class EventForm implements DtoTransformer,ValidatorInf {
	final static Logger logger = LoggerFactory.getLogger(Event.class);
	private int eventId;
	@NotNull
	private Long eventNumber;
	private String eventName;
	private String competitionCode;
	private Date startDate;
	private Date endDate;
	private String eventStatus;
	private String judgePanelStatus;
	private String correlatedEvent;
	private Long correlatedEventId;
	private String entryLimitType;
	private String entryLimit;
	private String entryCount;
	private String competitorCount;
	private String createdBy;
	private String updatedBy;
	private Date createdDate;
	private Date updatedDate;
//	private long siteId;
	private Site site;
	private String specialEventType;
	private String disasterPlan;
	private Date siteChanged;
	private Long clubId;
	private Set<Competition> competition = new HashSet<Competition>();
	private int committeeId;
	private Committee committee;
	private State state;

	public Date getSiteChanged() {
		return siteChanged;
	}

	public void setSiteChanged(Date siteChanged) {
		this.siteChanged = siteChanged;
	}

	public Long getClubId() {
		return clubId;
	}

	public void setClubId(Long clubId) {
		this.clubId = clubId;
	}

	public String getSpecialEventType() {
		return specialEventType;
	}

	public void setSpecialEventType(String specialEventType) {
		this.specialEventType = specialEventType;
	}

	public String getDisasterPlan() {
		return disasterPlan;
	}

	public void setDisasterPlan(String disasterPlan) {
		this.disasterPlan = disasterPlan;
	}

//	public long  getSiteId() {
//		return siteId;
//	}
//
//	public void setSiteId(long siteId) {
//		this.siteId = siteId;
//	}



	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	



	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public Long getEventNumber() {
		return eventNumber;
	}

	public void setEventNumber(Long eventNumber) {
		this.eventNumber = eventNumber;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}



	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}



	public String getCorrelatedEvent() {
		return correlatedEvent;
	}

	public void setCorrelatedEvent(String correlatedEvent) {
		this.correlatedEvent = correlatedEvent;
	}


	public Long getCorrelatedEventId() {
		return correlatedEventId;
	}

	public void setCorrelatedEventId(Long correlatedEventId) {
		this.correlatedEventId = correlatedEventId;
	}

	public String getEntryLimitType() {
		return entryLimitType;
	}

	public void setEntryLimitType(String entryLimitType) {
		this.entryLimitType = entryLimitType;
	}

	public String getEntryLimit() {
		return entryLimit;
	}

	public void setEntryLimit(String entryLimit) {
		this.entryLimit = entryLimit;
	}

	public String getEntryCount() {
		return entryCount;
	}

	public void setEntryCount(String entryCount) {
		this.entryCount = entryCount;
	}

	public String getCompetitorCount() {
		return competitorCount;
	}

	public void setCompetitorCount(String competitorCount) {
		this.competitorCount = competitorCount;
	}

	public String getCompetitionCode() {
		return competitionCode;
	}

	public void setCompetitionCode(String competitionCode) {
		this.competitionCode = competitionCode;
	}


	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Set<Competition> getCompetition() {
		return competition;
	}

	public void setCompetition(Set<Competition> competition) {
		this.competition = competition;
	}

	public int getCommitteeId() {
		return committeeId;
	}

	public void setCommitteeId(int committeeId) {
		this.committeeId = committeeId;
	}

	public Committee getCommittee() {
		return committee;
	}

	public void setCommittee(Committee committee) {
		this.committee = committee;
	}

	public String getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}

	public String getJudgePanelStatus() {
		return judgePanelStatus;
	}

	public void setJudgePanelStatus(String judgePanelStatus) {
		this.judgePanelStatus = judgePanelStatus;
	}



	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}


	
}
