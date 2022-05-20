package com.ty.visitor.controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.visitor.dao.VisitorCrud;
import com.ty.visitor.dto.Visitor;

public class TestVisitor {

	public static void main(String[] args) {
		Visitor visitor = new Visitor();
		visitor.setAge(23);
		visitor.setDob("1997-03-28");
		visitor.setEmail("sundeep@gmail.com");
		visitor.setGender("m");
		visitor.setId(6);
		visitor.setName("sundeep");
		visitor.setPhone("876543349");
		visitor.setVisitdatetime("2022-07-23");
		
		VisitorCrud dao = new VisitorCrud();
		dao.saveVisitor(visitor);
		
		//List<Visitor> l = new ArrayList<>();
//		Visitor v = dao.getVisitorById(3);
//		System.out.println(v);
		
//		l= dao.getVisitorByDate("2022-04-29");
//		System.out.println(l);
		
//		l = dao.getVisitorByAgeRange(20, 25);
//		System.out.println(l);

	}

}
