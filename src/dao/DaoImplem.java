package dao;
import java.util.ArrayList;
import java.util.List;
import entidade.Animal;

public class DaoImplem implements AnimalDAO{
	public List<Animal> animais;
	
	public DaoImplem() {
		animais = new ArrayList<Animal>();
		Animal animal1 = new Animal("é perigoso","Tubarão");
		Animal animal2 = new Animal("come banana", "Macaco");
		animais.add(animal1);
		animais.add(animal2);
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}
	
	public void salvar(Animal animal) {
		this.getAnimais().add(animal);
	}
}