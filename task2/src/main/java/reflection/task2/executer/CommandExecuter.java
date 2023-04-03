package reflection.task2.executer;

import org.hibernate.Session;
import java.lang.reflect.*;
import java.util.List;

import reflection.task2.model.*;
import reflection.task2.dao.*;

public class CommandExecuter {

	public static Method execute(String commandName) throws Exception {
		try {
			// get command
			CommandDao cd = new CommandDao();
			Commands command = cd.getCommand(commandName);
			
			// get class name
			Class<?> cls = Class.forName("reflection.task2.controller." + command.getClassName());
			
			Method refMethod;
			//get method name and return it (test with customer class)
			refMethod = cls.getDeclaredMethod(command.getMethodName(), List.class, Customer.class);
			return refMethod;
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
}
