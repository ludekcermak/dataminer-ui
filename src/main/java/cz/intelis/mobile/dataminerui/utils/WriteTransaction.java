package cz.intelis.mobile.dataminerui.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.transaction.annotation.Transactional;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Transactional(rollbackFor = Throwable.class)
public @interface WriteTransaction {

}
