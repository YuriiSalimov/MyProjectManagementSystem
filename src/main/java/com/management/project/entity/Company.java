package com.management.project.entity;

/**
 * The class implements a set of standard methods for working
 * with entity of the Company.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class Company extends Model {

    /**
     * Default constructor.
     */
    public Company() {
    }

    /**
     * Constructor.
     *
     * @param name a name of the new company.
     */
    public Company(String name) {
        super(name);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Company{" + super.toString() + '}';
    }
}
