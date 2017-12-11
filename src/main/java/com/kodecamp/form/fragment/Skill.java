package com.kodecamp.form.fragment;

public class Skill {

	private String skillname;
	private String profeciency;
	private String year;
	private String months;

	public Skill(final String skillname, final String profeciency, final String year, final String months) {
		this.skillname = skillname;
		this.profeciency = profeciency;
		this.year = year;
		this.months = months;
	}

	public String getSkillname() {
		return skillname;
	}

	public String getProfeciency() {
		return profeciency;
	}

	public String getYear() {
		return year;
	}

	public String getMonths() {
		return months;
	}

	@Override
	public String toString() {

		return this.skillname + " " + this.profeciency + " " + this.year + " " + this.months;
	}

	@Override
	public int hashCode() {

		return Integer.parseInt(this.skillname);
	}

	@Override
	public boolean equals(Object obj) {

		boolean flag = false;
		if (obj instanceof Skill) {
			Skill skill = (Skill) obj;
			if (this.skillname.equals(skill.skillname) && this.profeciency.equals(skill.profeciency)
					&& this.year.equals(skill.year) && this.months.equals(skill.months)) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}

}
