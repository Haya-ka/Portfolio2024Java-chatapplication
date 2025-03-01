package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Mutter implements Serializable {
	private int id;
	private String userName;
	private String text;
	private Timestamp date;
	private String datetostring;

	public Mutter() {}
	public Mutter(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}
	public Mutter(int id, String userName, String text, Timestamp date) {
		this.id = id;
		this.userName = userName;
		this.text = text;
		this.date = date;
		this.datetostring = dateToString();
	}
	public int getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public String getText() {
		return text;
	}
	public Timestamp getDate() {
		return date;
	}
	public String getDatetostring() {
		return datetostring;
	}
	private String dateToString() {
		// TimestampをLocalDateTimeに変換
		var localDateTime = date.toLocalDateTime();
		var datetostring = String.format("%d年%d月%d日 %d時%d分%d秒",
				localDateTime.getYear(),
				localDateTime.getMonthValue(),
				localDateTime.getDayOfMonth(),
				localDateTime.getHour(),
				localDateTime.getMinute(),
				localDateTime.getSecond()
				);
		return datetostring;
	}
}
