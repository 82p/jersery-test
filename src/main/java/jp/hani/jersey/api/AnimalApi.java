package jp.hani.jersey.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jp.hani.jersey.bean.Animal;
import jp.hani.jersey.bean.Cat;
import jp.hani.jersey.bean.CatBreed;
import jp.hani.jersey.bean.Dog;
import jp.hani.jersey.bean.DogBreed;

	@Path("/animal")
	public class AnimalApi {
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Animal> getAnimals() {
			List<Animal> animals = new ArrayList<Animal>();

			Animal dog = new Dog("Puppy", DogBreed.GOLDEN_RETRIEVER);
			Animal cat = new Cat("Kitty",CatBreed.ABYSSINIAN);
			animals.add(dog);
			animals.add(cat);

			return animals ;
		}

		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		public String setAnimal(Animal animal){
			if(animal instanceof Dog){
				return "DOG";
			}else if(animal instanceof Cat){
				return "CAT";
			}
			return null;
		}
	}
