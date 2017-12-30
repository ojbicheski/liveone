/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.base.control;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.infoeski.liveone.business.exception.DataException;
import br.com.infoeski.liveone.integration.spring.entity.Entity;

/**
 * @author orlei, Orlei Bicheski
 */
public abstract class CrudControl<E extends Entity, RP extends MongoRepository<E, String>> implements
		BaseControl<E> {

	/**
	 * Logger.
	 */
	protected static Logger logger = Logger.getLogger(CrudControl.class);

	/**
	 * Return the implementation of specific class.
	 * 
	 * @return reference Repository
	 */
	protected abstract RP getRepository();

	/**
	 * Load the Object references in the Entity.
	 * 
	 * @param entity
	 *            E
	 */
	protected abstract void loadReferences(E entity);

	/**
	 * @see br.com.infoeski.liveone.business.base.control.BaseControl#add(Entity)
	 */
	@Transactional
	public E add(E entity) throws DataException {
		if (logger.isDebugEnabled()) {
			logger.debug("Adding a new object. Class name: ".concat(this.getClass().getName()));
		}

		try {
			// generated ID
			entity.loadId();
			// Load Object References
			loadReferences(entity);

			// Insert to db
			getRepository().save(entity);
			
			if (logger.isInfoEnabled()) {
				logger.info("New object. ID: ".concat(entity.getId()));
			}
			if (logger.isTraceEnabled()) {
				logger.trace("TRACE: ".concat(entity.traced()));
			}
		} catch (Exception e) {
			logger.error("An error has occurred while trying to add new object", e);
			throw new DataException("Failure add new object", e);
		}
		return entity;
	}

	/**
	 * @see br.com.infoeski.liveone.business.base.control.BaseControl#edit(Entity)
	 */
	@Transactional
	public void edit(E entity) throws DataException {
		if (logger.isDebugEnabled()) {
			logger.debug("Editing existing object. Class name: ".concat(this.getClass().getName()));
		}

		try {
			// Find an entry where id matches the id
			E existing = getRepository().findOne(entity.getId());

			// Assign new values
			existing.update(entity);
			// Load Object References
			loadReferences(entity);

			// Save to db
			getRepository().save(existing);

			if (logger.isDebugEnabled()) {
				logger.debug("Editing sucess. Obejct: ".concat(existing.toString()));
			}
			if (logger.isTraceEnabled()) {
				logger.trace("TRACE: ".concat(existing.traced()));
			}
		} catch (Exception e) {
			logger.error("An error has occurred while trying to edit existing object", e);
			throw new DataException("Failure edit object", e);
		}

	}

	/**
	 * @see br.com.infoeski.liveone.business.base.control.BaseControl#get(String)
	 */
	public E get(String id) {
		if (logger.isDebugEnabled()) {
			logger.debug("Retrieving an existing object. Class name: ".concat(this.getClass().getName()));
		}

		// Find an entry where id matches the id
		E entity = getRepository().findOne(id);

		if (logger.isDebugEnabled()) {
			if (entity != null) {
				logger.debug("Found object ".concat(entity.toString()).concat("."));
			} else {
				logger.debug("Not Found object.");
			}
		}

		return entity;
	}

	/**
	 * @see br.com.infoeski.liveone.business.base.control.BaseControl#delete(String)
	 */
	@Transactional
	public void delete(String id) throws DataException {
		if (logger.isDebugEnabled()) {
			logger.debug("Deleting existing object. ID: ".concat(id).concat(
					" Class name: ".concat(this.getClass().getName())));
		}

		try {
			// Find an entry where id matches the id
			E entity = getRepository().findOne(id);

			if (entity == null) {
				logger.error("Not found object to delete");
				throw new DataException("Not found object to delete");
			}

			// Find an entry where id matches the id, then delete that entry
			getRepository().delete(entity);

			if (logger.isDebugEnabled()) {
				logger.debug("The object. ID: ".concat(entity.toString()).concat(" deleted."));
			}
		} catch (Exception e) {
			logger.error("An error has occurred while trying to delete object", e);
			throw new DataException("Failure delete object", e);
		}
	}

	/**
	 * @see br.com.infoeski.liveone.business.base.control.BaseControl#getAll()
	 */
	public List<E> getAll() {
		if (logger.isDebugEnabled()) {
			logger.debug("Retrieving all objects. Class name: ".concat(this.getClass().getName()));
		}

		List<E> list = getRepository().findAll();

		if (logger.isDebugEnabled()) {
			logger.debug("Loaded ".concat(String.valueOf(list.size())).concat(" objects."));
		}
		return list;
	}
}
