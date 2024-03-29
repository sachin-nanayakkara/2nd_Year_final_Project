package com.jwt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.jwt.dao.RoomDAO;
import com.jwt.model.Room;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomDAO roomDAO;

	@Transactional
	public void addRooms(Room room) {
		roomDAO.addRooms(room);
		
	}

	@Transactional
	public List<Room> getAllRoom() {
		return roomDAO.getAllRoom();
	}

	@Transactional
	public void deleteRoom(Integer RoomID) {
		roomDAO.deleteRoom(RoomID);
		
	}

		public Room getRoom(int RoomID) {
		return roomDAO.getRoom(RoomID);
	}

		public Room updateRoom(Room room) {
		return roomDAO.updateRoom(room);
	}

	public void setRoom(RoomDAO roomDAO) {
		this.roomDAO = roomDAO;
	}
}
