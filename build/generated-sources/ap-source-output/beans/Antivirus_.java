package beans;

import beans.Computadora;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-15T15:17:37")
@StaticMetamodel(Antivirus.class)
public class Antivirus_ { 

    public static volatile SingularAttribute<Antivirus, String> antivirus;
    public static volatile CollectionAttribute<Antivirus, Computadora> computadoraCollection;
    public static volatile SingularAttribute<Antivirus, Integer> id;

}