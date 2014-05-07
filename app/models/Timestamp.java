/*******************************************************************************
 *        File: Timestamp.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: November 19, 2013
 *     Project: No Time Protocol <http://time.onto.ir>
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import play.db.jpa.Model;

/** 
 * POSIX timestamp model and corresponding utils.
 */
@Entity
public class Timestamp extends Model {
	
	public String timezone;
	public long posix;
	public byte hour;
	public byte minute;
	public byte second;
	public byte millis;
		  
	public Timestamp(long posixValue) {
		this.posix = posixValue;
	}

	public static Timestamp nowUTC() {
		return new Timestamp(System.currentTimeMillis());
	}
	
	public static Timestamp now() {
		return average();
	}
	
	/**
	 * Returns the average timestamp of all stored timestamps
	 */
	public static Timestamp average() {
		long avrg = 0l;
		List<Timestamp> tss = Timestamp.findAll();
		if(tss.size()>0) {
			for (Timestamp ts: tss) {
				avrg += ts.posix;
			}
			avrg /= tss.size();
		}
		return new Timestamp(avrg);
	}
	
	public String toString() {
		return new Date(posix).toString();
	}
}
