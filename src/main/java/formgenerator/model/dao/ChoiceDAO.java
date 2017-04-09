package formgenerator.model.dao;

import java.util.List;

import formgenerator.model.Choice;


public interface ChoiceDAO {
	Choice getChoice(Integer id);
	Choice saveChoice(Choice choice);
	boolean delete(Choice choice);
	List<Choice> getChoices();
	List<Choice> getChoices(Integer elementId);
}
