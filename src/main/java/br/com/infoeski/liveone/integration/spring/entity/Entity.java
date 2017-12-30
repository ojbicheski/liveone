/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.integration.spring.entity;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Base to Entity MongoDB.
 * 
 * @author orlei, Orlei Bicheski
 */
@SuppressWarnings("serial")
public abstract class Entity implements Serializable {

	/**
	 * Unique identifier.
	 */
	@Id
	private String id;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Verify ID is loaded.
	 * 
	 * @return booelan
	 */
	public boolean hasId() {
		return id != null && !id.isEmpty();
	}

	public void loadId() {
		setId(new ObjectId().toString());
	}

	/**
	 * Execute the update of data.
	 * 
	 * @param entity
	 *            Reference to update
	 */
	public void update(Entity entity) {
		for (java.lang.reflect.Field field : getInheritedPrivateFields(this.getClass())) {
			if (field.isAnnotationPresent(Field.class) && !"create".equalsIgnoreCase(field.getName())) {
				set(this, field, get(entity, field));
			}
		}
	}

	private List<java.lang.reflect.Field> getInheritedPrivateFields(Class<?> type) {
		List<java.lang.reflect.Field> result = new ArrayList<java.lang.reflect.Field>();

		Class<?> i = type;
		while (i != null && i != Entity.class) {
			for (java.lang.reflect.Field field : i.getDeclaredFields()) {
				result.add(field);
			}
			i = i.getSuperclass();
		}

		return result;
	}

	/**
	 * Invoca o método GET do campo específico do objeto Entity referenciado.
	 * 
	 * @param field
	 *            Objeto de reflexão do campo a ser invocado
	 * @return Valor contindo no campo
	 * @throws JsonException
	 */
	private Object get(Entity entity, java.lang.reflect.Field field) {
		if (boolean.class.equals(field.getType())) {
			return invoke(entity, field, "is");
		} else {
			return invoke(entity, field, "get");
		}
	}

	/**
	 * Executa por reflexão o método Set do campo informado como parâmetro.
	 * 
	 * @param field
	 *            Campo do objeto {@link Entity}
	 * @param args
	 *            Array de argumentos a serem passados como parâmetro para o
	 *            método Set responsável pelo campo informado.
	 * @throws JsonException
	 */
	private void set(Entity entity, java.lang.reflect.Field field, Object... args) {
		invoke(entity, field, "set", args);
	}

	/**
	 * implementação do Invoke para os métodos Get e Set dos objetos
	 * {@link Entity}.
	 * 
	 * @param field
	 *            Campo utilizado como referência para invocar o respectivo
	 *            método Get ou Set
	 * @param prefix
	 *            Prefixo que identifica
	 * @param args
	 * @return {@link Object}
	 */
	private Object invoke(Entity entity, java.lang.reflect.Field field, String prefix, Object... args) {
		String name = field.getName();
		StringBuilder method = new StringBuilder().append(prefix).append(name.substring(0, 1).toUpperCase())
				.append(name.substring(1));

		try {
			if (args != null && args.length > 0) {
				// Invoke Method SET
				Object parameter = parameter(field, args);
				if (parameter == null) {
					return null;
				}

				return entity.getClass().getMethod(method.toString(), type(field)).invoke(entity, parameter);
			} else {
				// Invoke Method GET
				return entity.getClass().getMethod(method.toString()).invoke(entity);
			}
		} catch (NoSuchMethodException e) {
			throw new RuntimeException("Método ".concat(method.toString()).concat(" não encontrado."), e);
		} catch (SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | IOException e) {
			throw new RuntimeException("Falha no método ".concat(method.toString()), e);
		}
	}

	/**
	 * Extract class type of the field and create Array that will be used to
	 * invoke Set method.
	 * 
	 * @param field
	 *            Field of Entity.
	 * @return Class<?>[]
	 */
	private Class<?>[] type(java.lang.reflect.Field field) {
		return new Class<?>[] { field.getType() };
	}

	/**
	 * Prepara o Array com os tipos das classes de cada parâmetro do método a
	 * ser invocado.
	 * 
	 * @param args
	 *            Array contendo os parâmetros
	 * @return Class<?>[]
	 * @throws IOException
	 */
	private Object parameter(java.lang.reflect.Field field, Object... args) throws IOException {
		for (Object object : args) {
			if (object == null) {
				return null;
			}
			return object;
		}
		return null;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Entity other = (Entity) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	/**
	 * Load fields to Trace.
	 * 
	 * @return String
	 */
	public String traced() {
		Class<?> klass = this.getClass();
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("Entity::");
		buffer.append(klass.getSimpleName()).append(" ");
		
		for (java.lang.reflect.Field field : getInheritedPrivateFields(klass)) {
			if (field.isAnnotationPresent(Field.class)) {
				buffer.append("[").append(field.getName()).append("=");
				buffer.append(get(this, field));
				buffer.append("] ");
			}
		}
		return buffer.toString();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Entity::".concat(getClass().getSimpleName()).concat(" [id=").concat(id).concat("]");
	}
}
