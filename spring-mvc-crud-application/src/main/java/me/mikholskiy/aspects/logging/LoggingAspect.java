package me.mikholskiy.aspects.logging;

import com.github.tomaslanger.chalk.Chalk;
import me.mikholskiy.domains.Customer;
import me.mikholskiy.exceptions.CustomerNotFoundException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
	private final Logger logger = Logger.getLogger(getClass().getName());

	public static String getCurrentTime() {
		return DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss").format(LocalDateTime.now());
	}

	@Pointcut(
		"execution(public java.util.Optional<me.mikholskiy.domains.Customer> me.mikholskiy.daos.CustomerDao.get(int))")
	private void forGetByIdMethod() {
	}

	@AfterReturning(
		pointcut = "execution(public java.util.List<me.mikholskiy.domains.Customer> me.mikholskiy.daos.CustomerDao.getAll())",
		returning = "resultList")
	public void adviceBeforeGetAllCustomersFromDatabase(JoinPoint joinPoint, List<?> resultList) {
		System.out.println(Chalk.on("[").blue().bold().toString() +
							   Chalk.on(getCurrentTime())
									.yellow()
									.bold()
									.toString() +
							   Chalk.on("] Retrieving all customers from database using ")
									.blue()
									.bold()
									.toString() +
							   Chalk.on(joinPoint.getSignature().toString())
									.underline()
									.blue());

		resultList.stream().map(Customer.class::cast).forEach(c -> c.setLastName(c.getLastName().toUpperCase()));
	}

	@Before("forGetByIdMethod() && args(id)")
	public void adviceBeforeGetCustomerByIdFromDatabase(int id) {
		System.out.println(Chalk.on("[").blue().bold().toString() + Chalk.on(getCurrentTime())
																		 .yellow()
																		 .bold()
																		 .toString() + Chalk.on("] Trying to retrieve customer with id=")
																							.blue()
																							.bold()
																							.toString() + Chalk.on(String.valueOf(id))
																											   .yellow()
																											   .bold()
																											   .toString() + Chalk.on(" from data base.")
																																  .blue()
																																  .bold());
	}

	@AfterReturning(pointcut = "forGetByIdMethod()", returning = "result")
	public void adviceAfterGetCustomersByIdFromDatabase(JoinPoint joinPoint, Optional<?> result) {
		System.out.println(Chalk.on("AfterReturning advice of [")
								.bgBlue()
								.bold()
								.toString() + Chalk.on(joinPoint.getSignature().toString())
												   .bgRed()
												   .bold()
												   .toString() + Chalk.on("]").bgBlue().bold());

		Optional.ofNullable(result)
				.ifPresent(c -> System.out.println(Chalk.on("[").blue().bold().toString() + Chalk.on(getCurrentTime())
																								 .yellow()
																								 .bold()
																								 .toString() + Chalk.on("] Customer ")
																													.blue()
																													.bold()
																													.toString() + Chalk.on(c.toString())
																																	   .yellow()
																																	   .bold()
																																	   .toString() + Chalk.on(" has been retrieved from database")
																																						  .blue()
																																						  .bold()));
	}

	@AfterThrowing(pointcut = "forGetByIdMethod() && args(id)", throwing = "throwable")
	public void adviceAfterThrowingExceptionTryingToGetCustomerByIdFromDatabase(int id, Throwable throwable) {
		System.out.println(Chalk.on("[").blue().bold().toString() +
							   Chalk.on(getCurrentTime())
									.yellow().bold().toString() +
							   Chalk.on("] Failed to retrieve Customer with id=")
									.blue().bold().toString() +
							   Chalk.on(String.valueOf(id))
									.yellow().bold().toString() +
							   Chalk.on(" because it doesn't exist. Exception message:[")
									.blue().bold().toString() +
							   Chalk.on(throwable.getMessage())
									.red().bold().toString() +
							   Chalk.on("]")
									.blue().bold());
	}

	@After(value = "forGetByIdMethod()")
	public void adviceAfterGetCustomerByIdFromDatabase(JoinPoint joinPoint) {
		System.out.println(Chalk.on("[").bold().bold().toString() +
							   Chalk.on(getCurrentTime())
									.yellow().bold().toString() +
							   Chalk.on("] Method ")
									.blue().bold().toString() +
							   Chalk.on(joinPoint.getSignature().toString())
									.yellow().bold().toString() +
							   Chalk.on(" completed it execution")
									.blue().bold());
	}

	@Around(value = "forGetByIdMethod() && args(id)")
	public Object adviceAround(ProceedingJoinPoint proceedingJoinPoint, int id) throws Throwable {
		Object result;

		try {
			long begin = System.currentTimeMillis();

			result = proceedingJoinPoint.proceed();

			long end = System.currentTimeMillis();

			logger.info(" Method " + proceedingJoinPoint.getSignature()
														.toShortString() + " finished in " + (end - begin) + " ms.");

			return result;
		} catch (CustomerNotFoundException e) {
			logger.warning("Method " + proceedingJoinPoint.getSignature().toShortString() + " threw an exception [" + e.getMessage() + "]");

			throw e;
		}

	}

	@Before("execution(public void me.mikholskiy.daos.CustomerDao.save(me.mikholskiy.domains.Customer))")
	public void adviceBeforeSavingCustomerInDao() {
		System.out.println(Chalk.on("[").blue().bold().toString() +
							   Chalk.on(getCurrentTime())
									.yellow().bold().toString() +
							   Chalk.on("] Customer has been saved in database")
									.blue()
									.bold());
	}
}
