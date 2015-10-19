package org.akc.assembler;

import org.akc.dto.CompetitionForm;
import org.akc.exception.EmsGenericException;
import org.akc.util.EmsGenericResponse;

/*
  Author: Ashok Doddi
  Date: 09/08/15
  CompetitionAssembler interface for save the Competition related data on Competition table.
 */
public interface CompetitionAssembler {

	
	/*
	  getByEventIdCompetitionId method will get the competition based on
	  eventId,competitionId properties
	 
	  @param Competition
	  @return Competition
	 */
	public EmsGenericResponse findByEventIdAndCompetitionId(Integer eventId,Integer competitionId) throws EmsGenericException;

	/*
	  saveCompetition method will update the competition details based on
	  input JSON.
	 
	  @param Competition
	  @return Competition
	 */
	public EmsGenericResponse saveCompetition(CompetitionForm competitionForm) throws EmsGenericException;
	
	/*
	  updateCompetition method will update the competition details based on
	  input JSON.
	 
	  @param Competition
	  @return Competition
	 */
	public EmsGenericResponse updateCompetition(CompetitionForm competitionForm) throws EmsGenericException;
	
	 
}
