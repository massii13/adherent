package fr.ols.webappli.service;

import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.data.jpa.domain.Specification;

import fr.ols.webappli.dao.IAbstractEntitiesDao;
import fr.ols.webappli.entities.AbstractEntities;


public abstract class AbstractEntitiesService<T extends AbstractEntities, R extends IAbstractEntitiesDao<T>> implements ApplicationListener<ApplicationReadyEvent>{
	@Autowired
	private ApplicationContext context;
	private final Class<T> entitieClazz;
	private final Class<R> daoClazz;

	protected R entityDao;

	public AbstractEntitiesService(Class<T> dtoClazz, Class<R> daoClazz) {
		this.entitieClazz = dtoClazz;
		this.daoClazz = daoClazz;
	}
	
	
	/**
	 * Permet de récuperer le nombre d'élements dans la base de données.
	 *
	 * @return Le nombre d'élements dans la base de données
	 */
	public long count() {
		return entityDao.count();
	}

	/**
	 * Permet de récupérer un élément grâce à son ID.
	 *
	 * @param id L'ID de l'élément
	 * @return L'élément
	 * @throws EntityNotFoundException Exception lors de récupération de l'entité en base
	 */
	public T findOne(Long id) throws EntityNotFoundException {
		return entityDao.findById(id).orElseThrow(() -> new EntityNotFoundException(entitieClazz.getSimpleName()));
	}

	/**
	 * Permet de récupérer des éléments de la base grâce à Criteria.
	 * @param spec *
	 * @return Les éléments
	 */
	public java.util.List<T> findBySpec(Specification<T> spec) {
		return entityDao.findAll(spec).stream().collect(Collectors.toList());
	}

	/**
	 * Permet de sauvegarder un élément (create ou update) dans la base de données.
	 *
	 * @param item L'élément à sauvegarder
	 * @return L'élément après sauvegarde
	 * @throws EntityNotFoundException Exception lors de récupération de l'entité en base
	 */
	protected T save(T item) throws EntityNotFoundException {
		return entityDao.save(item);
	}

	/**
	 * Permet de créer un élément dans la base de données.
	 *
	 * @param item L'élément à créer
	 * @return L 'élément après création
	 * @throws CreateWithIdException Exception lancée lors de la création d'un objet existant
	 * @throws EntityNotFoundException Exception lors de récupération de l'entité en base
	 */
	public T create(T item) throws EntityNotFoundException {
		return entityDao.save(item);
	}

	/**
	 * Permet de mettre à jour un élément dans la base de données.
	 *
	 * @param id   L'identifiant de l'élément à sauvegarder
	 * @param item L'élément à mettre à jour
	 * @return L 'élément après mise à jour
	 * @throws UpdateWithoutIdException  Exception lancée lors de la mise à jour d'un objet non existant
	 * @throws UpdateIdMismatchException Exception lancée lors de la mise à jour d'un objet avec le mauvais ID
	 * @throws EntityNotFoundException Exception lors de récupération de l'entité en base
	 */
	public T update(Integer id, T item) throws EntityNotFoundException {
		return entityDao.save(item);
	}

	/**
	 * Permet de supprimer un élément de la base de données.
	 *
	 * @param id L'ID de l'élément
	 * @throws EntityNotFoundException Exception lors de récupération de l'entité en base
	 */
	public void delete(Long id) throws EntityNotFoundException {
		T entity = entityDao.findById(id).orElseThrow(() -> new EntityNotFoundException(entitieClazz.getSimpleName()));
		entityDao.delete(entity);
	}

	/**
	 * Permet de récupérer le bean repository de manière générique.
	 *
	 * @param event Event lancé par Spring lorsque l'application est totalement chargée
	 */
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		this.entityDao = context.getBean(daoClazz);
	}
}
