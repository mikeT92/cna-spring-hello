/*
 * cna-spring-persistence:MessageRepository.java
 */
package edu.hm.cs.fwp.cloud.hello.adapter.persistence;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import edu.hm.cs.fwp.cloud.hello.core.entity.Message;

public interface MessageRepository extends CrudRepository<Message, UUID> {

}