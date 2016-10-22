/**
 * This class is generated by jOOQ
 */
package org.alexkovalenko.data.generated.tables.pojos;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.1" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Expense implements java.io.Serializable {

	private static final long serialVersionUID = -871039912;

	private java.lang.Long       id;
	private java.lang.String     name;
	private java.lang.String     description;
	private java.math.BigDecimal value;
	private java.sql.Date        date;

	public Expense() {}

	public Expense(
		java.lang.Long       id,
		java.lang.String     name,
		java.lang.String     description,
		java.math.BigDecimal value,
		java.sql.Date        date
	) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.value = value;
		this.date = date;
	}

	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.String getName() {
		return this.name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getDescription() {
		return this.description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	public java.math.BigDecimal getValue() {
		return this.value;
	}

	public void setValue(java.math.BigDecimal value) {
		this.value = value;
	}

	public java.sql.Date getDate() {
		return this.date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}
}