package org.akc.dto;

/**
 * 
 * @author Sarwajeet Bharti 
 * This is a pojo class which containing the data to be shown on the UI.
 *
 */

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "EventCompetitionForm")
public class EventCompetitionForm {

	/** The event id. */
	@NotNull(message = "eventId should not be null")
	@Column(name = "EVENT_ID")
	private Integer eventId;

	/** The competition type code. */
	@Column(name = "COMPETITION_TYPE_CODE")
	private String competitionTypeCode;

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
	 * Gets the event id.
	 *
	 * @return the event id
	 */
	public String getCompetitionTypeCode() {
		return competitionTypeCode;
	}

	/**
	 * Sets the competitionTypeCode.
	 *
	 * @param eventIdcompetitionTypeCode
	 *            the new idcompetitionTypeCode
	 */
	public void setCompetitionTypeCode(String competitionTypeCode) {
		this.competitionTypeCode = competitionTypeCode;
	}

}
