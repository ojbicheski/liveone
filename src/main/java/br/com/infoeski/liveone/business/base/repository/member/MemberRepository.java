/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.base.repository.member;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.infoeski.liveone.business.model.member.Member;

/**
 * Repository that support the operations of Member entity.
 * 
 * @author orlei, Orlei Bicheski
 */
public interface MemberRepository extends MongoRepository<Member, String> {

}
