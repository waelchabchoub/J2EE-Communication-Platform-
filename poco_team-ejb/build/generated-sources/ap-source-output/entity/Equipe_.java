package entity;

import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-19T21:27:41")
@StaticMetamodel(Equipe.class)
public class Equipe_ { 

    public static volatile SingularAttribute<Equipe, User> idAdmin;
    public static volatile SingularAttribute<Equipe, String> code;
    public static volatile CollectionAttribute<Equipe, User> userCollection;
    public static volatile SingularAttribute<Equipe, byte[]> icon;
    public static volatile SingularAttribute<Equipe, Integer> id;
    public static volatile SingularAttribute<Equipe, String> nom;

}