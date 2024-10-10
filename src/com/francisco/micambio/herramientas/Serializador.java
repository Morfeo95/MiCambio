package com.francisco.micambio.herramientas;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Serializador implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {
    //Permite a gson guardar e imprir LocaleDateTime
    private static final DateTimeFormatter formato = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Override
    public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.format(formato));  // Convierte LocalDateTime a String
    }

    @Override
    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return LocalDateTime.parse(json.getAsString(), formato);  // Convierte el String de vuelta a LocalDateTime
    }
}
