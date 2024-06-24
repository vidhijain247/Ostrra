package findLargestFromList;

import java.util.List;

public class findLargest {
	
	private DataService service;
	
	public findLargest(DataService service) {
		super();
		this.service = service;
	}
	
	public boolean findCourseName(String course) {
		List<String> courses = service.dataList();
		boolean found=false;
		if(courses.contains(course)) {
			found=true;
		}
		return found;
	}
}
