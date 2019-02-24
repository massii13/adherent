package fr.ols.webappli.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.ols.webappli.dao.IAbstractEntitiesDao;
import fr.ols.webappli.entities.AbstractEntities;
import fr.ols.webappli.service.AbstractEntitiesService;

/**
 * Classe abstraite regroupant les opérations génériques de persistance.
 *
 * @param <T> L'entité structurelle
 * @param <S> Le DTO de l'entité structurelle
 * @param <U> La repository de l'entité structurelle
 * @param <V> Le service associé à l'entité structurelle
 */
public abstract class AbstracEntitiesController<T extends AbstractEntities, U extends IAbstractEntitiesDao<T>, V extends AbstractEntitiesService<T, U>>
		implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private ApplicationContext context;

	private final Class<V> serviceClazz;

	protected V entityService;

	public AbstracEntitiesController(Class<V> serviceClazz) {
		this.serviceClazz = serviceClazz;
	}

	@Transactional
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<T> getAll(Specification<T> spec) {
		return entityService.findBySpec(spec);
	}
	
	
	@Transactional
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public T get(@PathVariable(name = "id") Long id) {
		return entityService.findOne(id);
	}

	@Transactional
	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public T create(@RequestBody T item) {
		return entityService.create(item);
	}

	@Transactional
	@PatchMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public T update(@PathVariable(name = "id") Integer id, @RequestBody T item) {
		return entityService.update(id, item);
	}

	@Transactional
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable(name = "id") Long id) {
		entityService.delete(id);
	}

	
	@Transactional
	@RequestMapping(method = RequestMethod.HEAD)
	public ResponseEntity<Void> count() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Count", String.valueOf(entityService.count()));
		return new ResponseEntity<>(headers, HttpStatus.OK);
	}


	
	/**
	 * Permet de récupérer le bean service de manière générique.
	 *
	 * @param event Event lancé par Spring lorsque l'application est totalement chargée
	 */
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		this.entityService = context.getBean(serviceClazz);
	}
}
