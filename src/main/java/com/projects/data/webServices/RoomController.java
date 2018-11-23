package com.projects.data.webServices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projects.data.entity.Room;
import com.projects.data.repository.RoomRepository;

@RestController
public class RoomController {

	@Autowired
	private RoomRepository repository;
	
	@RequestMapping(value="/rooms",method=RequestMethod.GET)
	List<Room> findAll(@RequestParam(required=false) String roomNumber){
		List<Room> rooms=new ArrayList<>();
		if(roomNumber==null) {
			Iterable<Room> results=this.repository.findAll();
			results.forEach(room->{rooms.add(room);});
		}
		else {
			Room room=this.repository.findByNumber(roomNumber);
			if(room!=null) {
				rooms.add(room);
			}
			
		}
		return rooms;
	}
}
