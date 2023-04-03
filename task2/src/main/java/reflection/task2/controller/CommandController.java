package reflection.task2.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import reflection.task2.model.Commands;

public class CommandController extends BaseController<Commands>{


		public CommandController() {
			super(Commands.class);
			// TODO Auto-generated constructor stub
		}
		
		@SuppressWarnings("unchecked")
		public Commands getByName(String commandName) {
			SessionFactory factory=getConnection();
			Commands command=null;
			try (Session session=factory.getCurrentSession()) {
				session.beginTransaction();
				List<Commands> commands=session.createQuery("from Commands").getResultList();
				for(Commands c:commands) {
					if(c.getCommandName().equals(commandName)) {
						command=c;
					}
				}
				session.getTransaction().commit();
			}finally {
				factory.close();
			}
			System.out.println(command);
			return command;
		}

	}
