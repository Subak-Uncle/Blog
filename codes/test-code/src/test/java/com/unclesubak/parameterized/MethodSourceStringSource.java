package com.unclesubak.parameterized;

import org.junit.jupiter.params.provider.MethodSource;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@MethodSource("providerStringSource")
public @interface MethodSourceStringSource {
}
