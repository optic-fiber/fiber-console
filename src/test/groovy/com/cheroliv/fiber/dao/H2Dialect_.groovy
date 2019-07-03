package com.cheroliv.fiber.dao

import groovy.transform.CompileStatic
import org.hibernate.dialect.H2Dialect

import java.sql.Types

@CompileStatic
class H2Dialect_ extends H2Dialect {

    H2Dialect_() {
        super()
        registerColumnType Types.FLOAT, "real"
    }
}
