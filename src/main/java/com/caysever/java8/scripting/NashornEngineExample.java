package com.caysever.java8.scripting;

import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import com.caysever.java8.model.Person;
import com.caysever.java8.utils.PersonUtil;

public class NashornEngineExample {

    public static void main(String[] args) throws Exception {

	List<Person> persons = PersonUtil.mockPersons();
	
	ScriptEngineManager engineManager = new ScriptEngineManager();
	ScriptEngine engine = engineManager.getEngineByName("nashorn");
	
	engine.eval("var System = Java.type('java.lang.System');"
		+ "  function printPersons(persons){"
		+ "	persons.forEach(function(e){"
		+ "	   System.out.println(e);"
		+ "	});"
		+ "  }");
	
	
	Invocable invocable = (Invocable) engine;
	invocable.invokeFunction("printPersons", persons);
    }
}
