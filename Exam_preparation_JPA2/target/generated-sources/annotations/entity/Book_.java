package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-24T13:58:01")
@StaticMetamodel(Book.class)
public class Book_ { 

    public static volatile SingularAttribute<Book, Long> Isbn;
    public static volatile SingularAttribute<Book, String> author;
    public static volatile SingularAttribute<Book, Double> price;
    public static volatile SingularAttribute<Book, String> title;

}