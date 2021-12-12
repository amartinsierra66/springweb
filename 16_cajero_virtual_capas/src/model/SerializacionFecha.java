package model;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


public class SerializacionFecha  extends JsonSerializer<LocalDate> {

	  private final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	  @Override
	  public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
	    gen.writeString(value.format(format));
	  }
	  
	}
