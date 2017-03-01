package com.management.project.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * The class implements a set of standard methods for working
 * with entity of the Developer.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class Developer extends Model {

    /**
     * The developer salary.
     */
    private int salary;

    /**
     * The company, which employs this developer.
     */
    private Company company;

    /**
     * The project, on which the developer is working.
     */
    private Project project;

    /**
     * The developer skills.
     */
    private Set<Skill> skills = new HashSet<>();

    /**
     * Default constructor.
     */
    public Developer() {
    }

    /**
     * Constructor.
     *
     * @param name a name of the new developer.
     */
    public Developer(String name) {
        super(name);
    }

    /**
     * Constructor.
     *
     * @param name   a name of the new developer.
     * @param skills a skills of the new developer.
     */
    public Developer(String name, Collection<Skill> skills) {
        this(name);
        setSkills(skills);
    }

    /**
     * Constructor.
     *
     * @param name    a name of the new developer.
     * @param salary  a salary of the new developer.
     * @param company a company of the new developer.
     * @param project a project of the new developer.
     */
    public Developer(String name, int salary, Company company, Project project) {
        this(name);
        setSalary(salary);
        setCompany(company);
        setProject(project);
    }

    /**
     * Constructor.
     *
     * @param name    a name of the new developer.
     * @param salary  a salary of the new developer.
     * @param company a company of the new developer.
     * @param project a project of the new developer.
     * @param skills  a skills of the new developer.
     */
    public Developer(
            String name, int salary, Company company,
            Project project, Collection<Skill> skills
    ) {
        this(name, salary, company, project);
        setSkills(skills);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Developer{").append(super.toString())
                .append(", salary=").append(this.salary)
                .append(", company=").append(this.company)
                .append(", project=").append(this.project)
                .append(", skills:");
        for (Skill skill : this.skills) {
            sb.append(skill).append(", ");
        }
        sb.append('}');
        return sb.toString();
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
            final Developer that = (Developer) object;
            result = (this.salary == that.salary) &&
                    (this.company != null ? this.company.equals(that.company) : that.company == null) &&
                    (this.project != null ? this.project.equals(that.project) : that.project == null);
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
        result = 31 * result + this.salary;
        result = 31 * result + (this.company != null ? this.company.hashCode() : 0);
        result = 31 * result + (this.project != null ? this.project.hashCode() : 0);
        return result;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary > 0 ? salary : 0;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Project getProject() {
        return this.project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setSkills(Collection<Skill> skills) {
        if (skills != null) {
            this.skills = new HashSet<>(skills);
        } else {
            this.skills = new HashSet<>();
        }
    }

    public Collection<Skill> getSkills() {
        return this.skills;
    }

    public boolean addSkill(Skill skill) {
        return (skill != null) && this.skills.add(skill);
    }

    public boolean removeSkill(Skill skill) {
        return (skill != null) && this.skills.remove(skill);
    }
}
