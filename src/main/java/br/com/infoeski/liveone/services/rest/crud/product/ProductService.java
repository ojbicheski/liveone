/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.services.rest.crud.product;

import br.com.infoeski.liveone.business.base.control.BaseControl;
import br.com.infoeski.liveone.business.model.products.Product;
import br.com.infoeski.liveone.services.rest.crud.CrudService;

/**
 * @author orlei, Orlei Bicheski
 * 
 */
public abstract class ProductService<C extends BaseControl<E>, E extends Product> extends CrudService<C, E> {
}
