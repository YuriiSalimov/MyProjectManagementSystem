package com.management.project.entity;

/**
 * The class implements a set of standard methods for working
 * with entity of the Skill.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class Skill extends Model {

    /**
     * Default constructor.
     */
    public Skill() {
    }

    /**
     * Constructor.
     *
     * @param name a name of the new skill.
     */
    public Skill(String name) {
        super(name);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Skill{" + super.toString() + '}';
    }
}
