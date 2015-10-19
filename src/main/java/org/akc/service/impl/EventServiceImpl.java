package org.akc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.akc.assembler.ChairPersonAssembler;
import org.akc.assembler.EventAssembler;
import org.akc.assembler.EventCompetitionAssembler;
import org.akc.audit.AuditBuilder;
import org.akc.dao.EventDao;
import org.akc.dao.model.Competition;
import org.akc.dao.model.Event;
import org.akc.dto.ChairPersonForm;
import org.akc.dto.EventCompetitionForm;
import org.akc.dto.EventForm;
import org.akc.exception.InvalidException;
import org.akc.transformer.DtoTransformerImpl;
import org.akc.util.EventGenericStatus;
import org.akc.validation.AKCBeanValidator;
import org.akc.validation.EventBeanValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Author: chandra Date: 09/08/15 EventService implemented class provides the
 * methods to be part of Event Service
 */

@Service("eventService")
public class EventServiceImpl implements org.akc.ws.EventService {

	final static Logger logger = LoggerFactory.getLogger(Event.class);

	@Autowired
	EventDao eventDao;

	@Autowired
	AuditBuilder auditBuilder;

	@SuppressWarnings("rawtypes")
	@Autowired
	DtoTransformerImpl dtoTransformer;
	@Autowired
	EventGenericStatus eventGeneric;

	/** The competition assembler. */
	@Resource()
	@Qualifier("eventCompetitionAssembler")
	EventCompetitionAssembler eventCompetitionAssembler;

	/*
	 * @Resource
	 * 
	 * @Qualifier("chairPersonAssembler") ChairPersonAssembler
	 * chairPersonAssembler;
	 * 
	 * public ChairPersonForm chairPersonForm;
	 */

	public Event saveEvent(Event event) throws InvalidException {
		logger.info("enterd saveEvent of EventServiceImpl" + event);
		String eventName = event.getEventName();

		if (StringUtils.isEmpty(eventName)) {
			throw new InvalidException("event name should not be empty");
		}

		String actor = eventName;
		Map<String, String> fieldMap = prepareForAudit(event);
		auditBuilder.audit(actor, fieldMap, "saveEvent");

		return eventDao.save(event);

	}

	/*
	 * This method is used to prepared the inputs for audit The return map is
	 * the key value pair of auditable field
	 */

	private Map<String, String> prepareForAudit(Event event) {
		Map fieldMap = new HashMap<String, String>();
		fieldMap.put("eventId", event.getEventId());
		fieldMap.put("eventName", event.getEventName());
		fieldMap.put("StartDate", event.getStartDate());
		fieldMap.put("EndDate", event.getEndDate());
		return fieldMap;
	}

	@Autowired
	EventAssembler eventAssembler;

	@Override
	public EventForm saveEventForm(EventForm eventForm) {
		try {
			eventForm = eventAssembler.saveorUpdate(eventForm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventForm;

	}

	@Override
	public EventForm updateEventForm(EventForm eventForm) {
		System.out.println(" eventForm data : " + eventForm.toString());
		// EventForm eventForm=null;
		try {
			eventForm = eventAssembler.saveorUpdate(eventForm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventForm;
	}

	@Override
	public EventForm getEvent(Integer eventId) throws InvalidException {

		if (logger.isDebugEnabled()) {
			logger.debug(" Enter getEvent");
		}

		logger.info("Event id :" + eventId);

		EventForm eventForm = new EventForm();

		if (eventId == null) {
			throw new InvalidException(" event id field can't be blank");
		}

		Event event = new Event();
		event.setEventId(eventId.intValue());

		Event eventinfo = eventAssembler.findByEventId(event);

		if (eventinfo == null) {
			throw new InvalidException(" Event id is Not matched ");
		}

		try {

			eventForm = (EventForm) dtoTransformer
					.copyObjectDestination2Source(EventForm.class, eventinfo);
			for (Entry<Object, Object> entry : eventGeneric.getEventStatusMap()
					.entrySet()) {
				if (eventForm.getEventStatus().equals(entry.getKey())) {
					eventForm.setEventStatus(entry.getValue().toString());
				}

			}
			for (Entry<Object, Object> entry : eventGeneric
					.getJudgePanelStatusMap().entrySet()) {
				if (eventForm.getJudgePanelStatus().equals(entry.getKey())) {
					eventForm.setJudgePanelStatus(entry.getValue().toString());
				}

			}
			eventForm.setCompetition(eventinfo.getCompetitionSet());

		} catch (Exception e) {

			throw new InvalidException(e.getLocalizedMessage());
		}

		if (logger.isDebugEnabled()) {
			logger.debug(" Exit getEvent");
		}

		return eventForm;

	}

	@Override
	public List<EventForm> getEvents(Long clubId) {

		if (logger.isDebugEnabled()) {
			logger.debug(" Enter getEvents");
		}

		List<EventForm> eventForms = new ArrayList<EventForm>();
		AKCBeanValidator<EventForm> eventValidator = new AKCBeanValidator<EventForm>();

		Event event = new Event();
		event.setClubId(clubId);
		// eventValidator.isValidBean(eventForm);
		// Event event = (Event)
		// dtoTransformer.copyObjectDestination2Source(Event.class, eventForm);
		List<Event> resultedEvent = eventAssembler.findEventByClubId(event);

		for (Event evt : resultedEvent) {
			EventForm form = new EventForm();
			form = (EventForm) dtoTransformer.copyObjectDestination2Source(
					EventForm.class, evt);
			eventForms.add(form);
		}

		if (logger.isDebugEnabled()) {
			logger.debug(" Exit getEvents");
		}

		return eventForms;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.akc.ws.EventService#getCompetitionTypes(java.lang.Integer) This
	 * method is used to get competition type for particular event id It
	 * received event id as input and return list of competition type
	 */

	@Override
	public List<EventCompetitionForm> getCompetitionTypes(Integer eventId) {

		if (logger.isDebugEnabled()) {
			logger.debug(" Enter getCompetitionTypes ");
		}

		Competition competition = new Competition();
		competition.setEventId(eventId);

		EventBeanValidator<Competition> competitionValidator = new EventBeanValidator<Competition>();
		competitionValidator.isValidBean(competition);

		logger.info(" eventId : " + eventId);

		List<Competition> resultedCompetition = eventCompetitionAssembler
				.competitionTypeListByEventId(competition);

		List<EventCompetitionForm> competitionFormList = new ArrayList<EventCompetitionForm>();

		for (Competition comp : resultedCompetition) {

			EventCompetitionForm competitionForm = new EventCompetitionForm();
			competitionForm.setEventId(comp.getEventId());
			competitionForm.setCompetitionTypeCode(comp
					.getCompetitionTypeCode());
			competitionFormList.add(competitionForm);
		}

		logger.info(" competittion type size : " + resultedCompetition.size());

		if (logger.isDebugEnabled()) {
			logger.debug(" Exit getCompetitionTypes ");
		}

		return competitionFormList;

	}

}