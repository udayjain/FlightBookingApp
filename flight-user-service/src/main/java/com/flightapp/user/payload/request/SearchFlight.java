package com.flightapp.user.payload.request;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SearchFlight implements Serializable{
	private static final long serialId = 1L;
	
	@NotNull
	@NotBlank
	private String from;
	
	@NotNull
	@NotBlank
	private String to;
	
	 @JsonFormat(pattern="yyyy-MM-dd")
	 private LocalDate journyDate;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate returnDate;
	
	private int noOfPassenger;	
	private boolean returnJourny;
	private SearchFlight returnSerachFlight;
	
	public SearchFlight(@NotNull @NotBlank String from, @NotNull @NotBlank String to, LocalDate journyDate, LocalDate returnDate,
			int noOfPassenger, boolean returnJourny) {
		super();
		this.from = from;
		this.to = to;
		this.journyDate = journyDate;
		this.returnDate = returnDate;
		this.noOfPassenger = noOfPassenger;
		this.returnJourny = returnJourny;
		
		if (returnJourny) {
			this.returnDate = returnDate!= null ? returnDate : journyDate.plusDays(1);
			this.returnSerachFlight = new SearchFlight(to,from, returnDate, null,noOfPassenger,false);
		}
		
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public LocalDate getJournyDate() {
		return journyDate;
	}

	public void setJournyDate(LocalDate journyDate) {
		this.journyDate = journyDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public int getNoOfPassenger() {
		return noOfPassenger;
	}

	public void setNoOfPassenger(int noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}

	public boolean isReturnJourny() {
		return returnJourny;
	}

	public void setReturnJourny(boolean returnJourny) {
		this.returnJourny = returnJourny;
	}

	public SearchFlight getReturnSerachFlight() {
		return returnSerachFlight;
	}

	public void setReturnSerachFlight(SearchFlight returnSerachFlight) {
		this.returnSerachFlight = returnSerachFlight;
	}

	@Override
	public String toString() {
		return "SearchFlight [from=" + from + ", to=" + to + ", journyDate=" + journyDate + ", returnDate=" + returnDate
				+ ", noOfPassenger=" + noOfPassenger + ", returnJourny=" + returnJourny + ", returnSerachFlight="
				+ returnSerachFlight + "]";
	}
	
	
	
}
