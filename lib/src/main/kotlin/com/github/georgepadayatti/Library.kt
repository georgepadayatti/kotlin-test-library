package com.github.georgepadayatti

import net.jimblackler.jsonschemafriend.Schema;
import net.jimblackler.jsonschemafriend.SchemaException;
import net.jimblackler.jsonschemafriend.SchemaStore;
import net.jimblackler.jsonschemafriend.Validator;


class Hello() {
    fun say(name: String): String {
        return "Hello, $name"
    }

    fun jsonSchema() {
        // Create a new schema in a JSON string.
        val schemaString = ("{"
                + "  \"\$schema\": \"http://json-schema.org/draft-07/schema#\","
                + "  \"type\": \"integer\""
                + "}")

        try {
            val schemaStore = SchemaStore() // Initialize a SchemaStore.
            val schema: Schema = schemaStore.loadSchemaJson(schemaString) // Load the schema.
            val validator = Validator() // Create a validator.
            validator.validateJson(schema, "1") // Will not throw an exception.
            validator.validateJson(schema, "true") // Will throw a ValidationException.
        } catch (e: SchemaException) {
            e.printStackTrace()
        }
    }
}