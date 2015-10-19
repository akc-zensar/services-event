package org.akc.dto;

import java.sql.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.akc.transformer.DtoTransformer;
import org.akc.validation.ValidatorInf;
import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

// TODO: Auto-generated Javadoc
/**
 * Author: Ashok Doddi.
 */
public class CompetitionForm implements DtoTransformer, ValidatorInf {

	public CompetitionForm() {
		super();

		if (logger.isDebugEnabled()) {
			logger.debug(" Executing Default constructor CompetitionForm dto class ");
		}
	}

	/** The Constant logger. */
	static final Logger logger = Logger.getLogger(CompetitionForm.class);

	/** The competition id. */
	@NotNull
	@Size(min = 4, max = 10)
	@Digits(fraction = 0, integer = 10)
	private Integer competitionId;

	/** The event id. */
	@NotNull
	@Size(min = 4, max = 10)
	@Digits(fraction = 0, integer = 10)
	private Integer eventId;

	/** The competition type code. */
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 4)
	private String competitionTypeCode;

	/** The start date. */
	@DateTimeFormat(pattern = "yy-mm-dd")
	private Date startDate;

	/** The end date. */
	@DateTimeFormat(pattern = "yy-mm-dd")
	private Date endDate;

	/** The event status. */
	private String eventStatus;

	/** The judge panel status. */
	private String judgePanelStatus;

	/** The judging category. */
	private String judgingCategory;

	/** The include mixed breeds. */
	private String includeMixedBreeds;

	/** The special event type. */
	private String specialEventType;

	/** The entry mode. */
	private String entryMode;

	/** The entry limit type. */
	private String entryLimitType;

	/** The entry limit. */
	private String entryLimit;

	/** The entry count. */
	private String entryCount;

	/** The competitor count. */
	private String competitorCount;

	/** The benched unbenched. */
	private String benchedUnbenched;

	/** The event setting. */
	private String eventSetting;

	/** The disaster plan on file. */
	private Boolean disasterPlanOnFile;

	/** The special event type2. */
	private String specialEventType2;

	/** The special event type3. */
	private String specialEventType3;

	/** The entry fee. */
	@Digits(fraction = 2, integer = 4)
	private Integer entryFee;

	/** The created date. */
	private Date panelDueDate;

	/** The competition status. */
	private String competitionStatus;

	/** The entry fee2nd. */
	private Integer entryFee2nd;

	/** The first entry accepted. */
	private Date firstEntryAccepted;

	/** The second entry accepted. */
	private Date lastEntryAccepted;

	/** The time zone. */
	private String timeZone;

	/**
	 * Gets the competition status.
	 *
	 * @return the competition status
	 */
	public String getCompetitionStatus() {
		return competitionStatus;
	}

	/**
	 * Sets the competition status.
	 *
	 * @param competitionStatus
	 *            the new competition status
	 */
	public void setCompetitionStatus(String competitionStatus) {
		this.competitionStatus = competitionStatus;
	}

	/**
	 * Gets the entry fee2nd.
	 *
	 * @return the entry fee2nd
	 */
	public Integer getEntryFee2nd() {
		return entryFee2nd;
	}

	/**
	 * Sets the entry fee2nd.
	 *
	 * @param entryFee2nd
	 *            the new entry fee2nd
	 */
	public void setEntryFee2nd(Integer entryFee2nd) {
		this.entryFee2nd = entryFee2nd;
	}

	/**
	 * Gets the first entry accepted.
	 *
	 * @return the first entry accepted
	 */
	public Date getFirstEntryAccepted() {
		return firstEntryAccepted;
	}

	/**
	 * Sets the first entry accepted.
	 *
	 * @param firstEntryAccepted
	 *            the new first entry accepted
	 */
	public void setFirstEntryAccepted(Date firstEntryAccepted) {
		this.firstEntryAccepted = firstEntryAccepted;
	}

	/**
	 * Gets the last entry accepted.
	 *
	 * @return the last entry accepted
	 */
	public Date getLastEntryAccepted() {
		return lastEntryAccepted;
	}

	/**
	 * Sets the last entry accepted.
	 *
	 * @param lastEntryAccepted
	 *            the new last entry accepted
	 */
	public void setLastEntryAccepted(Date lastEntryAccepted) {
		this.lastEntryAccepted = lastEntryAccepted;
	}

	/**
	 * Gets the time zone.
	 *
	 * @return the time zone
	 */
	public String getTimeZone() {
		return timeZone;
	}

	/**
	 * Sets the time zone.
	 *
	 * @param timeZone
	 *            the new time zone
	 */
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	/**
	 * Gets the logger.
	 *
	 * @return the logger
	 */
	public static Logger getLogger() {
		return logger;
	}

	/**
	 * Gets the competition id.
	 *
	 * @return the competition id
	 */
	public Integer getCompetitionId() {
		return competitionId;
	}

	/**
	 * Sets the competition id.
	 *
	 * @param competitionId
	 *            the new competition id
	 */
	public void setCompetitionId(Integer competitionId) {
		this.competitionId = competitionId;
	}

	/**
	 * Gets the event id.
	 *
	 * @return the event id
	 */
	public Integer getEventId() {
		return eventId;
	}

	/**
	 * Sets the event id.
	 *
	 * @param eventId
	 *            the new event id
	 */
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	/**
	 * Gets the competition type code.
	 *
	 * @return the competition type code
	 */
	public String getCompetitionTypeCode() {
		return competitionTypeCode;
	}

	/**
	 * Sets the competition type code.
	 *
	 * @param competitionTypeCode
	 *            the new competition type code
	 */
	public void setCompetitionTypeCode(@NotNull String competitionTypeCode) {
		this.competitionTypeCode = competitionTypeCode;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate
	 *            the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate
	 *            the new end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the event status.
	 *
	 * @return the event status
	 */
	public String getEventStatus() {
		return eventStatus;
	}

	/**
	 * Sets the event status.
	 *
	 * @param eventStatus
	 *            the new event status
	 */
	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}

	/**
	 * Gets the judge panel status.
	 *
	 * @return the judge panel status
	 */
	public String getJudgePanelStatus() {
		return judgePanelStatus;
	}

	/**
	 * Sets the judge panel status.
	 *
	 * @param judgePanelStatus
	 *            the new judge panel status
	 */
	public void setJudgePanelStatus(String judgePanelStatus) {
		this.judgePanelStatus = judgePanelStatus;
	}

	/**
	 * Gets the judging category.
	 *
	 * @return the judging category
	 */
	public String getJudgingCategory() {
		return judgingCategory;
	}

	/**
	 * Sets the judging category.
	 *
	 * @param judgingCategory
	 *            the new judging category
	 */
	public void setJudgingCategory(String judgingCategory) {
		this.judgingCategory = judgingCategory;
	}

	/**
	 * Gets the include mixed breeds.
	 *
	 * @return the include mixed breeds
	 */
	public String getIncludeMixedBreeds() {
		return includeMixedBreeds;
	}

	/**
	 * Sets the include mixed breeds.
	 *
	 * @param includeMixedBreeds
	 *            the new include mixed breeds
	 */
	public void setIncludeMixedBreeds(String includeMixedBreeds) {
		this.includeMixedBreeds = includeMixedBreeds;
	}

	/**
	 * Gets the special event type.
	 *
	 * @return the special event type
	 */
	public String getSpecialEventType() {
		return specialEventType;
	}

	/**
	 * Sets the special event type.
	 *
	 * @param specialEventType
	 *            the new special event type
	 */
	public void setSpecialEventType(String specialEventType) {
		this.specialEventType = specialEventType;
	}

	/**
	 * Gets the entry mode.
	 *
	 * @return the entry mode
	 */
	public String getEntryMode() {
		return entryMode;
	}

	/**
	 * Sets the entry mode.
	 *
	 * @param entryMode
	 *            the new entry mode
	 */
	public void setEntryMode(String entryMode) {
		this.entryMode = entryMode;
	}

	/**
	 * Gets the entry limit type.
	 *
	 * @return the entry limit type
	 */
	public String getEntryLimitType() {
		return entryLimitType;
	}

	/**
	 * Sets the entry limit type.
	 *
	 * @param entryLimitType
	 *            the new entry limit type
	 */
	public void setEntryLimitType(String entryLimitType) {
		this.entryLimitType = entryLimitType;
	}

	/**
	 * Gets the entry limit.
	 *
	 * @return the entry limit
	 */
	public String getEntryLimit() {
		return entryLimit;
	}

	/**
	 * Sets the entry limit.
	 *
	 * @param entryLimit
	 *            the new entry limit
	 */
	public void setEntryLimit(String entryLimit) {
		this.entryLimit = entryLimit;
	}

	/**
	 * Gets the entry count.
	 *
	 * @return the entry count
	 */
	public String getEntryCount() {
		return entryCount;
	}

	/**
	 * Sets the entry count.
	 *
	 * @param entryCount
	 *            the new entry count
	 */
	public void setEntryCount(String entryCount) {
		this.entryCount = entryCount;
	}

	/**
	 * Gets the competitor count.
	 *
	 * @return the competitor count
	 */
	public String getCompetitorCount() {
		return competitorCount;
	}

	/**
	 * Sets the competitor count.
	 *
	 * @param competitorCount
	 *            the new competitor count
	 */
	public void setCompetitorCount(String competitorCount) {
		this.competitorCount = competitorCount;
	}

	/**
	 * Gets the benched unbenched.
	 *
	 * @return the benched unbenched
	 */
	public String getBenchedUnbenched() {
		return benchedUnbenched;
	}

	/**
	 * Sets the benched unbenched.
	 *
	 * @param benchedUnbenched
	 *            the new benched unbenched
	 */
	public void setBenchedUnbenched(String benchedUnbenched) {
		this.benchedUnbenched = benchedUnbenched;
	}

	/**
	 * Gets the event setting.
	 *
	 * @return the event setting
	 */
	public String getEventSetting() {
		return eventSetting;
	}

	/**
	 * Sets the event setting.
	 *
	 * @param eventSetting
	 *            the new event setting
	 */
	public void setEventSetting(String eventSetting) {
		this.eventSetting = eventSetting;
	}

	/**
	 * Gets the disaster plan on file.
	 *
	 * @return the disaster plan on file
	 */
	public Boolean getDisasterPlanOnFile() {
		return disasterPlanOnFile;
	}

	/**
	 * Sets the disaster plan on file.
	 *
	 * @param disasterPlanOnFile
	 *            the new disaster plan on file
	 */
	public void setDisasterPlanOnFile(Boolean disasterPlanOnFile) {
		this.disasterPlanOnFile = disasterPlanOnFile;
	}

	/**
	 * Gets the special event type2.
	 *
	 * @return the special event type2
	 */
	public String getSpecialEventType2() {
		return specialEventType2;
	}

	/**
	 * Sets the special event type2.
	 *
	 * @param specialEventType2
	 *            the new special event type2
	 */
	public void setSpecialEventType2(String specialEventType2) {
		this.specialEventType2 = specialEventType2;
	}

	/**
	 * Gets the special event type3.
	 *
	 * @return the special event type3
	 */
	public String getSpecialEventType3() {
		return specialEventType3;
	}

	/**
	 * Sets the special event type3.
	 *
	 * @param specialEventType3
	 *            the new special event type3
	 */
	public void setSpecialEventType3(String specialEventType3) {
		this.specialEventType3 = specialEventType3;
	}

	/**
	 * Gets the entry fee.
	 *
	 * @return the entry fee
	 */
	public Integer getEntryFee() {
		return entryFee;
	}

	/**
	 * Sets the entry fee.
	 *
	 * @param entryFee
	 *            the new entry fee
	 */
	public void setEntryFee(Integer entryFee) {
		this.entryFee = entryFee;
	}

	/**
	 * Gets the created date.
	 *
	 * @return the created date
	 */
	public Date getPanelDueDate() {
		return panelDueDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param panelDueDate
	 *            the new created date
	 */
	public void setPanelDueDate(Date panelDueDate) {
		this.panelDueDate = panelDueDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((benchedUnbenched == null) ? 0 : benchedUnbenched.hashCode());
		result = prime * result + ((competitionId == null) ? 0 : competitionId.hashCode());
		result = prime * result + ((competitionStatus == null) ? 0 : competitionStatus.hashCode());
		result = prime * result + ((competitionTypeCode == null) ? 0 : competitionTypeCode.hashCode());
		result = prime * result + ((competitorCount == null) ? 0 : competitorCount.hashCode());
		result = prime * result + ((disasterPlanOnFile == null) ? 0 : disasterPlanOnFile.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((entryCount == null) ? 0 : entryCount.hashCode());
		result = prime * result + ((entryFee == null) ? 0 : entryFee.hashCode());
		result = prime * result + ((entryFee2nd == null) ? 0 : entryFee2nd.hashCode());
		result = prime * result + ((entryLimit == null) ? 0 : entryLimit.hashCode());
		result = prime * result + ((entryLimitType == null) ? 0 : entryLimitType.hashCode());
		result = prime * result + ((entryMode == null) ? 0 : entryMode.hashCode());
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result + ((eventSetting == null) ? 0 : eventSetting.hashCode());
		result = prime * result + ((eventStatus == null) ? 0 : eventStatus.hashCode());
		result = prime * result + ((firstEntryAccepted == null) ? 0 : firstEntryAccepted.hashCode());
		result = prime * result + ((includeMixedBreeds == null) ? 0 : includeMixedBreeds.hashCode());
		result = prime * result + ((judgePanelStatus == null) ? 0 : judgePanelStatus.hashCode());
		result = prime * result + ((judgingCategory == null) ? 0 : judgingCategory.hashCode());
		result = prime * result + ((lastEntryAccepted == null) ? 0 : lastEntryAccepted.hashCode());
		result = prime * result + ((panelDueDate == null) ? 0 : panelDueDate.hashCode());
		result = prime * result + ((specialEventType == null) ? 0 : specialEventType.hashCode());
		result = prime * result + ((specialEventType2 == null) ? 0 : specialEventType2.hashCode());
		result = prime * result + ((specialEventType3 == null) ? 0 : specialEventType3.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((timeZone == null) ? 0 : timeZone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompetitionForm other = (CompetitionForm) obj;
		if (benchedUnbenched == null) {
			if (other.benchedUnbenched != null)
				return false;
		} else if (!benchedUnbenched.equals(other.benchedUnbenched))
			return false;
		if (competitionId == null) {
			if (other.competitionId != null)
				return false;
		} else if (!competitionId.equals(other.competitionId))
			return false;
		if (competitionStatus == null) {
			if (other.competitionStatus != null)
				return false;
		} else if (!competitionStatus.equals(other.competitionStatus))
			return false;
		if (competitionTypeCode == null) {
			if (other.competitionTypeCode != null)
				return false;
		} else if (!competitionTypeCode.equals(other.competitionTypeCode))
			return false;
		if (competitorCount == null) {
			if (other.competitorCount != null)
				return false;
		} else if (!competitorCount.equals(other.competitorCount))
			return false;
		if (disasterPlanOnFile == null) {
			if (other.disasterPlanOnFile != null)
				return false;
		} else if (!disasterPlanOnFile.equals(other.disasterPlanOnFile))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (entryCount == null) {
			if (other.entryCount != null)
				return false;
		} else if (!entryCount.equals(other.entryCount))
			return false;
		if (entryFee == null) {
			if (other.entryFee != null)
				return false;
		} else if (!entryFee.equals(other.entryFee))
			return false;
		if (entryFee2nd == null) {
			if (other.entryFee2nd != null)
				return false;
		} else if (!entryFee2nd.equals(other.entryFee2nd))
			return false;
		if (entryLimit == null) {
			if (other.entryLimit != null)
				return false;
		} else if (!entryLimit.equals(other.entryLimit))
			return false;
		if (entryLimitType == null) {
			if (other.entryLimitType != null)
				return false;
		} else if (!entryLimitType.equals(other.entryLimitType))
			return false;
		if (entryMode == null) {
			if (other.entryMode != null)
				return false;
		} else if (!entryMode.equals(other.entryMode))
			return false;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (eventSetting == null) {
			if (other.eventSetting != null)
				return false;
		} else if (!eventSetting.equals(other.eventSetting))
			return false;
		if (eventStatus == null) {
			if (other.eventStatus != null)
				return false;
		} else if (!eventStatus.equals(other.eventStatus))
			return false;
		if (firstEntryAccepted == null) {
			if (other.firstEntryAccepted != null)
				return false;
		} else if (!firstEntryAccepted.equals(other.firstEntryAccepted))
			return false;
		if (includeMixedBreeds == null) {
			if (other.includeMixedBreeds != null)
				return false;
		} else if (!includeMixedBreeds.equals(other.includeMixedBreeds))
			return false;
		if (judgePanelStatus == null) {
			if (other.judgePanelStatus != null)
				return false;
		} else if (!judgePanelStatus.equals(other.judgePanelStatus))
			return false;
		if (judgingCategory == null) {
			if (other.judgingCategory != null)
				return false;
		} else if (!judgingCategory.equals(other.judgingCategory))
			return false;
		if (lastEntryAccepted == null) {
			if (other.lastEntryAccepted != null)
				return false;
		} else if (!lastEntryAccepted.equals(other.lastEntryAccepted))
			return false;
		if (panelDueDate == null) {
			if (other.panelDueDate != null)
				return false;
		} else if (!panelDueDate.equals(other.panelDueDate))
			return false;
		if (specialEventType == null) {
			if (other.specialEventType != null)
				return false;
		} else if (!specialEventType.equals(other.specialEventType))
			return false;
		if (specialEventType2 == null) {
			if (other.specialEventType2 != null)
				return false;
		} else if (!specialEventType2.equals(other.specialEventType2))
			return false;
		if (specialEventType3 == null) {
			if (other.specialEventType3 != null)
				return false;
		} else if (!specialEventType3.equals(other.specialEventType3))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (timeZone == null) {
			if (other.timeZone != null)
				return false;
		} else if (!timeZone.equals(other.timeZone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CompetitionForm [competitionId=" + competitionId + ", eventId=" + eventId + ", competitionTypeCode="
				+ competitionTypeCode + ", startDate=" + startDate + ", endDate=" + endDate + ", eventStatus="
				+ eventStatus + ", judgePanelStatus=" + judgePanelStatus + ", judgingCategory=" + judgingCategory
				+ ", includeMixedBreeds=" + includeMixedBreeds + ", specialEventType=" + specialEventType
				+ ", entryMode=" + entryMode + ", entryLimitType=" + entryLimitType + ", entryLimit=" + entryLimit
				+ ", entryCount=" + entryCount + ", competitorCount=" + competitorCount + ", benchedUnbenched="
				+ benchedUnbenched + ", eventSetting=" + eventSetting + ", disasterPlanOnFile=" + disasterPlanOnFile
				+ ", specialEventType2=" + specialEventType2 + ", specialEventType3=" + specialEventType3
				+ ", entryFee=" + entryFee + ", panelDueDate=" + panelDueDate + ", competitionStatus="
				+ competitionStatus + ", entryFee2nd=" + entryFee2nd + ", firstEntryAccepted=" + firstEntryAccepted
				+ ", lastEntryAccepted=" + lastEntryAccepted + ", timeZone=" + timeZone + "]";
	}

}
