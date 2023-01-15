package org.cherif.mediatheque.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)  // le choix de l'element
@Retention(RetentionPolicy.RUNTIME) // J4USQUA EXECITION

public @interface IpAdress {
}
