package com.example.helpDesk.api.security.service;

import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.example.helpDesk.api.entity.ChangeStatus;
import com.example.helpDesk.api.entity.Ticket;

@Component
public interface TicketService {

	Ticket createOrUpdate(Ticket ticket);
	
	Ticket findById(String id);
	
	void delete(String id);
	
	Page<Ticket> listTicket(int page, int count);
	
	ChangeStatus createChangeStatus(ChangeStatus changeStatus);
	
	Iterable<ChangeStatus> listChangeStatus(String ticketId);
	
	Page<Ticket> fingByCurrentUser(int page, int count, String userId);
	
	Page<Ticket> fingByParameters(int page, int count, String title, String status, String priority);
	
	Page<Ticket> fingByParametersAndCurrentUser(int page, int count, String title, String status, String priority, String userId);
	
	Page<Ticket> fingByNumber(int page, int count, Integer number);
	
	Iterable<Ticket> fingAll();
	
	Page<Ticket> findByParameterAndAssignedUser(int page, int count, String title, String status, String priority, String assignedUser);
}
