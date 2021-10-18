package com.flightapp.schedule.payload;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SerachFlightRequest implements Serializable {
	@NotBlank
	private String src ;
	@NotBlank
	private  String dest;
	@FutureOrPresent
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date journyDate;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date returnJourny;

	
	public SerachFlightRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SerachFlightRequest(@NotBlank String src, @NotBlank String dest, @FutureOrPresent Date journyDate,
			Date returnJourny) {
		super();
		this.src = src;
		this.dest = dest;
		this.journyDate = journyDate;
		this.returnJourny = returnJourny;
	}


	public String getSrc() {
		return src;
	}


	public void setSrc(String src) {
		this.src = src;
	}


	public String getDest() {
		return dest;
	}


	public void setDest(String dest) {
		this.dest = dest;
	}


	public Date getJournyDate() {
		return journyDate;
	}


	public void setJournyDate(Date journyDate) {
		this.journyDate = journyDate;
	}


	public Date getReturnJourny() {
		return returnJourny;
	}


	public void setReturnJourny(Date returnJourny) {
		this.returnJourny = returnJourny;
	}


	@Override
	public int hashCode() {
		return Objects.hash(dest, journyDate, returnJourny, src);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SerachFlightRequest other = (SerachFlightRequest) obj;
		return Objects.equals(dest, other.dest) && Objects.equals(journyDate, other.journyDate)
				&& Objects.equals(returnJourny, other.returnJourny) && Objects.equals(src, other.src);
	}


	@Override
	public String toString() {
		return "SerachFlightRequest [src=" + src + ", dest=" + dest + ", journyDate=" + journyDate + ", returnJourny="
				+ returnJourny + "]";
	}
	
	
}
