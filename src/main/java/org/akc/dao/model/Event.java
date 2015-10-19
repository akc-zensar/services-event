package org.akc.dao.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.akc.transformer.DtoTransformer;
import org.hibernate.annotations.ForeignKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
/**
 * Author: chandra
 * Date: 09/08/15
 * Event Model defined for event service
 */
@Entity
@Table(name ="EVENT")
public class Event implements Serializable,DtoTransformer {
	private static final long serialVersionUID = 1L;
	final static Logger logger = LoggerFactory.getLogger(Event.class);
	@Id
	@GeneratedValue
	@Column(name = "EVENT_ID")
	private int eventId;
	//@Column(name = "SITE_ID")
	//private Long siteId;
	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="SITE_ID")
	private Site site;
	@OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="EVENT_ID")
	private Set<Competition> competitionSet = new HashSet<Competition>();
	@NotNull
	@Column(name = "EVENT_NUMBER")
	private Long eventNumber;
	@Column(name = "EVENT_NAME")
	private String eventName;
	@Column(name = "COMPETITION_TYPE_CODE")
	private String competitionCode;
	@Column(name = "START_DATE")
	private Date startDate;
	@Column(name = "END_DATE")
	private Date endDate;
	@Column(name = "EVENT_STATUS")
	private int eventStatus;
	@Column(name = "JUDGE_PANEL_STATUS")
	private int judgePanelStatus;
	@Column(name = "CORRELATED_EVENT")
//	private int stateId;
//	@Column(name = "STATE_ID")
	private String correlatedEvent;
	@Column(name = "CORRELATED_EVENT_ID")
	private Long correlatedEventId;
	@Column(name = "ENTRY_LIMIT_TYPE")
	private String entrylimitType;
	@Column(name = "ENTRY_LIMIT")
	private String entryLimit;
	@Column(name = "ENTRY_COUNT")
	private String entryCount;
	@Column(name = "COMPETITOR_COUNT")
	private String competitorCount;
	@Column(name = "SPECIAL_EVENT_TYPE")
	private String specialEventType;
	@Column(name = "DISASTER_PLAN")
	private String disasterPlan;
	@Column(name = "SITE_CHANGED")
	private Date siteChanged;
	@Column(name = "UPDATED_BY")
	private String updatedBy;
	@Column(name = "CREATED_BY")
	private String createdBy;
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;
	@Column(name = "CLUB_ID")
	private Long clubId;
	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="COMMITTEE_ID")
	private Committee committee;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "STATE_ID")
	private State state;

//    public Long getSiteId() {
//		return siteId;
//	}
	
//
//	public void setSiteId(Long siteId) {
//		this.siteId = siteId;
//	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}



	public Long getEventNumber() {
		return eventNumber;
	}
    

	public String getDisasterPlan() {
		return disasterPlan;
	}

	public void setDisasterPlan(String disasterPlan) {
		this.disasterPlan = disasterPlan;
	}

	public Date getSiteChanged() {
		return siteChanged;
	}

	public void setSiteChanged(Date siteChanged) {
		this.siteChanged = siteChanged;
	}


	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public void setEventNumber(Long eventNumber) {
		this.eventNumber = eventNumber;
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

   


	public String getCompetitionCode() {
		return competitionCode;
	}

	public void setCompetitionCode(String competitionCode) {
		this.competitionCode = competitionCode;
	}

	public Long getCorrelatedEventId() {
		return correlatedEventId;
	}

	public void setCorrelatedEventId(Long correlatedEventId) {
		this.correlatedEventId = correlatedEventId;
	}

	public String getEntrylimitType() {
		return entrylimitType;
	}

	public void setEntrylimitType(String entrylimitType) {
		this.entrylimitType = entrylimitType;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

	public Set<Competition> getCompetitionSet() {
		return competitionSet;
	}

	public void setCompetitionSet(Set<Competition> competitionSet) {
		this.competitionSet = competitionSet;
	}

	public Committee getCommittee() {
		return committee;
	}

	public void setCommittee(Committee committee) {
		this.committee = committee;
	}

	public int getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(int eventStatus) {
		this.eventStatus = eventStatus;
	}

	public int getJudgePanelStatus() {
		return judgePanelStatus;
	}

	public void setJudgePanelStatus(int judgePanelStatus) {
		this.judgePanelStatus = judgePanelStatus;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}



//	public int getStateId() {
//		return stateId;
//	}
//
//	public void setStateId(int stateId) {
//		this.stateId = stateId;
//	}





}
