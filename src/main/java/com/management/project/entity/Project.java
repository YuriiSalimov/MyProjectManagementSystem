package com.management.project.entity;

/**
 * The class implements a set of standard methods for working
 * with entity of the Project.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class Project extends Model {

    /**
     * The project cost.
     */
    private int cost;

    /**
     * The company that owns the project.
     */
    private Company company;

    /**
     * The customer of the project.
     */
    private Customer customer;

    /**
     * Default constructor.
     */
    public Project() {
    }

    /**
     * Constructor.
     *
     * @param name a name of the new project.
     * @param cost a cost of the new project.
     */
    public Project(String name, int cost) {
        super(name);
        setCost(cost);
    }

    /**
     * Constructor.
     *
     * @param name     a name of the new project.
     * @param cost     a cost of the new project.
     * @param company  a company of the new project.
     * @param customer a customer of the new project.
     */
    public Project(String name, int cost, Company company, Customer customer) {
        this(name, cost);
        setCompany(company);
        setCustomer(customer);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Project{" + super.toString() +
                ", cost=" + this.cost +
                ", company=" + this.company +
                ", customer=" + this.customer +
                '}';
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param object The reference object with which to compare.
     * @return Returns true if this object is the same as the obj
     * argument, otherwise returns false.
     */
    @Override
    public boolean equals(Object object) {
        boolean result = super.equals(object);
        if (result) {
            final Project that = (Project) object;
            result = (this.cost != that.cost) &&
                    (this.company != null ? this.company.equals(that.company) : that.company == null) &&
                    (this.customer != null ? this.customer.equals(that.customer) : that.customer == null);
        }
        return result;
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.cost;
        result = 31 * result + (this.company != null ? this.company.hashCode() : 0);
        result = 31 * result + (this.customer != null ? this.customer.hashCode() : 0);
        return result;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost > 0 ? cost : 0;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
