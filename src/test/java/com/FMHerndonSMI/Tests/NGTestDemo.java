package com.FMHerndonSMI.Tests;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NGTestDemo {
	
	// Groups are processed within the "Class" and before the "Method"  level
	@BeforeGroups("BusinessProcess")
	public void setupBusinessProcess() {
		System.out.println("			Setup Group for Business Process...");
	}

	@Test(priority = 2)
	public void af2() {
		System.out.println("				Test Annotation af2 (Not in Group)");
	}

	@Test(groups = { "BusinessProcess" }, priority = 0)
	public void f1() {
		System.out.println("				Test Annotation f1");
	}

	@Test(groups = { "Business Process" }, priority = 3)
	public void f3() {
		System.out.println("				Test Annotation f3");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("			Before Method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("			After Method");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("		Before Class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("		After Class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("	Before Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("	After Test");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}
}
