package bot.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lucky_number")
public class LuckyNumber {
	
	@Id
	@Column(name = "date", nullable=false)
	private String date;
	
	@Column(name = "number")
	private String number;
	
	public LuckyNumber(String date, String number) {
		super();
		this.number = number;
		this.date = date;
	}
	
	public LuckyNumber() {
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
