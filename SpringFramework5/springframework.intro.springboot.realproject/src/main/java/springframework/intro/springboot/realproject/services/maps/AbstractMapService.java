 package springframework.intro.springboot.realproject.services.maps;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import springframework.intro.springboot.realproject.models.BaseEntity;
import springframework.intro.springboot.realproject.models.Owner;
import springframework.intro.springboot.realproject.services.CrudService;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {

	protected Map<Long, T> map = new HashMap<>();
	
	public Set<T> findAll(){
		return new HashSet<>(map.values());
	}
	
	public T findById(ID id) {
		return map.get(id);
	}
	
	public T save(T object) {
		
		if(object != null) {
			if(object.getId() == null) {
				object.setId(getNextId());
			}
			map.put(object.getId(), object);
		} else {
			throw new RuntimeException("Object cannot be null");
		}
		
		return object;
	}
	
	public void deleteById(ID id) {
		map.remove(id);
	}
	
	public void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}
	
	private Long getNextId() {
		
		Long nextId = null;
		
		try {
			nextId = Collections.max(map.keySet()) + 1;
		} catch (Exception e) {
			nextId = 1L;
		}
		
		return nextId;
	}
	
}
