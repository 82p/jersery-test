package jp.hani.jersey.bean;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class AnimalResolver extends TypeIdResolverBase{

	@Override
	public String getDescForKnownTypeIds() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Id getMechanism() {
		return Id.NAME;
	}

	@Override
	public String idFromBaseType() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String idFromValue(Object value) {
		return idFromValueAndType(value, value.getClass());
	}

	@Override
	public String idFromValueAndType(Object context, Class<?> suggestedType) {
		if (Dog.class.isAssignableFrom(suggestedType)) {
			return "dog";
		} else if (Cat.class.isAssignableFrom(suggestedType)) {
			return "cat";
		}
		throw new IllegalArgumentException();
	}

	@Override
	public void init(JavaType arg0) {
	}

	@Override
	public JavaType typeFromId(DatabindContext context, String id) throws IOException {
		TypeFactory typeFactory = (context != null) ? context.getTypeFactory() : TypeFactory.defaultInstance();
		if ("dog".equals(id)) {
			return typeFactory.constructType(Dog.class);
		} else if ("cat".equals(id)) {
			return typeFactory.constructType(Cat.class);
		}

		throw new IllegalArgumentException();
	}

}
