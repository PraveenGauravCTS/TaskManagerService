package com.taskmanager.service.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.taskmanager.service.test.exception.ServiceApplicationExceptionTest;
import com.taskmanager.service.test.exception.ServiceGlobalExceptionHandlerTest;
import com.taskmanager.service.test.manager.ParentTaskManagerTest;
import com.taskmanager.service.test.manager.TaskManagerTest;
import com.taskmanager.service.test.rest.ParentTaskServiceTest;
import com.taskmanager.service.test.rest.TaskServiceTest;
import com.taskmanager.service.test.util.ServiceResponseUtilityTest;

@SuiteClasses({ ParentTaskServiceTest.class, TaskServiceTest.class, ParentTaskManagerTest.class, TaskManagerTest.class,
		ServiceResponseUtilityTest.class, ServiceGlobalExceptionHandlerTest.class,
		ServiceApplicationExceptionTest.class })
@RunWith(Suite.class)
public class AllTests {
}
