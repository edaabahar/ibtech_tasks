package reflection.task2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Commands")
public class Commands {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable=false,unique=true)
	private int Id;
	
	@Column(name="commandName")
	private String CommandName;
	
	@Column(name="className")
	private String ClassName;

	@Column(name="methodName")
	private String MethodName;
	
	public Commands() {}
	
	public Commands(String commandName, String className, String methodName) {
		this.CommandName = commandName;
		this.ClassName = className;
		this.MethodName = methodName;
	}

	public String getCommandName() {
		return this.CommandName;
	}

	public void setCommandName(String commandName) {
		this.CommandName = commandName;
	}

	public String getClassName() {
		return this.ClassName;
	}

	public void setClassName(String className) {
		this.ClassName = className;
	}

	public String getMethodName() {
		return this.MethodName;
	}

	public void setMethodName(String methodName) {
		this.MethodName = methodName;
	}
	
	
}
