package reflection.task2.executer;

import org.hibernate.Session;
import java.lang.reflect.*;
import java.util.List;

import reflection.task2.model.*;
import reflection.task2.dao.*;
import reflection.task2.bag.*;

public class CommandExecuter {

	public static Bag execute(String commandName, Bag bag) throws Exception {
		try {
			if (commandName == null) return null;

			// get command
			CommandDao cd = new CommandDao();
			Commands command = cd.getCommand(commandName);
			
			// get class name & create an instance
			Class<?> cls = Class.forName("reflection.task2.controller." + command.getClassName());
			Object obj = cls.getDeclaredConstructor().newInstance(null);
			
			Method refMethod;
			Bag bagRes;
			
			if (!bag.getMap().isEmpty()) {
				refMethod = cls.getDeclaredMethod(command.getMethodName(), Bag.class);
				bagRes = (Bag) refMethod.invoke(obj, bag);
			} else {
				refMethod = cls.getDeclaredMethod(command.getMethodName());
				bagRes = (Bag) refMethod.invoke(obj);
			}
			
			//get method name and return it (test with customer class)
//			refMethod = cls.getDeclaredMethod(command.getMethodName(), List.class, Customer.class);
			return bagRes;
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
}
