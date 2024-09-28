package com.assignment.fancode;


import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import util.constants.Constants;
import util.TestUtil;
import org.apache.http.HttpStatus;
import util.pojos.getTodoPOJO;
import util.pojos.getUsersPOJO;


import java.io.IOException;
import java.lang.reflect.Method;

import static io.restassured.RestAssured.*;

public class FanCodeSDETTest extends BaseTest {

    String baseUrl = null;

    @BeforeClass
    void beforeClass() throws IOException {
        LOGGER.info(String.format("Inside %s", new Object() {
        }.getClass().getName()));
        baseUrl = TestUtil.getRoutes("baseurl");
    }

    @BeforeMethod
    void beforeMethod(Method method) {
        LOGGER.info(String.format("Inside %s", new Object() {
        }.getClass().getEnclosingMethod().getName()));
    }

    @Test(priority = 1,
            description = "Validate if all the users of City `FanCode` should have more than half of their todos task completed.")
    void validateCityFanCodeTasks() throws IOException, JSONException {

        SoftAssert softAssert = new SoftAssert();

        //getting the list of all the users
        Response userDataResponse = given()
                .when()
                .get(baseUrl + TestUtil.getRoutes("users"));

        Assert.assertEquals(userDataResponse.getStatusCode(), HttpStatus.SC_OK,
                "Incorrect Response for Get User call");

        getUsersPOJO[] userDatas = userDataResponse.getBody().as(getUsersPOJO[].class);

        //iterating through all the users
        for (getUsersPOJO userData : userDatas) {
            int userId = userData.getId();
            double userLat = Double.parseDouble(userData.getAddress().getGeo().getLat());
            double userLng = Double.parseDouble(userData.getAddress().getGeo().getLng());

            LOGGER.info("************************************************************************");
            LOGGER.info(String.format("userId=%s userLat=%s userLng=%s", userId, userLat, userLng));

            if (userLat >= Constants.FANCODE_START_LAT && userLat <= Constants.FANCODE_END_LAT &&
                    userLng >= Constants.FANCODE_START_LNG && userLng <= Constants.FANCODE_END_LNG) {

                LOGGER.info(String.format("Getting the Todo status of user %s who is a resident of FanCode city", userId));

                //getting the list of all the todos status for a particular user
                Response userTodoResponse = given()
                        .queryParam("userId", userId)
                        .when()
                        .get(baseUrl + TestUtil.getRoutes("todos"));

                Assert.assertEquals(userDataResponse.getStatusCode(), HttpStatus.SC_OK,
                        "Incorrect Response for Get Todo status call");

                getTodoPOJO[] todoDatas = userTodoResponse.getBody().as(getTodoPOJO[].class);

                //iterating through all the tasks and calculating the completed tasks
                int totalTodos = todoDatas.length, totalCompleted = 0;
                double completedPercentage = 0;
                for (getTodoPOJO todoData : todoDatas) {
                    boolean status = todoData.isCompleted();
                    if (status) {
                        totalCompleted++;
                    }
                }

                LOGGER.info(String.format("Total Tasks=%s, Completed Tasks=%s", totalTodos, totalCompleted));

                //calculating the percentage of completed tasks
                try {
                    completedPercentage = (double) totalCompleted / totalTodos * 100;
                } catch (ArithmeticException e) {
                    LOGGER.error("Error while calculating completed percentage", e);
                }

                LOGGER.info(String.format("Completed Percentage=%.2f", completedPercentage));
                softAssert.assertTrue(completedPercentage > Constants.COMPLETED_PASS_PERCENTAGE,
                        String.format("User %s of city FanCode doesn't have more than %s of its todo task completed",
                                userId, Constants.COMPLETED_PASS_PERCENTAGE));
            }
        }
        softAssert.assertAll();
        LOGGER.info("*************************************************************************");
    }

    @AfterClass
    void afterClass() {
        LOGGER.info(String.format("Completed %s", new Object() {
        }.getClass().getName()));
    }
}
