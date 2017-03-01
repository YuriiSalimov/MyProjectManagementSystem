package com.management.project.entity;

/**
 * The class implements a set of standard methods for working
 * with entity of the Customer.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class Customer extends Model {

    /**
     * Default constructor.
     */
    public Customer() {
    }

    /**
     * Constructor.
     *
     * @param name a name of the new customer.
     */
    public Customer(String name) {
        super(name);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Customer{" + super.toString() + '}';
    }
}
