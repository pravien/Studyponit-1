package entity;

import entity.Student;
import entity.Teacher;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-24T18:00:13")
@StaticMetamodel(Semester.class)
public class Semester_ { 

    public static volatile SingularAttribute<Semester, String> name;
    public static volatile SingularAttribute<Semester, String> description;
    public static volatile ListAttribute<Semester, Student> studentCollection;
    public static volatile SingularAttribute<Semester, Long> id;
    public static volatile ListAttribute<Semester, Teacher> teacherCollection;

}