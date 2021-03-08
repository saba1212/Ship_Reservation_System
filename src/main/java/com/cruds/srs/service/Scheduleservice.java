package com.cruds.srs.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.srs.db.ScheduleDAO;
import com.cruds.srs.entity.Schedule;

@Service
public class Scheduleservice {
	
	@Autowired
	ScheduleDAO scheduleDao;
	
	
	public String addSchedule(Schedule scheduleBean)
	{
		return scheduleDao.addSchedule(scheduleBean);
	}
	
	public ArrayList<Schedule> viewByAllSchedule()
	{
		return scheduleDao.viewByAllSchedule();
	}
	
	public int removeSchedule(String scheduleId)
	{
		return scheduleDao.removeSchedule(scheduleId);
	}
	
	public boolean modifySchedule(Schedule scheduleBean)
	{
		return scheduleDao.modifySchedule(scheduleBean);
	}




}
