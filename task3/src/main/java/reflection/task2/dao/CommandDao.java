package reflection.task2.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import reflection.task2.controller.BaseController;
import reflection.task2.model.Account;
import reflection.task2.model.Commands;

@SuppressWarnings("unchecked")
public class CommandDao {
	
	public BaseController b = new BaseController(new Account().getClass());

	public Commands getCommand(String commandName) {
		Transaction transaction = null;
		try (Session session = b.getConnection().openSession()) {
			
			transaction = session.beginTransaction();
			
			List<Commands> commands = session.createCriteria(Commands.class).list();;
			
			//non-transactional
			//transaction.commit();
			
			for (Commands commandItem : commands) {
				if (commandItem.getCommandName().equals(commandName)) {
					return commandItem;
				}
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}
}
