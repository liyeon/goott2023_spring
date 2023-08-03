package com.tech.sprj09.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tech.sprj09.dao.IDao;
@Service
public interface BServiceInterface {
//	public void execute(Model model);
	public void execute(Model model,IDao dao);
}