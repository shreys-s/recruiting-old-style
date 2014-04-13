package it.f2informatica.core;

import com.google.gson.*;
import it.f2informatica.mongodb.MongoDBApplicationContext;
import it.f2informatica.mysql.MySQLApplicationContext;
import org.joda.time.DateTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.reflect.Type;
import java.util.Date;

@Configuration
@ComponentScan(basePackages = {"it.f2informatica.core"})
@Import({MongoDBApplicationContext.class, MySQLApplicationContext.class})
public class ServicesApplicationContext {
  public static final String GLOBAL_DATE_FORMAT = "dd-MM-yyyy";

  @Bean
  public Gson gson() {
    return new GsonBuilder()
      .serializeNulls()
      .setPrettyPrinting()
      .setDateFormat(GLOBAL_DATE_FORMAT)
      .serializeSpecialFloatingPointValues()
      .registerTypeAdapter(DateTime.class, new DateTimeTypeAdapter())
      .create();
  }

  private static class DateTimeTypeAdapter implements JsonSerializer<DateTime>, JsonDeserializer<DateTime> {
    @Override
    public JsonElement serialize(DateTime src, Type typeOfSrc, JsonSerializationContext context) {
      return new JsonPrimitive(src.toString(GLOBAL_DATE_FORMAT));
    }

    @Override
    public DateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
      try {
        return new DateTime(json.getAsString());
      } catch (IllegalArgumentException e) {
        Date date = context.deserialize(json, Date.class);
        return new DateTime(date);
      }
    }
  }

}
