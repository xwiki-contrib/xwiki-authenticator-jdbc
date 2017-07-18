package org.xwiki.contrib.authentication.jdbc.internal;

import javax.inject.Named;
import javax.inject.Singleton;
import org.mindrot.jbcrypt.BCrypt;
import org.xwiki.component.annotation.Component;
import org.xwiki.contrib.authentication.jdbc.PasswordHasher;

@Component
@Singleton
@Named("bcrypt")
public class BcryptPasswordHasher
  implements PasswordHasher
{
  public boolean verify(String dbPassword, String suppliedPassword)
  {
    return BCrypt.checkpw(suppliedPassword, dbPassword);
  }
  
  public String create(String password)
  {
    return BCrypt.hashpw(password, BCrypt.gensalt()); 
  }
}
