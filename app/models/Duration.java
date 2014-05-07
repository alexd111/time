/*******************************************************************************
 *        File: Duration.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: January 2, 2014
 *     Project: No Time Protocol <http://time.onto.ir>
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import play.db.jpa.Model;

/** 
 * Represents span of time using Timestamp Model.
 * Duration does not depend on any specific Timestamp
 * of specific time concept in real life. It only uses
 * them for calculation.
 */
@Entity
public class Duration extends Model {
	
	long millis;

	public Duration(Timestamp start, Timestamp end) {
		//TODO calc the millis from start to end - 1
	}

	public Duration averageAll() {
		//TODO average all durations in the db!
	}

	public Timestamp toUTC() {
		//TODO add average to Timestamp.now();
	}

	public String toString() {
		return new Date(millis).toString();
	}
}
