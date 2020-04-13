package req.entities;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-13T19:09:05")
@StaticMetamodel(Request.class)
public class Request_ { 

    public static volatile SingularAttribute<Request, String> requestText;
    public static volatile SingularAttribute<Request, LocalDate> requestDate;
    public static volatile SingularAttribute<Request, Integer> id;

}