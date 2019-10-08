package com.thilina.restTemplate.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)/**from the Jackson JSON processing library to indicate */
public class Quote {                        /**that any properties not bound in this type should be ignored.*/
    private String type;
    private Value value;
                            /**In order for you to directly bind your data to your custom types, you need to */
    public Quote() {        /**specify the variable name exact same as the key in the JSON Document returned from the API. */
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
