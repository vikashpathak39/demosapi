package com.org.sapi.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.org.sapi.bean.User;

public class CSVUtil {

	private static final CsvMapper mapper = new CsvMapper();
	
	public static <T> List<T> read(Class<T> clazz, InputStream stream) throws IOException {
    CsvSchema schema = mapper.schemaFor(clazz).withHeader().withColumnReordering(true);
    ObjectReader reader = mapper.readerFor(clazz).with(schema);
    return reader.<T>readValues(stream).readAll();
 }

	public static User getUserByName(List<User> userList,String name) {
		
		User user =null;
		for(User userData :userList) {
			if(userData.getName().equals(name)) {
				user = userData;
			}
		}
		return user;
	}

}