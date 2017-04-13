package jp.hani.jersey.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Dog extends Animal {

	private DogBreed breed;

	public Dog(String name, DogBreed breed) {
		this.name = name;
		this.breed = breed;
	}

	/**
	 * breedを取得します。
	 *
	 * @return breed
	 */
	public DogBreed getBreed() {
		return breed;
	}

	/**
	 * breedを設定します。
	 *
	 * @param breed
	 *            breed
	 */
	public void setBreed(DogBreed breed) {
		this.breed = breed;
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		return result;
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (breed != other.breed)
			return false;
		return true;
	}
}
