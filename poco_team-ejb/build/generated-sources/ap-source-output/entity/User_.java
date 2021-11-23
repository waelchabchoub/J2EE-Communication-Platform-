package entity;

import entity.Equipe;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-19T21:27:41")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, byte[]> image;
    public static volatile SingularAttribute<User, String> password;
    public static volatile CollectionAttribute<User, Equipe> equipeCollection1;
    public static volatile CollectionAttribute<User, Equipe> equipeCollection;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> login;
    public static volatile SingularAttribute<User, String> nom;
    public static volatile SingularAttribute<User, String> prenom;
    public static volatile SingularAttribute<User, String> email;

}