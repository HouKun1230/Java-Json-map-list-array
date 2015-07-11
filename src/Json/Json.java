package Json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

public class Json {
	
	public static void main(String args[]){
		beanToJson();
		beanToJson1();
		beanToJson2();
		arrayToJson();
		listToJson();		
		mapToJson();
		
	}
	
	

	public static void beanToJson(){
		Employee Employee=new Employee();
		Employee.setName("kun");
		Employee.setAge(25);
		Employee.setDepartment("cs");
        JSONObject json = JSONObject.fromObject(Employee);
	    System.out.println("-----------------------------------------beanToJson() Begin------------------------------------------------");
	    System.out.println(json.toString());
	    System.out.println("-----------------------------------------beanToJson() End------------------------------------------------");
	}
	

	public static void beanToJson1(){
		Employee Employee=new Employee();
		Employee.setName("kun");
		Employee.setAge(25);
		Employee.setDepartment("cs");
		JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]
        { "age" });
        JSONObject json = JSONObject.fromObject(Employee, jsonConfig);
	    System.out.println("-----------------------------------------beanToJson1()------------------------------------------------");
	    System.out.println(json.toString());
	    System.out.println("-----------------------------------------beanToJson1()------------------------------------------------");
	}
	

	public static void beanToJson2(){
		Employee Employee=new Employee();
		Employee.setName("kun");
		Employee.setAge(25);
		Employee.setDepartment("cs");
		JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
            public boolean apply(Object source, String name, Object value)
            {
                return source instanceof Employee && name.equals("age");
            }
        });
        JSONObject json = JSONObject.fromObject(Employee, jsonConfig);
	    System.out.println("-----------------------------------------beanToJson2()------------------------------------------------");
	    System.out.println(json.toString());
	    System.out.println("-----------------------------------------beanToJson2()------------------------------------------------");
	}
	

	public static void arrayToJson(){
		Employee Employee1=new Employee();
		Employee1.setName("kun");
		Employee1.setAge(25);
		Employee1.setDepartment("cs");
		
		Employee Employee2=new Employee();
		Employee2.setName("kun");
		Employee2.setAge(25);
		Employee2.setDepartment("cs");	
		Employee[] Employees=new Employee[]{Employee1,Employee2};
		JSONArray json = JSONArray.fromObject(Employees);
		System.out.println("-----------------------------------------arrayToJson()------------------------------------------------");
		System.out.println(json.toString());
		System.out.println("-----------------------------------------arrayToJson()------------------------------------------------");
	}
	

	public static void listToJson(){
		List<String> list = new ArrayList<String>();
		list.add( "first" );
		list.add( "second" );
		JSONArray json = JSONArray.fromObject(list);
	    System.out.println("-----------------------------------------listToJson()------------------------------------------------");
	    System.out.println(json.toString());
	    System.out.println("-----------------------------------------listToJson()------------------------------------------------");
	}
	

	public static void mapToJson(){
		Map<Object,Object> map = new HashMap<Object,Object>();
		map.put("name", "json");
		map.put("bool", Boolean.TRUE);
		map.put("int", new Integer(1));
		map.put("arr", new String[] { "a", "b" });
		map.put("func", "function(i){ return this.arr[i]; }");
		JSONObject json = JSONObject.fromObject(map);
		System.out.println("-----------------------------------------mapToJson()------------------------------------------------");
	    System.out.println(json.toString());
	    System.out.println("-----------------------------------------mapToJson()------------------------------------------------");
	}
 

}
