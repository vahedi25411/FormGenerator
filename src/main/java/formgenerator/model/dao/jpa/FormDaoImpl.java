package formgenerator.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import formgenerator.model.Form;
import formgenerator.model.dao.FormDAO;


@Repository
public class FormDaoImpl implements FormDAO {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Form getForm(Integer id)
	{
		return entityManager.find(Form.class, id);
	}
	@Override
	@Transactional
	public Form saveForm(Form form)
	{
		return entityManager.merge(form);	
	}
	@Override
	@Transactional
	public boolean delete(Form form)
	{
		entityManager.remove(form);
		return true;
	}
	@Override
	public List<Form> getForms()
	{
		 return entityManager.createQuery( "from Form order by id desc", Form.class )
		            .getResultList();
	}
}
