/**
 * This class is generated by jOOQ
 */
package org.alexkovalenko.data.generated.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.1" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ExpenseRecord extends org.jooq.impl.UpdatableRecordImpl<org.alexkovalenko.data.generated.tables.records.ExpenseRecord> implements org.jooq.Record5<java.lang.Long, java.lang.String, java.lang.String, java.math.BigDecimal, java.sql.Date> {

	private static final long serialVersionUID = -525107812;

	/**
	 * Setter for <code>expenses_logger.expense.id</code>.
	 */
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>expenses_logger.expense.id</code>.
	 */
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>expenses_logger.expense.name</code>.
	 */
	public void setName(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>expenses_logger.expense.name</code>.
	 */
	public java.lang.String getName() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>expenses_logger.expense.description</code>.
	 */
	public void setDescription(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>expenses_logger.expense.description</code>.
	 */
	public java.lang.String getDescription() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>expenses_logger.expense.value</code>.
	 */
	public void setValue(java.math.BigDecimal value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>expenses_logger.expense.value</code>.
	 */
	public java.math.BigDecimal getValue() {
		return (java.math.BigDecimal) getValue(3);
	}

	/**
	 * Setter for <code>expenses_logger.expense.date</code>.
	 */
	public void setDate(java.sql.Date value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>expenses_logger.expense.date</code>.
	 */
	public java.sql.Date getDate() {
		return (java.sql.Date) getValue(4);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.Long> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record5 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row5<java.lang.Long, java.lang.String, java.lang.String, java.math.BigDecimal, java.sql.Date> fieldsRow() {
		return (org.jooq.Row5) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row5<java.lang.Long, java.lang.String, java.lang.String, java.math.BigDecimal, java.sql.Date> valuesRow() {
		return (org.jooq.Row5) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return org.alexkovalenko.data.generated.tables.Expense.EXPENSE.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return org.alexkovalenko.data.generated.tables.Expense.EXPENSE.NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return org.alexkovalenko.data.generated.tables.Expense.EXPENSE.DESCRIPTION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.math.BigDecimal> field4() {
		return org.alexkovalenko.data.generated.tables.Expense.EXPENSE.VALUE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Date> field5() {
		return org.alexkovalenko.data.generated.tables.Expense.EXPENSE.DATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value2() {
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value3() {
		return getDescription();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.math.BigDecimal value4() {
		return getValue();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Date value5() {
		return getDate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ExpenseRecord value1(java.lang.Long value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ExpenseRecord value2(java.lang.String value) {
		setName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ExpenseRecord value3(java.lang.String value) {
		setDescription(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ExpenseRecord value4(java.math.BigDecimal value) {
		setValue(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ExpenseRecord value5(java.sql.Date value) {
		setDate(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ExpenseRecord values(java.lang.Long value1, java.lang.String value2, java.lang.String value3, java.math.BigDecimal value4, java.sql.Date value5) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached ExpenseRecord
	 */
	public ExpenseRecord() {
		super(org.alexkovalenko.data.generated.tables.Expense.EXPENSE);
	}

	/**
	 * Create a detached, initialised ExpenseRecord
	 */
	public ExpenseRecord(java.lang.Long id, java.lang.String name, java.lang.String description, java.math.BigDecimal value, java.sql.Date date) {
		super(org.alexkovalenko.data.generated.tables.Expense.EXPENSE);

		setValue(0, id);
		setValue(1, name);
		setValue(2, description);
		setValue(3, value);
		setValue(4, date);
	}
}