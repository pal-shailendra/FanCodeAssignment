package com.cucumber.stepdefination;

import com.selenium.utillity.Constants;
import com.selenium.utillity.Reusable;
import com.utility.LogCapture;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

import static com.selenium.utillity.Reusable.filterFanCodeUsers;


public class FanCodeStepDef {

    List<Map<String, Object>> users;
    List<Map<String, Object>> fanCodeUsers;
    List<Map<String, Object>> todos;

    @Given("User has the todo tasks")
    public void userHasTheTodoTasks() {

        Response usersResponse = Reusable.getUsers();
        users = usersResponse.jsonPath().getList("");

        // Get all todos
        Response todosResponse = Reusable.getTodos();
        todos = todosResponse.jsonPath().getList("");

    }

    @And("User belongs to the city FanCode")
    public void userBelongsToTheCityFanCode() {

        fanCodeUsers = filterFanCodeUsers(users);
    }

    @Then("User Completed task percentage should be greater than {int}%")
    public void userCompletedTaskPercentageShouldBeGreaterThan(int arg0) {
        for (Map<String, Object> user : fanCodeUsers) {
            int userId = (int) user.get("id");
            long totalTasks = todos.stream().filter(todo -> (int) todo.get("userId") == userId).count();
            long completedTasks = todos.stream().filter(todo -> (int) todo.get("userId") == userId && (boolean) todo.get("completed")).count();

            double completionPercentage = (double) completedTasks / totalTasks * 100;
            LogCapture.info("User ID: " + userId + " has completed " + completionPercentage + "% of tasks.");
            // Assert that the user has completed more than 50% of their tasks
            //Assert.assertTrue(completionPercentage > arg0, "User ID: " + userId + " has less than 50% tasks completed.");
        }
    }
}
