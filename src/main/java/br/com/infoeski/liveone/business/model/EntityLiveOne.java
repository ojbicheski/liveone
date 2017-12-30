/**
 * 
 */
package br.com.infoeski.liveone.business.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

import br.com.infoeski.liveone.integration.spring.entity.Entity;

/**
 * BaseRepository class of Entity Live One that support update Date.
 * 
 * @author orlei, Orlei Bicheski
 */
@SuppressWarnings("serial")
public abstract class EntityLiveOne extends Entity {

	/**
	 * Field that receive the update date of the Entity.
	 */
	@Field
	private Date update;

	/**
	 * @return the update
	 */
	public Date getUpdate() {
		return update;
	}

	/**
	 * @param update
	 *            the update to set
	 */
	public void setUpdate(Date update) {
		this.update = update;
	}

	/**
	 * @see br.com.infoeski.liveone.integration.spring.entity.Entity#update(br.com.infoeski.liveone.integration.spring.entity.Entity)
	 */
	@Override
	public void update(Entity entity) {
		super.update(entity);
		setUpdate(new Date());
	}

	/**
	 * Create new ID with in the biggest Identifier.
	 * 
	 * @param list
	 *            Reference of the Collection
	 * @return ID
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected String createId(List list) {
		if (list != null && !list.isEmpty()) {
			Collections.sort(list, new Comparator<Entity>() {
				public int compare(Entity entity1, Entity entity2) {
					return entity1.getId().compareTo(entity2.getId());
				}
			});
			String lastId = ((Entity) list.get(list.size() - 1)).getId();

			return String.valueOf(Integer.getInteger(lastId) + 1);
		}
		return "1";
	}
}
