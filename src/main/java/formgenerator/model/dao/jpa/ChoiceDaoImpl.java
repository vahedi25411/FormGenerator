package formgenerator.model.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import formgenerator.model.Choice;
import formgenerator.model.Page;
import formgenerator.model.dao.ChoiceDAO;

@Repository
public class ChoiceDaoImpl implements ChoiceDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Choice getChoice(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Choice.class, id);
	}

	@Override
	@Transactional
	public Choice saveChoice(Choice choice) {

		return entityManager.merge(choice);
	}

	@Override
	@Transactional
	public boolean delete(Choice choice) {
		entityManager.remove(choice);
		return false;
	}


	@Override
	public List<Choice> getChoices() {
		 return entityManager.createQuery( "from Choice order by id", Choice.class )
		            .getResultList();
	}

	@Override
	public List<Choice> getChoices(Integer elementId) {

		 return entityManager.createQuery( "SELECT c FROM FormElement fe JOIN fe.choices c WHERE fe.id = :elementId", Choice.class ).setParameter("elementId", elementId)
		            .getResultList();
	}
	
	

}
