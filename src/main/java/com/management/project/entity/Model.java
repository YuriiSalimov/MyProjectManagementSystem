package com.management.project.entity;

import java.io.Serializable;

/**
 * The abstract superclass class implements a set of standard methods
 * for working with entity of the {@link Model} class or subclasses.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public abstract class Model implements Serializable {

    /**
     * It is used during deserialization to verify that
     * the sender and receiver of a serialized object have
     * loaded classes for that object that are compatible
     * with respect to serialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The unique identifier for each object.
     */
    private long id;

    /**
     * The name of this model.
     */
    private String name;

    /**
     * Default constructor.
     */
    public Model() {
        this.name = "";
    }

    /**
     * Constructor.
     *
     * @param name a name of the new model.
     */
    public Model(String name) {
        setName(name);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Model{" +
                "id=" + this.id +
                ", name=" + this.name +
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
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final Model that = (Model) object;
        return this.name.equals(that.name);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name != null ? name : "";
    }
}
