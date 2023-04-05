package reflection.task2.bag;

import java.util.Map;
import java.util.HashMap;

public class Bag {
	
	private Map<BagKey, Object> map = new HashMap<BagKey, Object>();
	
	public Map<BagKey, Object> getMap(){
		return this.map;
	}
	
	public void setMap(Map<BagKey, Object> map){
		this.map = map;
	}
	
	public Object getValue(BagKey key) {
		return this.map.get(key);
	}
	
	public void putValue(BagKey key, Object value) {
		this.map.put(key, value);
	}
}
