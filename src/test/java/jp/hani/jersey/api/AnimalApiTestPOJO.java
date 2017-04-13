package jp.hani.jersey.api;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import jp.hani.jersey.api.AnimalApi;
import jp.hani.jersey.bean.Animal;
import jp.hani.jersey.bean.Cat;
import jp.hani.jersey.bean.CatBreed;
import jp.hani.jersey.bean.Dog;
import jp.hani.jersey.bean.DogBreed;

public class AnimalApiTestPOJO {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() throws JsonProcessingException {
		AnimalApi api = new AnimalApi();

		List<Animal> animals = api.getAnimals();
		assertThat(animals.size(), is(2));
		assertThat(animals.get(0),is(new Dog("Puppy",DogBreed.GOLDEN_RETRIEVER)));
		assertThat(animals.get(1),is(new Cat("Kitty",CatBreed.ABYSSINIAN)));
	}

	@Test
	public void setTest(){
		AnimalApi api = new AnimalApi();

		Animal dog = new Dog("Puppy", DogBreed.GOLDEN_RETRIEVER);
		Animal cat = new Cat("Kitty", CatBreed.AMERICAN_BOBTAIL);

		assertThat(api.setAnimal(dog),is("DOG"));
		assertThat(api.setAnimal(cat), is("CAT"));

	}

}
